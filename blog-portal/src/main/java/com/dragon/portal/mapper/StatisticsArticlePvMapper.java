package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.StatisticsArticlePv;

/**
 * 统计 - 文章 PV (浏览量)Mapper接口
 * 
 * @author dragon
 * @date 2024-07-20
 */
public interface StatisticsArticlePvMapper {
    /**
     * 查询统计 - 文章 PV (浏览量)
     * 
     * @param id 统计 - 文章 PV (浏览量)主键
     * @return 统计 - 文章 PV (浏览量)
     */
    public StatisticsArticlePv selectStatisticsArticlePvById(String id);

    /**
     * 查询统计 - 文章 PV (浏览量)列表
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 统计 - 文章 PV (浏览量)集合
     */
    public List<StatisticsArticlePv> selectStatisticsArticlePvList(StatisticsArticlePv statisticsArticlePv);

    /**
     * 新增统计 - 文章 PV (浏览量)
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 结果
     */
    public int insertStatisticsArticlePv(StatisticsArticlePv statisticsArticlePv);

    /**
     * 修改统计 - 文章 PV (浏览量)
     * 
     * @param statisticsArticlePv 统计 - 文章 PV (浏览量)
     * @return 结果
     */
    public int updateStatisticsArticlePv(StatisticsArticlePv statisticsArticlePv);

    /**
     * 删除统计 - 文章 PV (浏览量)
     * 
     * @param id 统计 - 文章 PV (浏览量)主键
     * @return 结果
     */
    public int deleteStatisticsArticlePvById(String id);

    /**
     * 批量删除统计 - 文章 PV (浏览量)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStatisticsArticlePvByIds(String[] ids);

    /**
     * 当日文章 PV 访问量 +1
     * @param statisticsArticlePv
     * @return
     */
    public int increasePVCount(StatisticsArticlePv statisticsArticlePv);
}
