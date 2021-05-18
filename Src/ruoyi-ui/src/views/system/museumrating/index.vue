<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号 " prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入编号 "
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户编号" prop="usersid">
        <el-input
          v-model="queryParams.usersid"
          placeholder="请输入用户编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆编号 " prop="museumid">
        <el-input
          v-model="queryParams.museumid"
          placeholder="请输入博物馆编号 "
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评分一" prop="scoreone">
        <el-input
          v-model="queryParams.scoreone"
          placeholder="请输入评分一"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评分二" prop="scoretwo">
        <el-input
          v-model="queryParams.scoretwo"
          placeholder="请输入评分二"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评分三 " prop="scorethree">
        <el-input
          v-model="queryParams.scorethree"
          placeholder="请输入评分三 "
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:museumrating:add']"
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
          v-hasPermi="['system:museumrating:edit']"
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
          v-hasPermi="['system:museumrating:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:museumrating:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="museumratingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号 " align="center" prop="id" />
      <el-table-column label="用户编号" align="center" prop="usersid" />
      <el-table-column label="博物馆编号 " align="center" prop="museumid" />
      <el-table-column label="评分一" align="center" prop="scoreone" />
      <el-table-column label="评分二" align="center" prop="scoretwo" />
      <el-table-column label="评分三 " align="center" prop="scorethree" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:museumrating:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:museumrating:remove']"
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

    <!-- 添加或修改博物馆评分对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户编号" prop="usersid">
          <el-input v-model="form.usersid" placeholder="请输入用户编号" />
        </el-form-item>
        <el-form-item label="博物馆编号 " prop="museumid">
          <el-input v-model="form.museumid" placeholder="请输入博物馆编号 " />
        </el-form-item>
        <el-form-item label="评分一" prop="scoreone">
          <el-input v-model="form.scoreone" placeholder="请输入评分一" />
        </el-form-item>
        <el-form-item label="评分二" prop="scoretwo">
          <el-input v-model="form.scoretwo" placeholder="请输入评分二" />
        </el-form-item>
        <el-form-item label="评分三 " prop="scorethree">
          <el-input v-model="form.scorethree" placeholder="请输入评分三 " />
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
import { listMuseumrating, getMuseumrating, delMuseumrating, addMuseumrating, updateMuseumrating, exportMuseumrating } from "@/api/system/museumrating";

export default {
  name: "Museumrating",
  components: {
  },
  data() {
    return {
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
      // 博物馆评分表格数据
      museumratingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        usersid: null,
        museumid: null,
        scoreone: null,
        scoretwo: null,
        scorethree: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        usersid: [
          { required: true, message: "用户编号不能为空", trigger: "blur" }
        ],
        museumid: [
          { required: true, message: "博物馆编号 不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询博物馆评分列表 */
    getList() {
      this.loading = true;
      listMuseumrating(this.queryParams).then(response => {
        this.museumratingList = response.rows;
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
        id: null,
        usersid: null,
        museumid: null,
        scoreone: null,
        scoretwo: null,
        scorethree: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加博物馆评分";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMuseumrating(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改博物馆评分";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMuseumrating(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMuseumrating(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除博物馆评分编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMuseumrating(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有博物馆评分数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportMuseumrating(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
