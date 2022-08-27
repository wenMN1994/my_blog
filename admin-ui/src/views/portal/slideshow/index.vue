<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="网址" prop="linkUrl">
        <el-input
          v-model="queryParams.linkUrl"
          placeholder="请输入网址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="打开方式" prop="target">
        <el-select v-model="queryParams.target" placeholder="请选择打开方式" clearable>
          <el-option
            v-for="dict in dict.type.slideshow_open_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否有效" prop="isEnable">
        <el-select v-model="queryParams.isEnable" placeholder="请选择是否有效" clearable>
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['portal:slideshow:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['portal:slideshow:edit']"
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
          v-hasPermi="['portal:slideshow:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['portal:slideshow:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table 
      v-loading="loading" 
      :data="slideshowList" 
      @selection-change="handleSelectionChange" 
      :max-height="tableMaxHeight">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="轮播图" align="center" prop="slideshowImageUrl" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.slideshowImageUrl" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="副标题" align="center" prop="subTitle" />
      <el-table-column label="网址" align="center" prop="linkUrl" />
      <el-table-column label="打开方式" align="center" prop="target">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.slideshow_open_type" :value="scope.row.target"/>
        </template>
      </el-table-column>
      <el-table-column label="点击量" align="center" prop="clicks" />
      <el-table-column label="是否有效" align="center" prop="isEnable">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.isEnable"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['portal:slideshow:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['portal:slideshow:remove']"
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
    />

    <!-- 添加或修改轮播图管理对话框 -->
    <el-dialog 
      :title="title" 
      :visible.sync="open" 
      width="600px" 
      :close-on-click-modal="false" 
      append-to-body 
      class="scrollbar">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="轮播图" prop="slideshowImageUrl">
          <image-upload :limit="limit" :filePixel="filePixel" :listType="listType" v-model="form.slideshowImageUrl" />
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="副标题" prop="subTitle">
          <el-input v-model="form.subTitle" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="网址" prop="linkUrl">
          <el-input v-model="form.linkUrl" placeholder="请输入网址" />
        </el-form-item>
        <el-form-item label="打开方式">
          <el-radio-group v-model="form.target">
            <el-radio
              v-for="dict in dict.type.slideshow_open_type"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否有效" prop="isEnable">
          <el-select v-model="form.isEnable" placeholder="请选择是否有效">
            <el-option
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
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
import { listSlideshow, getSlideshow, delSlideshow, addSlideshow, updateSlideshow } from "@/api/portal/slideshow";

export default {
  name: "Slideshow",
  dicts: ['slideshow_open_type', 'sys_normal_disable'],
  data() {
    return {
      // table最大高度
      tableMaxHeight: 0,
      // 轮播图图片上传数量
      limit: 1,
      // 轮播图图片像素限制
      filePixel: [1920, 460],
      // 文件列表的类型 text/picture/picture-card
      listType: "picture-card",
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
      // 轮播图管理表格数据
      slideshowList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        subTitle: null,
        linkUrl: null,
        target: null,
        isEnable: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        slideshowImageUrl: [
          { required: true, message: "轮播图不能为空", trigger: "blur" }
        ],
        title: [
          { required: true, message: "标题不能为空", trigger: "blur" }
        ],
        subTitle: [
          { required: true, message: "副标题不能为空", trigger: "blur" }
        ],
        linkUrl: [
          { required: true, message: "网址不能为空", trigger: "blur" }
        ],
        target: [
          { required: true, message: "打开方式不能为空", trigger: "blur" }
        ],
        isEnable: [
          { required: true, message: "是否有效不能为空", trigger: "change" }
        ],
      }
    };
  },
  watch: {
    // 编辑轮播图图片变更监听
    "form.slideshowImageUrl"(){
      this.form.slideshow = "";
    },
    // 数据加载完毕初始化table最大高度
    slideshowList(){
      if(this.showSearch){
        this.$nextTick(() => {
          let appMainHeight = document.querySelector('.app-main').offsetHeight;
          let queryFormHeight = this.$refs.queryForm.$el.offsetHeight + 160;
          this.tableMaxHeight = appMainHeight - queryFormHeight;
        })
      }
    },
    // 显示隐藏搜索重置table最大高度
    showSearch(){
      if(this.showSearch){
        let appMainHeight = document.querySelector('.app-main').offsetHeight;
        this.$nextTick(() => {
          let queryFormHeight = this.$refs.queryForm.$el.offsetHeight + 160;
          this.tableMaxHeight = appMainHeight - queryFormHeight;
        })
      }else{
        let appMainHeight = document.querySelector('.app-main').offsetHeight;
        this.tableMaxHeight = appMainHeight - 130;
      } 
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询轮播图管理列表 */
    getList() {
      this.loading = true;
      listSlideshow(this.queryParams).then(response => {
        this.slideshowList = response.rows;
        this.total = response.total;
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
        slideshowId: null,
        slideshowImageUrl: null,
        title: null,
        subTitle: null,
        linkUrl: null,
        target: "0",
        isEnable: null,
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
      this.ids = selection.map(item => item.slideshowId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加轮播图";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const slideshowId = row.slideshowId || this.ids
      getSlideshow(slideshowId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改轮播图";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.slideshowId != null) {
            updateSlideshow(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSlideshow(this.form).then(response => {
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
      const slideshowIds = row.slideshowId || this.ids;
      this.$modal.confirm('是否确认删除轮播图编号为"' + slideshowIds + '"的数据项？').then(function() {
        return delSlideshow(slideshowIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('portal/slideshow/export', {
        ...this.queryParams
      }, `轮播图_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
