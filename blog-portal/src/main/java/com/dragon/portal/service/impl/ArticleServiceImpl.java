package com.dragon.portal.service.impl;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.DictUtils;
import com.dragon.common.utils.markdown.MarkdownHelper;
import com.dragon.common.utils.markdown.MarkdownStatsUtil;
import com.dragon.portal.domain.*;
import com.dragon.portal.event.ReadArticleEvent;
import com.dragon.portal.event.UpdateArticleEvent;
import com.dragon.portal.mapper.*;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import com.dragon.portal.service.IArticleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章信息Service业务层处理
 *
 * @author dragon
 * @date 2022-05-08
 */
@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ISysFileService iSysFileService;

    @Autowired
    private ArticleMapper articleMapper;
    
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 查询文章信息
     *
     * @param articleId 文章信息主键
     * @return 文章信息
     */
    @Override
    public Article selectArticleByArticleId(Long articleId) {
        // 获取文章信息
        Article article = articleMapper.selectArticleByArticleId(articleId);
        if (Objects.isNull(article)) {
            log.warn("==> 查询的文章不存在，articleId: {}", articleId);
            throw new RuntimeException("该文章不存在！");
        }
        // 获取封面URL
        if(article != null && article.getCover() != null){
            SysFile sysFile = iSysFileService.selectSysFileByFileId(article.getCover());
            if(sysFile != null){
                article.setCoverUrl(sysFile.getFileUrl());
            }
        }
        // 获取文章所属分类
        ArticleCategoryRel articleCategoryRel = articleCategoryRelMapper.selectByArticleId(articleId);
        if (Objects.nonNull(articleCategoryRel)) {
            article.setArticleCategoryId(articleCategoryRel.getCategoryId());
        }
        // 获取文章对应标签
        ArticleTagRel articleTagRel = new ArticleTagRel();
        articleTagRel.setArticleId(articleId);
        List<ArticleTagRel> articleTagRelList = articleTagRelMapper.selectArticleTagRelList(articleTagRel);
        if (CollectionUtil.isNotEmpty(articleTagRelList)) {
            List<String> tagIds = articleTagRelList.stream().map(e -> String.valueOf(e.getTagId())).collect(Collectors.toList());
            article.setArticleTags(tagIds);
        }
        return article;
    }

    /**
     * 查询文章信息列表
     *
     * @param article 文章信息
     * @return 文章信息
     */
    @Override
    public List<Article> selectArticleList(Article article) {
        List<Article> articleList = articleMapper.selectArticleList(article);
        for (Article articleVo : articleList) {
            String articleTypeStr = DictUtils.getDictLabel("portal_article_type", articleVo.getArticleType());
            articleVo.setArticleTypeStr(articleTypeStr);
            String publishTypeStr = DictUtils.getDictLabel("portal_article_publish_type", articleVo.getPublishType());
            articleVo.setPublishTypeStr(publishTypeStr);
            String contentLevelStr = DictUtils.getDictLabel("portal_article_content_level", articleVo.getContentLevel());
            articleVo.setContentLevelStr(contentLevelStr);
            String statusStr = DictUtils.getDictLabel("portal_article_status", articleVo.getStatus());
            articleVo.setStatusStr(statusStr);
            // 获取文章封面Url
            if(articleVo.getCover() != null){
                SysFile sysFile = iSysFileService.selectSysFileByFileId(articleVo.getCover());
                if(sysFile != null){
                    articleVo.setCoverUrl(sysFile.getFileUrl());
                }
            }
            articleVo.setIsTop(articleVo.getWeight() > 0);
            // 获取文章所属分类
            ArticleCategoryRel articleCategoryRel = articleCategoryRelMapper.selectByArticleId(articleVo.getArticleId());
            if (Objects.nonNull(articleCategoryRel)) {
                articleVo.setArticleCategoryId(articleCategoryRel.getCategoryId());
            }
            // 获取文章对应标签
            ArticleTagRel articleTagRel = new ArticleTagRel();
            articleTagRel.setArticleId(articleVo.getArticleId());
            List<ArticleTagRel> articleTagRelList = articleTagRelMapper.selectArticleTagRelList(articleTagRel);
            if (CollectionUtil.isNotEmpty(articleTagRelList)) {
                List<String> tagIds = articleTagRelList.stream().map(e -> String.valueOf(e.getTagId())).collect(Collectors.toList());
                articleVo.setArticleTags(tagIds);
            }
        }
        return articleList;
    }

    /**
     * 新增文章信息
     *
     * @param article 文章信息
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertArticle(Article article, LoginUser loginUser) {
        try {
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(article.getCoverUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            article.setCover(sysFile.getFileId());
            article.setCreateBy(loginUser.getUsername());
            article.setCreateTime(DateUtils.getNowDate());
            int count = articleMapper.insertArticle(article);
            // 拿到插入记录的主键 ID
            Long articleId = article.getArticleId();
            // 更新文章分类
            Long articleCategoryId = article.getArticleCategoryId();
            // 校验提交的分类是否真实存在
            ArticleCategory articleCategory = articleCategoryMapper.selectArticleCategoryById(articleCategoryId);
            if (Objects.isNull(articleCategory)) {
                log.warn("==> 分类不存在, categoryId: {}", articleCategoryId);
                throw new RuntimeException("该文章分类不存在！");
            }

            // 插入文章分类关联表
            ArticleCategoryRel articleCategoryRel = new ArticleCategoryRel();
            articleCategoryRel.setArticleId(articleId);
            articleCategoryRel.setCategoryId(articleCategoryId);
            articleCategoryRelMapper.insertArticleCategoryRel(articleCategoryRel);
            // 保存文章关联的标签集合
            List<String> publishTags = article.getArticleTags();
            insertArticleTags(articleId, publishTags, loginUser);

            // 发布文章
            if (Objects.equals("0", article.getStatus())) {
                // 发送文章发布事件
                eventPublisher.publishEvent(new UpdateArticleEvent(this, Arrays.asList(articleId), 1));
            }
            return count;
        } catch (Exception e) {
            throw new RuntimeException("新增失败！");
        }
    }

    /**
     * 修改文章信息
     *
     * @param article 文章信息
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateArticle(Article article, LoginUser loginUser) {
        // 文章ID
        Long articleId = article.getArticleId();
        // 1、保存文章封面并返回封面ID
        if(article.getCover() == null || Objects.equals(0, article.getCover())){
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(article.getCoverUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            article.setCover(sysFile.getFileId());
        }
        // 2、保存文章信息
        article.setUpdateBy(loginUser.getUsername());
        article.setUpdateTime(DateUtils.getNowDate());
        int count = articleMapper.updateArticle(article);
        // 根据更新是否成功，来判断该文章是否存在
        if (Objects.equals(0, count)) {
            log.warn("==> 该文章不存在, articleId: {}", articleId);
            throw new RuntimeException("该文章不存在！");
        }
        // 3、更新文章分类
        Long articleCategoryId = article.getArticleCategoryId();
        // 3.1、校验提交的分类是否真实存在
        ArticleCategory articleCategory = articleCategoryMapper.selectArticleCategoryById(articleCategoryId);
        if (Objects.isNull(articleCategory)) {
            log.warn("==> 分类不存在, categoryId: {}", articleCategoryId);
            throw new RuntimeException("该文章分类不存在！");
        }
        // 先删除该文章关联的分类记录，再插入新的关联关系
        articleCategoryRelMapper.deleteByArticleId(articleId);
        ArticleCategoryRel articleCategoryRel = new ArticleCategoryRel();
        articleCategoryRel.setCategoryId(articleCategoryId);
        articleCategoryRel.setArticleId(articleId);
        articleCategoryRelMapper.insertArticleCategoryRel(articleCategoryRel);
        // 4、先删除该文章对应的标签，再保存文章关联的标签集合
        articleTagRelMapper.deleteByArticleId(articleId);
        List<String> publishTags = article.getArticleTags();
        insertArticleTags(articleId, publishTags, loginUser);

        // 发送文章修改事件
        eventPublisher.publishEvent(new UpdateArticleEvent(this, Arrays.asList(articleId), 2));
        return count;
    }

    /**
     * 批量删除文章信息
     *
     * @param articleIds 需要删除的文章信息主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteArticleByArticleIds(Long[] articleIds, LoginUser loginUser) {
        Date nowDate = DateUtils.getNowDate();
        // 批量删除文章
        int count = articleMapper.deleteArticleByArticleIds(articleIds, loginUser.getUsername(), nowDate);
        // 文章软删除无需删除分类和标签关联关系
        // if (count > 0) {
        //     // 批量删除文章分类关联表
        //     articleCategoryRelMapper.deleteArticleCategoryRelByArticleIds(articleIds);
        //     // 批量删除文章标签关联表
        //     articleTagRelMapper.deleteArticleTagRelByArticleIds(articleIds);
        // }
        // 发送文章修改事件
        eventPublisher.publishEvent(new UpdateArticleEvent(this, Arrays.asList(articleIds), 3));
        return count;
    }

    /**
     * 删除文章信息信息
     *
     * @param articleId 文章信息主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    public int deleteArticleByArticleId(Long articleId, LoginUser loginUser) {
        Date nowDate = DateUtils.getNowDate();
        return articleMapper.deleteArticleByArticleId(articleId, loginUser.getUsername(), nowDate);
    }

    /**
     * 更新文章置顶状态
     * @param articleId
     * @param isTop
     * @param loginUser
     * @return
     */
    @Override
    public int updateArticleIsTop(Long articleId, Boolean isTop, LoginUser loginUser) {
        // 默认权重为 0
        Integer weight = 0;
        // 若设置为置顶
        if (isTop) {
            // 查询出表中最大的权重值
            Integer maxWeight = articleMapper.selectMaxWeight();
            // 最大权重值加一
            weight = maxWeight + 1;
        }
        // 更新该篇文章的权重值
        Article article = new Article();
        article.setArticleId(articleId);
        article.setWeight(weight);
        article.setUpdateBy(loginUser.getUsername());
        article.setUpdateTime(DateUtils.getNowDate());
        return articleMapper.updateArticle(article);
    }

    /**
     * 获取首页文章分页数据
     * @param article
     * @return
     */
    @Override
    public List<Article> getArticlePageList(Article article) {
        article.setPublishType("1");
        article.setStatus("0");
        // 第一步：分页查询文章主体记录
        List<Article> articleList = this.selectArticleList(article);
        // 第二步：设置文章所属分类
        // 查询所有文章分类
        List<ArticleCategory> categoryDOS = articleCategoryMapper.selectArticleCategoryList(new ArticleCategory());
        // 转 Map, 方便后续根据分类 ID 拿到对应的分类名称
        Map<Long, String> categoryIdNameMap = categoryDOS.stream().collect(Collectors.toMap(ArticleCategory::getCategoryId, ArticleCategory::getName));
        // 第三步：设置文章标签
        // 查询所有标签
        List<ArticleTag> tagDOS = articleTagMapper.selectArticleTagList(new ArticleTag());
        // 转 Map, 方便后续根据标签 ID 拿到对应的标签名称
        Map<Long, String> tagIdNameMap = tagDOS.stream().collect(Collectors.toMap(ArticleTag::getTagId, ArticleTag::getName));
        articleList.forEach(vo -> {
            setArticleCategoryTag(vo, categoryIdNameMap, tagIdNameMap);
        });
        return articleList;
    }

    /**
     * 获取文章归档分页数据
     * @return
     */
    @Override
    public List<ArchiveArticle> getArchivePageList() {
        Article article = new Article();
        article.setPublishType("1");
        article.setStatus("0");
        List<Article> articleList = this.selectArticleList(article);
        List<ArchiveArticle> vos = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(articleList)) {
            articleList.stream().forEach(item -> {
                item.setCreateMonth(YearMonth.from(DateUtils.toLocalDateTime(item.getCreateTime())));
            });
            Map<YearMonth, List<Article>> map = articleList.stream().collect(Collectors.groupingBy(Article::getCreateMonth));
            // 使用 TreeMap 按月份倒序排列
            Map<YearMonth, List<Article>> sortedMap = new TreeMap<>(Collections.reverseOrder());
            sortedMap.putAll(map);
            // 遍历排序后的 Map，将其转换为归档 VO
            sortedMap.forEach((k, v) -> vos.add(ArchiveArticle.builder().month(k).articles(v).build()));
        }
        return vos;
    }

    /**
     * 根据文章ID获取文章详细信息
     * @param articleId 文章信息主键
     * @return
     */
    @Override
    public Article getArticleInfo(Long articleId) {
        Article article = this.selectArticleByArticleId(articleId);
        String content = article.getContent();
        // 计算 md 正文字数
        Integer totalWords = MarkdownStatsUtil.calculateWordCount(content);
        article.setTotalWords(totalWords);

        // 计算阅读时间
        article.setReadTime(MarkdownStatsUtil.calculateReadingTime(totalWords));

        article.setContentHtml(MarkdownHelper.convertMarkdown2Html(content));

        // 查询所有文章分类
        List<ArticleCategory> categoryDOS = articleCategoryMapper.selectArticleCategoryList(new ArticleCategory());
        // 转 Map, 方便后续根据分类 ID 拿到对应的分类名称
        Map<Long, String> categoryIdNameMap = categoryDOS.stream().collect(Collectors.toMap(ArticleCategory::getCategoryId, ArticleCategory::getName));
        // 查询所有标签
        List<ArticleTag> tagDOS = articleTagMapper.selectArticleTagList(new ArticleTag());
        // 转 Map, 方便后续根据标签 ID 拿到对应的标签名称
        Map<Long, String> tagIdNameMap = tagDOS.stream().collect(Collectors.toMap(ArticleTag::getTagId, ArticleTag::getName));
        setArticleCategoryTag(article, categoryIdNameMap, tagIdNameMap);
        // 上一篇
        article.setPreArticle(articleMapper.selectPreArticle(articleId));
        // 下一篇
        article.setNextArticle(articleMapper.selectNextArticle(articleId));
        // 发布文章阅读事件
        eventPublisher.publishEvent(new ReadArticleEvent(this, articleId));
        return article;
    }

    /**
     * 设置文章分类和标签信息
     * @param article
     * @param categoryIdNameMap
     * @param tagIdNameMap
     */
    private void setArticleCategoryTag(Article article, Map<Long, String> categoryIdNameMap, Map<Long, String> tagIdNameMap) {
        if (Objects.nonNull(article.getArticleCategoryId())) {
            // 设置当前文章分类信息
            ArticleCategory articleCategory = new ArticleCategory();
            articleCategory.setCategoryId(article.getArticleCategoryId());
            articleCategory.setName(categoryIdNameMap.get(article.getArticleCategoryId()));
            article.setCategory(articleCategory);
        }
        if (CollectionUtil.isNotEmpty(article.getArticleTags())) {
            List<ArticleTag> articleTags = new ArrayList<>();
            article.getArticleTags().forEach(tagId -> {
                // 设置当前文章标签信息
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(Long.valueOf(tagId));
                articleTag.setName(tagIdNameMap.get(Long.valueOf(tagId)));
                articleTags.add(articleTag);
            });
            article.setTags(articleTags);
       }
    }

    /**
     * 保存文章标签
     *
     * @param articleId
     * @param publishTags
     * @param loginUser
     */
    private void insertArticleTags(Long articleId, List<String> publishTags, LoginUser loginUser) {
        // 筛选提交的标签（表中不存在的标签）
        List<String> notExistTags = null;
        // 筛选提交的标签（表中已存在的标签）
        List<String> existedTags = null;
        // 查询出所有标签
        List<ArticleTag> articleTags = articleTagMapper.selectArticleTagList(new ArticleTag());
        if (CollectionUtil.isEmpty(articleTags)) {
            notExistTags = publishTags;
        } else {
            List<String> tagIds = articleTags.stream().map(e -> String.valueOf(e.getTagId())).collect(Collectors.toList());
            // 通过标签 ID 来筛选，包含对应 ID 则表示提交的标签是表中存在的
            existedTags = publishTags.stream().filter(publishTag -> tagIds.contains(publishTag)).collect(Collectors.toList());
            // 否则则是不存在的
            notExistTags = publishTags.stream().filter(publishTag -> !tagIds.contains(publishTag)).collect(Collectors.toList());
            // 还有一种可能：按字符串名称提交上来的标签，也有可能是表中已存在的，比如表中已经有了 Java 标签，用户提交了个 java 小写的标签，需要内部装换为 Java 标签
            Map<String, Long> tagNameIdMap = articleTags.stream().collect(Collectors.toMap(tagDO -> tagDO.getName().toLowerCase(), ArticleTag::getTagId));
            // 使用迭代器进行安全的删除操作
            Iterator<String> iterator = notExistTags.iterator();
            while (iterator.hasNext()) {
                String notExistTag = iterator.next();
                // 转小写, 若 Map 中相同的 key，则表示该新标签是重复标签
                if (tagNameIdMap.containsKey(notExistTag.toLowerCase())) {
                    // 从不存在的标签集合中清除
                    iterator.remove();
                    // 并将对应的 ID 添加到已存在的标签集合
                    existedTags.add(String.valueOf(tagNameIdMap.get(notExistTag.toLowerCase())));
                }
            }
            // 将提交的上来的，已存在于表中的标签，文章-标签关联关系入库
            if (CollectionUtil.isNotEmpty(existedTags)) {
                List<ArticleTagRel> articleTagRelDOS = Lists.newArrayList();
                existedTags.forEach(existedTag -> {
                    ArticleTagRel articleTagRelDO = new ArticleTagRel();
                    articleTagRelDO.setArticleId(articleId);
                    articleTagRelDO.setTagId(Long.valueOf(existedTag));
                    articleTagRelDOS.add(articleTagRelDO);
                });
                // 批量插入文章-标签关联关系
                articleTagRelMapper.insertBatchArticleTagRel(articleTagRelDOS);
            }
            // 将提交的上来的，不存在于表中的标签，入库保存
            if (CollectionUtil.isNotEmpty(notExistTags)) {
                // 需要先将标签入库，拿到对应标签 ID 后，再把文章-标签关联关系入库
                List<ArticleTagRel> articleTagRelDOS = Lists.newArrayList();
                notExistTags.forEach(tagName -> {
                    ArticleTag tagDO = new ArticleTag();
                    tagDO.setName(tagName);
                    tagDO.setCreateBy(loginUser.getUsername());
                    tagDO.setCreateTime(DateUtils.getNowDate());
                    articleTagMapper.insertArticleTag(tagDO);
                    // 拿到保存的标签 ID
                    Long tagId = tagDO.getTagId();
                    // 文章-标签关联关系
                    ArticleTagRel articleTagRelDO = new ArticleTagRel();
                    articleTagRelDO.setArticleId(articleId);
                    articleTagRelDO.setTagId(tagId);
                    articleTagRelDOS.add(articleTagRelDO);
                });
                // 批量插入
                articleTagRelMapper.insertBatchArticleTagRel(articleTagRelDOS);
            }
        }
    }
}
