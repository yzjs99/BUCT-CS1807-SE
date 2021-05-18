<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="讲解编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入讲解编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="讲解创建者编号" prop="createid">
        <el-input
          v-model="queryParams.createid"
          placeholder="请输入讲解创建者编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="讲解类型" prop="type">
        <el-input
          v-model="queryParams.type"
          placeholder="请输入讲解类型"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收藏品编号" prop="collectionid">
        <el-input
          v-model="queryParams.collectionid"
          placeholder="请输入收藏品编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="讲解图片" prop="image">
        <el-input
          v-model="queryParams.image"
          placeholder="请输入讲解图片"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="讲解音频" prop="voice">
        <el-input
          v-model="queryParams.voice"
          placeholder="请输入讲解音频"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞数" prop="sponsor">
        <el-input
          v-model="queryParams.sponsor"
          placeholder="请输入点赞数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入审核状态"
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
          v-hasPermi="['system:collectionexplain:add']"
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
          v-hasPermi="['system:collectionexplain:edit']"
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
          v-hasPermi="['system:collectionexplain:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:collectionexplain:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="collectionexplainList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="讲解编号" align="center" prop="id" />
      <el-table-column label="讲解创建者编号" align="center" prop="createid" />
      <el-table-column label="讲解类型" align="center" prop="type" />
      <el-table-column label="收藏品编号" align="center" prop="collectionid" />
      <el-table-column width="200" label="讲解图片" align="center" prop="image" >
      <template slot-scope="scope">
        <img :src="scope.row.image" width="200" height="200"/>
      </template>
      </el-table-column>
      <el-table-column width="300" label="讲解音频" align="center" prop="voice" >
      <template slot-scope="scope">
        <audio :src="scope.row.voice" controls="controls"/>
      </template>
      </el-table-column>
      <el-table-column  width="500" label="讲解文字" align="center" prop="text" />
      <el-table-column label="点赞数" align="center" prop="sponsor" />
      <el-table-column label="审核状态" align="center" prop="state" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:collectionexplain:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:collectionexplain:remove']"
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

    <!-- 添加或修改收藏品讲解对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="讲解创建者编号" prop="createid">
          <el-input v-model="form.createid" placeholder="请输入讲解创建者编号" />
        </el-form-item>
        <el-form-item label="讲解类型" prop="type">
          <el-input v-model="form.type" placeholder="请输入讲解类型" />
        </el-form-item>
        <el-form-item label="收藏品编号" prop="collectionid">
          <el-input v-model="form.collectionid" placeholder="请输入收藏品编号" />
        </el-form-item>
        <el-form-item label="讲解图片" prop="image">
          <el-input v-model="form.image" placeholder="请输入讲解图片" />
        </el-form-item>
        <el-form-item label="讲解音频" prop="voice">
          <el-input v-model="form.voice" placeholder="请输入讲解音频" />
        </el-form-item>
        <el-form-item label="讲解文字" prop="text">
          <el-input v-model="form.text" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="点赞数" prop="sponsor">
          <el-input v-model="form.sponsor" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="审核状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入审核状态" />
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
import { listCollectionexplain, getCollectionexplain, delCollectionexplain, addCollectionexplain, updateCollectionexplain, exportCollectionexplain,getCollectionImage,getCollectionVoice} from "@/api/system/collectionexplain";

export default {
  name: "Collectionexplain",
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
      // 收藏品讲解表格数据
      collectionexplainList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        createid: null,
        type: null,
        collectionid: null,
        image: null,
        voice: null,
        text: null,
        sponsor: null,
        state: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        createid: [
          { required: true, message: "讲解创建者编号不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "讲解类型不能为空", trigger: "blur" }
        ],
        collectionid: [
          { required: true, message: "收藏品编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询收藏品讲解列表 */
    getList() {
      this.loading = true;
      listCollectionexplain(this.queryParams).then(response => {
        for (let i = 0; i < response.rows.length; i ++) {
          response.rows[i].image = getCollectionImage(response.rows[i].id);
          response.rows[i].voice = getCollectionVoice(response.rows[i].id);
        }
        this.collectionexplainList = response.rows;
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
        createid: null,
        type: null,
        collectionid: null,
        image: null,
        voice: null,
        text: null,
        sponsor: null,
        state: null
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
      this.title = "添加收藏品讲解";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCollectionexplain(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改收藏品讲解";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCollectionexplain(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCollectionexplain(this.form).then(response => {
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
      this.$confirm('是否确认删除收藏品讲解编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCollectionexplain(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有收藏品讲解数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCollectionexplain(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
