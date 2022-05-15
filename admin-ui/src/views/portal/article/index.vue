<template>
  <div class="app-container">
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
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['portal:article:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['portal:article:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['portal:article:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <add-or-update v-if="showAddOrUpdate"></add-or-update>

    <div class="infinite-list-wrapper"
      v-if="!showAddOrUpdate"
      style="overflow-y:auto;overflow-x:hidden;">
      <ul
        class="list"
        v-infinite-scroll="getList"
        infinite-scroll-disabled="disabled">
        <li v-for="(countItem, index) in count" :key="index" class="list-item">
          <table cellspacing="0" style="width: 100%;table-layout:fixed;">
            <tbody>
              <tr>
                <td colspan="3" class="el-table__cell is-leaf">
                  <p class="cell title">
                    <a href="https://editor.csdn.net/md/?articleId=114834755" title="编辑">文章标题{{countItem}}</a>
                  </p>
                </td>
                <td colspan="1" class="el-table__cell is-leaf" style="text-align: right;">
                  <p class="cell date-time">2022-05-07 22:40:50</p>
                </td>
              </tr>
              <tr>
                <td colspan="4" class="el-table__cell is-leaf">
                  <p class="cell"><el-tag size="small">原创</el-tag></p>
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
                      @click="handleView(scope.row)"
                      v-hasPermi="['portal:article:view']"
                    >浏览</el-button>
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-edit"
                      @click="handleUpdate(scope.row)"
                      v-hasPermi="['portal:article:edit']"
                    >修改</el-button>
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-delete"
                      @click="handleDelete(scope.row)"
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

    <!-- <el-table v-loading="loading" :data="articleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="文章ID" align="center" prop="articleId" />
      <el-table-column label="文章标题" align="center" prop="articleTitle" />
      <el-table-column label="文章类型" align="center" prop="articleType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.portal_article_type" :value="scope.row.articleType"/>
        </template>
      </el-table-column>
      <el-table-column label="封面" align="center" prop="cover" />
      <el-table-column label="摘要信息" align="center" prop="summary" />
      <el-table-column label="发布形式" align="center" prop="publishType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.portal_article_publish_type" :value="scope.row.publishType"/>
        </template>
      </el-table-column>
      <el-table-column label="内容等级" align="center" prop="contentLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.portal_article_content_level" :value="scope.row.contentLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="文章状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.portal_article_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="文章内容" align="center" prop="content" />
      <el-table-column label="更新者" align="center" prop="updateBy" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['portal:article:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['portal:article:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    /> -->

    <!-- 添加或修改文章信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="文章标题" prop="articleTitle">
          <el-input v-model="form.articleTitle" placeholder="请输入文章标题" />
        </el-form-item>
        <el-form-item label="文章类型">
          <el-radio-group v-model="form.articleType">
            <el-radio
              v-for="dict in dict.type.portal_article_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="封面">
          <image-upload v-model="form.cover"/>
        </el-form-item>
        <el-form-item label="摘要信息" prop="summary">
          <el-input v-model="form.summary" type="textarea" placeholder="请输入摘要信息" />
        </el-form-item>
        <el-form-item label="发布形式">
          <el-radio-group v-model="form.publishType">
            <el-radio
              v-for="dict in dict.type.portal_article_publish_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="内容等级">
          <el-radio-group v-model="form.contentLevel">
            <el-radio
              v-for="dict in dict.type.portal_article_content_level"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <!-- <el-form-item label="文章内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item> -->
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
      // 显示新增或编辑
      showAddOrUpdate: false,
      // 滚动加载计数
      count: 0,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
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
      form: {},
      // 表单校验
      rules: {
        articleTitle: [
          { required: true, message: "文章标题不能为空", trigger: "blur" }
        ],
        articleType: [
          { required: true, message: "文章类型不能为空", trigger: "change" }
        ],
        cover: [
          { required: true, message: "封面不能为空", trigger: "blur" }
        ],
        summary: [
          { required: true, message: "摘要信息不能为空", trigger: "blur" }
        ],
        publishType: [
          { required: true, message: "发布形式不能为空", trigger: "change" }
        ],
        contentLevel: [
          { required: true, message: "内容等级不能为空", trigger: "change" }
        ],
      }
    };
  },
  computed: {
    noMore () {
      return this.count >= this.total
    },
    disabled () {
      return this.loading || this.noMore
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询文章信息列表 */
    getList() {
      this.loading = true;
      listArticle(this.queryParams).then(response => {
        this.articleList = response.rows;
        this.total = response.total;
        this.count += this.articleList.length
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
        articleType: null,
        cover: null,
        summary: null,
        publishType: "0",
        contentLevel: null,
        status: null,
        content: null,
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.articleId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.showSearch = false;
      this.showAddOrUpdate = true;
    },
    // 返回按钮操作
    handleReturn() {
      this.showSearch = true;
      this.showAddOrUpdate = false;
    },
    // 保存草稿操作
    handleSaveDraft() {

    },
    // 发布文章操作
    handlePublishArticle(){
      this.reset();
      this.open = true;
      this.title = "发布文章";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const articleId = row.articleId || this.ids
      getArticle(articleId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文章信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.articleId != null) {
            updateArticle(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArticle(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const articleIds = row.articleId || this.ids;
      this.$modal.confirm('是否确认删除文章信息编号为"' + articleIds + '"的数据项？').then(function() {
        return delArticle(articleIds);
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
</style>
