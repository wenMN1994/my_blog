<template>
  <div class="app-container" style="max-height: calc(100vh - 84px);">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="文章标题" prop="articleTitle">
        <el-input
          v-model="queryParams.articleTitle"
          placeholder="请输入文章标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文章类型" prop="articleType">
        <el-select v-model="queryParams.articleType" placeholder="请选择文章类型" clearable>
          <el-option
            v-for="dict in dict.type.portal_article_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="发布形式" prop="publishType">
        <el-select v-model="queryParams.publishType" placeholder="请选择发布形式" clearable>
          <el-option
            v-for="dict in dict.type.portal_article_publish_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="内容等级" prop="contentLevel">
        <el-select v-model="queryParams.contentLevel" placeholder="请选择内容等级" clearable>
          <el-option
            v-for="dict in dict.type.portal_article_content_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="文章状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择文章状态" clearable>
          <el-option
            v-for="dict in dict.type.portal_article_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5" v-if="!showAddOrUpdate">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['portal:article:add']"
        >发表文章</el-button>
      </el-col>
      <el-col :span="1.5" v-if="showAddOrUpdate">
        <el-button
          type="primary"
          plain
          icon="el-icon-refresh-left"
          size="mini"
          @click="handleReturn"
        >返回</el-button>
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          @click="handleSaveDraft"
        >保存草稿</el-button>
        <el-button
          type="warning"
          plain
          icon="el-icon-s-promotion"
          size="mini"
          @click="handlePublishArticle"
        >发布文章</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList()"></right-toolbar>
    </el-row>

    <add-or-update
      :articleData="articleData"
      @setdata="setdata"
      ref="addUpdate"
      v-if="showAddOrUpdate">
    </add-or-update>
    
    <div class="infinite-list-wrapper article-list"
      v-if="!showAddOrUpdate"
      :style="{height:scrollerHeight}">
      <ul
        class="list"
        v-infinite-scroll="loadMore"
        infinite-scroll-disabled="disabled"
        infinite-scroll-distance="21">
        <li v-for="(articleItem, index) in articleList" :key="index" class="list-item">
          <table cellspacing="0" style="width: 100%;table-layout:fixed;">
            <tbody>
              <tr>
                <td colspan="3" class="el-table__cell is-leaf">
                  <p class="cell title">
                    <a @click="handleUpdate(articleItem.articleId)" title="编辑">{{articleItem.articleTitle}}</a>
                  </p>
                </td>
                <td colspan="1" class="el-table__cell is-leaf" style="text-align: right;">
                  <p class="cell date-time">{{articleItem.createTime}}</p>
                </td>
              </tr>
              <tr>
                <td colspan="4" class="el-table__cell is-leaf">
                  <span class="cell cell-flag">
                    <el-tag size="small">{{articleItem.articleTypeStr}}</el-tag>
                  </span>
                  <span class="cell cell-flag">
                    <el-tag type="success" size="small">{{articleItem.contentLevelStr}}</el-tag>
                  </span>
                  <span class="cell cell-flag">
                    <el-tag type="warning" size="small">{{articleItem.publishTypeStr}}</el-tag>
                  </span>
                  <span class="cell cell-flag">
                    <el-tag type="danger" size="small">{{articleItem.statusStr}}</el-tag>
                  </span>
                </td>
              </tr>
              <tr>
                <td colspan="3" class="el-table__cell is-leaf">
                  <p class="cell data-info">展现量0 · 阅读0 · 评论0 · 收藏0</p>
                </td>
                <td colspan="1" class="el-table__cell is-leaf" style="text-align: right;">
                  <p class="cell">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-view"
                      @click="handleView(articleItem.articleId)"
                      v-hasPermi="['portal:article:view']"
                    >浏览</el-button>
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-edit"
                      @click="handleUpdate(articleItem.articleId)"
                      v-hasPermi="['portal:article:edit']"
                    >修改</el-button>
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-delete"
                      @click="handleDelete(articleItem.articleId,articleItem.articleTitle)"
                      v-hasPermi="['portal:article:remove']"
                    >删除</el-button>
                  </p>
                </td>
              </tr>
            </tbody>
          </table>
        </li>
      </ul>
      <p class="load-txt" v-if="loading">加载中...</p>
      <p class="load-txt" v-if="noMore">没有更多了</p>
    </div>
    

    <!-- 添加或修改文章信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" :close-on-click-modal="false" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="文章标题" prop="articleTitle">
          <el-input v-model="form.articleTitle" placeholder="请输入文章标题" />
        </el-form-item>
        <el-form-item label="文章类型" prop="articleType">
          <el-radio-group v-model="form.articleType">
            <el-radio
              v-for="dict in dict.type.portal_article_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="封面" prop="coverUrl">
          <image-upload :limit="limit" v-model="form.coverUrl"/>
        </el-form-item>
        <el-form-item label="摘要信息" prop="summary">
          <el-input v-model="form.summary" type="textarea" placeholder="请输入摘要信息" />
        </el-form-item>
        <el-form-item label="发布形式" prop="publishType">
          <el-radio-group v-model="form.publishType">
            <el-radio
              v-for="dict in dict.type.portal_article_publish_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="内容等级" prop="contentLevel">
          <el-radio-group v-model="form.contentLevel">
            <el-radio
              v-for="dict in dict.type.portal_article_content_level"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listArticle, getArticle, delArticle, addArticle, updateArticle } from "@/api/portal/article";
import AddOrUpdate from "./addOrUpdate.vue";
export default {
  components: {
    AddOrUpdate
  },
  name: "Article",
  dicts: ['portal_article_status', 'portal_article_content_level', 'portal_article_publish_type', 'portal_article_type'],
  data() {
    return {
      limit: 1,
      // 编辑记录
      articleData: {},
      // 显示新增或编辑
      showAddOrUpdate: false,
      // 遮罩层
      loading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 文章信息表格数据
      articleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        articleTitle: null,
        articleType: null,
        publishType: null,
        contentLevel: null,
        status: null,
      },
      // 表单参数
      form: {content: null},
      // 表单校验
      rules: {
        articleTitle: [
          { required: true, message: "文章标题不能为空", trigger: "blur" }
        ],
        articleType: [
          { required: true, message: "文章类型不能为空", trigger: "blur" }
        ],
        coverUrl: [
          { required: true, message: "封面不能为空", trigger: "blur" }
        ],
        summary: [
          { required: true, message: "摘要信息不能为空", trigger: "blur" }
        ],
        publishType: [
          { required: true, message: "发布形式不能为空", trigger: "blur" }
        ],
        contentLevel: [
          { required: true, message: "内容等级不能为空", trigger: "blur" }
        ],
      }
    };
  },
  computed: {
    noMore () {
      return this.articleList.length >= this.total
    },
    disabled () {
      return this.loading || this.noMore
    },
    scrollerHeight(){
      let height = "";
      if(this.showSearch){
        // let queryFormHeight = this.$refs.queryForm.offsetHeight;
        let queryFormHeight = 100 + 140;
        height = 'calc(100vh - '+queryFormHeight+'px)';
      }else{
        height = 'calc(100vh - 140px)';
      }
      return height;
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 滚动翻页 */
    loadMore(){
      this.loading = true;
      setTimeout(() => {  // 发送请求有时间间隔第一个滚动时间结束后才发送第二个请求
        this.pageNum++;  // 滚动之后加载第二页
        this.getList(true);
      }, 1000);	   
    },
    /** 查询文章信息列表 */
    getList(flag) {
      listArticle(this.queryParams).then(response => {
        if(flag){//如果flag为true则表示分页
          this.articleList = this.articleList.concat(response.rows);
        }else{
          this.articleList = response.rows;
        }
        this.total = response.total;
        this.loading = false;
      }).catch(() => {
        this.articleList = [];
        this.total = 0;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        articleId: null,
        articleTitle: null,
        articleType: "1",
        cover: null,
        coverUrl: null,
        summary: null,
        publishType: "1",
        contentLevel: "1",
        status: null,
        content: null,
        contentHtml: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.showSearch = false;
      this.showAddOrUpdate = true;
    },
    /**返回按钮操作 */
    handleReturn() {
      this.articleData = {};
      this.showSearch = true;
      this.showAddOrUpdate = false;
      this.getList();
    },
    /**保存草稿操作 */
    handleSaveDraft() {
      /**调用子页面方法触发数据回传到父页面 */
      this.$refs.addUpdate.getContext();
      this.form.status = "2";
      if(!this.form.content){
        this.$modal.msgError("文章内容不能为空！");
        return false;
      }
      this.open = true;
      this.title = "发布文章";
    },
    /**发布文章操作 */
    handlePublishArticle(){
      /**调用子页面方法触发数据回传到父页面 */
      this.$refs.addUpdate.getContext();
      this.form.status = "0";
      if(!this.form.content){
        this.$modal.msgError("文章内容不能为空！");
        return false;
      }
      this.open = true;
      this.title = "发布文章";
    },
    /**接收子页面参数 data可用json传多个参数 */
    setdata: function(data) {
      this.form.content = data.content;
      this.form.contentHtml = data.contentHtml;
    },
    /** 浏览按钮操作 */
    handleView(articleId) {
      this.$modal.msgWarning("功能待开发...");
    },
    /** 修改按钮操作 */
    handleUpdate(articleId) {
      this.reset();
      this.showSearch = false;
      getArticle(articleId).then(response => {
        this.form = response.data;
        this.articleData = response.data;
        this.showAddOrUpdate = true;
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.articleId != null) {
            updateArticle(this.form).then(response => {
              this.$modal.msgSuccess("发布成功");
              this.open = false;
              this.handleReturn();
            });
          } else {
            addArticle(this.form).then(response => {
              this.$modal.msgSuccess("发布成功");
              this.open = false;
              this.handleReturn();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(articleId,articleTitle) {
      this.$modal.confirm('是否确认删除文章【' + articleTitle + '】？').then(function() {
        return delArticle(articleId);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('portal/article/export', {
        ...this.queryParams
      }, `article_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style scoped>
.list{
  margin: 0px;
  padding: 0px;
}
.list-item{
  border-bottom: 1px solid #dfe6ec;
  padding: 5px 0px;
}
.list, .list-item{
  list-style:none;
}
.title{
  text-align: left;
  color: #555666;
}
.date-time, .data-info{
  color: #999aaa;
}
.cell{
  margin: 5px 0px;
}
.title:hover a {
    color: #fc5531;
}
.load-txt{
  text-align: center;
  color: #999aaa;
}
.cell-flag{
  padding-right: 5px;
}
.article-list{
  overflow-y:visible;
  overflow-x:hidden;
}
</style>
