<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="170px">
      <el-form-item label="博物馆编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入博物馆编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入博物馆名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆的类型" prop="type">
        <el-input
          v-model="queryParams.type"
          placeholder="请输入博物馆的类型"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门票" prop="ticketprice">
        <el-input
          v-model="queryParams.ticketprice"
          placeholder="请输入门票"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开放时间" prop="openinghours">
        <el-input
          v-model="queryParams.openinghours"
          placeholder="请输入开放时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="建议游玩时间" prop="suggestedtraveltime">
        <el-input
          v-model="queryParams.suggestedtraveltime"
          placeholder="请输入建议游玩时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆等级" prop="museumlevel">
        <el-input
          v-model="queryParams.museumlevel"
          placeholder="请输入博物馆等级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文物保护单位" prop="units">
        <el-input
          v-model="queryParams.units"
          placeholder="请输入文物保护单位"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旅游景区级别" prop="attractionlevel">
        <el-input
          v-model="queryParams.attractionlevel"
          placeholder="请输入旅游景区级别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆对应页面的编号" prop="number">
        <el-input
          v-model="queryParams.number"
          placeholder="请输入博物馆对应页面的编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博物馆简介" prop="introduction">
        <el-input
          v-model="queryParams.introduction"
          placeholder="请输入博物馆简介"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="景点景观/藏品" prop="scenery">
        <el-input
          v-model="queryParams.scenery"
          placeholder="请输入景点景观/藏品"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--<el-form-item label="如何前往" prop="howtogo">
        <el-input
          v-model="queryParams.howtogo"
          placeholder="请输入如何前往"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>-->
      <!--<el-form-item label="周围的景点" prop="scenicspotsaround">
        <el-input
          v-model="queryParams.scenicspotsaround"
          placeholder="请输入周围的景点"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>-->
      <!--<el-form-item label="封面" prop="cover">
        <el-input
          v-model="queryParams.cover"
          placeholder="请输入封面"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>-->
      <el-form-item label="备注" prop="note">
        <el-input
          v-model="queryParams.note"
          placeholder="请输入备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经度" prop="longitude">
        <el-input
          v-model="queryParams.longitude"
          placeholder="请输入经度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纬度" prop="latitude">
        <el-input
          v-model="queryParams.latitude"
          placeholder="请输入纬度"
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
          v-hasPermi="['system:museum:add']"
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
          v-hasPermi="['system:museum:edit']"
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
          v-hasPermi="['system:museum:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:museum:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="museumList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="博物馆编号" align="center" prop="id" />
      <el-table-column width="100" label="博物馆名称" align="center" prop="name" />
      <el-table-column label="博物馆的类型" align="center" prop="type" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="门票" align="center" prop="ticketprice" />
      <el-table-column label="开放时间" align="center" prop="openinghours" />
      <el-table-column label="建议游玩时间" align="center" prop="suggestedtraveltime" />
      <el-table-column label="博物馆等级" align="center" prop="museumlevel" />
      <el-table-column label="文物保护单位" align="center" prop="units" />
      <el-table-column label="旅游景区级别" align="center" prop="attractionlevel" />
      <el-table-column label="博物馆对应页面的编号" align="center" prop="number" />
      <el-table-column width="400" label="博物馆简介" align="center" prop="introduction" />
      <el-table-column label="景点景观/藏品" align="center" prop="scenery" />
      <!--<el-table-column label="如何前往" align="center" prop="howtogo" />-->
      <!--<el-table-column label="周围的景点" align="center" prop="scenicspotsaround" />-->
      <el-table-column label="封面" align="center" prop="cover" >
      <template slot-scope="scope">
          <el-image
            style="width: 100px; height: 100px"
            :src="scope.row.cover"
            :fit="fit"></el-image>
      </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column width="100" label="经度" align="center" prop="longitude" />
      <el-table-column width="100" label="纬度" align="center" prop="latitude" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:museum:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:museum:remove']"
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

    <!-- 添加或修改博物馆信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="博物馆名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入博物馆名称" />
        </el-form-item>
        <el-form-item label="博物馆的类型" prop="type">
          <el-input v-model="form.type" placeholder="请输入博物馆的类型" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="门票" prop="ticketprice">
          <el-input v-model="form.ticketprice" placeholder="请输入门票" />
        </el-form-item>
        <el-form-item label="开放时间" prop="openinghours">
          <el-input v-model="form.openinghours" placeholder="请输入开放时间" />
        </el-form-item>
        <el-form-item label="建议游玩时间" prop="suggestedtraveltime">
          <el-input v-model="form.suggestedtraveltime" placeholder="请输入建议游玩时间" />
        </el-form-item>
        <el-form-item label="博物馆等级" prop="museumlevel">
          <el-input v-model="form.museumlevel" placeholder="请输入博物馆等级" />
        </el-form-item>
        <el-form-item label="文物保护单位" prop="units">
          <el-input v-model="form.units" placeholder="请输入文物保护单位" />
        </el-form-item>
        <el-form-item label="旅游景区级别" prop="attractionlevel">
          <el-input v-model="form.attractionlevel" placeholder="请输入旅游景区级别" />
        </el-form-item>
        <el-form-item label="博物馆对应页面的编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入博物馆对应页面的编号" />
        </el-form-item>
        <el-form-item label="博物馆简介" prop="introduction">
          <el-input v-model="form.introduction" placeholder="请输入博物馆简介" />
        </el-form-item>
        <el-form-item label="景点景观/藏品" prop="scenery">
          <el-input v-model="form.scenery" placeholder="请输入景点景观/藏品" />
        </el-form-item>
        <el-form-item label="如何前往" prop="howtogo">
          <el-input v-model="form.howtogo" placeholder="请输入如何前往" />
        </el-form-item>
        <el-form-item label="周围的景点" prop="scenicspotsaround">
          <el-input v-model="form.scenicspotsaround" placeholder="请输入周围的景点" />
        </el-form-item>
        <el-form-item label="封面" prop="cover">
          <el-input v-model="form.cover" placeholder="请输入封面" />
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
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
import { listMuseum, getMuseum, delMuseum, addMuseum, updateMuseum, exportMuseum } from "@/api/system/museum";

export default {
  name: "Museum",
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
      // 博物馆信息表格数据
      museumList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        name: null,
        type: null,
        address: null,
        ticketprice: null,
        openinghours: null,
        suggestedtraveltime: null,
        museumlevel: null,
        units: null,
        attractionlevel: null,
        number: null,
        introduction: null,
        scenery: null,
        howtogo: null,
        scenicspotsaround: null,
        cover: null,
        note: null,
        longitude: null,
        latitude: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询博物馆信息列表 */
    getList() {
      this.loading = true;
      listMuseum(this.queryParams).then(response => {
        for (let i = 0; i < response.rows.length; i ++) {
            if (!response.rows[i].cover) continue;
            response.rows[i].cover = response.rows[i].cover.replace(i+1, response.rows[i].name);
            response.rows[i].cover = response.rows[i].cover.replace("/RuoYi-Vue", "http://8.140.136.108");
            console.log(response.rows[i].cover);
        }
        this.museumList = response.rows;
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
        name: null,
        type: null,
        address: null,
        ticketprice: null,
        openinghours: null,
        suggestedtraveltime: null,
        museumlevel: null,
        units: null,
        attractionlevel: null,
        number: null,
        introduction: null,
        scenery: null,
        howtogo: null,
        scenicspotsaround: null,
        cover: null,
        note: null,
        longitude: null,
        latitude: null
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
      this.title = "添加博物馆信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMuseum(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改博物馆信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMuseum(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMuseum(this.form).then(response => {
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
      this.$confirm('是否确认删除博物馆信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMuseum(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有博物馆信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportMuseum(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
