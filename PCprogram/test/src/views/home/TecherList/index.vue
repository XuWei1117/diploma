<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px; margin-top: 30px">
      教师列表
    </h1>
    <div class="">
      <el-form class="search-form" :model="SearchFormData">
        <el-row class="search-form-items">
          <el-form-item label="教师" label-width="75px">
            <el-input
              style="width: 200px"
              v-model="SearchFormData.t_name"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              class="search-btn"
              type="primary"
              icon="el-icon-search"
              @click="handleSearchClick"
              >搜索</el-button
            >
          </el-form-item>
          <el-form-item>
            <el-button
              class="search-btn"
              type="primary"
              @click="handleAddTeacherClick"
              >新增</el-button
            >
          </el-form-item>
        </el-row>
      </el-form>
    </div>
    <div class="teacher_list" style="width: 1200px; margin: auto">
      <el-table
        :data="teacherList"
        border
        style="width: 100%; text-align: center"
        :header-cell-style="{ background: '#9999FF ', color: 'white' }"
        :row-class-name="tableRowClassName"
      >
        <el-table-column
          align="center"
          type="index"
          label="序号"
          width="100"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          prop="t_name"
          label="姓名"
          width="100"
          align="center"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="t_gender"
          label="性别"
          width="100"
          header-align="center"
        >
          <template slot-scope="scope">
            <span v-if="scope.row.t_gender === 0">男</span>
            <span v-if="scope.row.t_gender === 1">女</span>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="t_age"
          label="年龄"
          width="100"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="t_desc"
          label="资历"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          align="center"
          label="操作"
          header-align="center"
          width="100"
        >
          <template slot-scope="scope">
            <el-button
              type="primary"
              @click="handleUpdateTeacherClick(scope.row)"
              icon="el-icon-edit"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-pagination
      class="pagination"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage"
      :page-sizes="[10, 30, 50]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
    <!-- 新增教师弹框组件 -->
    <el-dialog
      title="新增教师"
      :visible.sync="dialogVisible"
      width="30%"
      :closeOnClickModal="false"
      @open="openFun"
    >
      <div>
        <el-form
          :model="addTeacherInfo"
          :rules="addTeacherFormDataRules"
          ref="AddTeacherRef"
        >
          <el-form-item label="姓名" label-width="75px" prop="t_name">
            <el-input v-model="addTeacherInfo.t_name"></el-input>
          </el-form-item>
          <el-form-item label="年龄" label-width="75px" prop="t_age">
            <el-input v-model.number="addTeacherInfo.t_age"></el-input>
          </el-form-item>
          <el-form-item label="性别" label-width="75px" prop="t_gender">
            <el-select
              style="width: 100%"
              v-model="addTeacherInfo.t_gender"
              clearable
            >
              <el-option
                v-for="(item, index) in gender"
                :key="index"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="描述" label-width="75px" prop="t_desc">
            <el-input
              v-model="addTeacherInfo.t_desc"
              type="textarea"
              :rows="5"
            ></el-input>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="handleAddTeacherDialogCancel">取 消</el-button>
        <el-button type="primary" @click="handleAddTeacherDialog"
          >确 定</el-button
        >
      </span>
    </el-dialog>
    <!-- 编辑教师弹框组件 -->
    <el-dialog
      title="编辑教师"
      :visible.sync="dialogUpdateTeacher"
      width="30%"
      :closeOnClickModal="false"
    >
      <div>
        <el-form
          :model="updateTeacherInfo"
          :rules="updateTeacherFormDataRules"
          ref="updateTeacherRef"
        >
          <el-form-item label="姓名" label-width="75px">
            <el-input
              v-model="updateTeacherInfo.t_name"
              :disabled="true"
            ></el-input>
          </el-form-item>
          <el-form-item label="年龄" label-width="75px" prop="t_age">
            <el-input v-model.number="updateTeacherInfo.t_age"></el-input>
          </el-form-item>
          <el-form-item label="性别" label-width="75px" prop="t_gender">
            <el-select
              style="width: 100%"
              v-model.number="updateTeacherInfo.t_gender"
              clearable
            >
              <el-option
                v-for="(item, index) in gender"
                :key="index"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="描述" label-width="75px" prop="t_desc">
            <el-input
              v-model="updateTeacherInfo.t_desc"
              type="textarea"
              :rows="5"
            ></el-input>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button @click="handleUpdateTeacherDialogCancel">取 消</el-button>
        <el-button type="primary" @click="handleUpdateTeacherDialog"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  getAllTeacher,
  addTeacher,
  selectTeacherById,
  updateTeacher,
} from "@/api/teacher";
export default {
  data() {
    return {
      updateTeacherFormDataRules: {
        t_age: [
          { required: true, message: "请输入年龄", trigger: "blur" },
          { type: "number", message: "年龄必须为数字值" },
        ],
        t_gender: [{ required: true, message: "选择性别", trigger: "change" }],
        t_desc: [
          { required: true, message: "请输入课程描述", trigger: "blur" },
        ],
      },
      addTeacherFormDataRules: {
        t_name: [
          { required: true, message: "请输入新增的教师名称", trigger: "blur" },
        ],

        t_age: [
          { required: true, message: "请输入年龄", trigger: "blur" },
          { type: "number", message: "年龄必须为数字值" },
        ],
        t_gender: [{ required: true, message: "选择性别", trigger: "change" }],
        t_desc: [
          { required: true, message: "请输入课程描述", trigger: "blur" },
        ],
      },
      teacherList: [],
      SearchFormData: {
        t_name: "",
        pageNum: 1,
        pageSize: 10,
      },
      gender: [
        {
          value: 0,
          label: "男",
        },
        {
          value: 1,
          label: "女",
        },
      ],
      addTeacherInfo: {
        t_name: "",
        t_age: "",
        t_gender: "",
        t_desc: "",
      },
      updateTeacherInfo: {
        t_id: 0,
        t_age: "",
        t_gender: "",
        t_desc: "",
      },
      selectTeacherById: {
        t_id: 0,
      },

      currentPage: 1,
      total: 0,
      dialogVisible: false,
      dialogUpdateTeacher: false,
    };
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      return "success-row";
    },
    getAllTeacherData() {
      getAllTeacher(this.SearchFormData).then((res) => {
        console.log(res);
        this.teacherList = res.list;
        this.total = res.total;
      });
    },
    handleSearchClick() {
      this.getAllTeacherData();
    },
    handleSizeChange(value) {
      this.SearchFormData.pageSize = value;
      this.getAllTeacherData();
    },
    handleCurrentChange(value) {
      this.currentPage = value;
      this.SearchFormData.pageNum = value;
      this.getAllTeacherData();
    },
    //点击新增按钮弹框
    handleAddTeacherClick() {
      this.dialogVisible = true;
    },
    openFun() {
      this.$nextTick(() => {
        if (this.$refs["AddTeacherRef"]) {
          this.$refs["AddTeacherRef"].resetFields();
        }
      });
    },
    //点击确定新增教师
    handleAddTeacherDialog() {
      //首先进行参数校验
      const AddTeacherRef = this.$refs["AddTeacherRef"];
      AddTeacherRef.validate((validate) => {
        if (validate) {
          addTeacher(this.addTeacherInfo)
            .then((res) => {
              Object.keys(this.addTeacherInfo).forEach((key) => {
                this.addTeacherInfo[key] = "";
              });

              if (res.code == 200) {
                this.$message({
                  message: res.msg,
                  type: "success",
                });
              }
              this.getAllTeacherData();
            })
            .catch((err) => {
              console.log(err);
            });
          this.dialogVisible = false;
        } else {
          this.$message.error("请将新增的教师信息填写完整！");
          this.dialogVisible = true;
        }
      });
    },
    handleAddTeacherDialogCancel() {
      this.dialogVisible = false;
      //      Object.keys(this.addTeacherInfo).forEach((key)=>{
      //   this.addTeacherInfo[key] = ''
      // })
      Object.assign(
        this.$data.addTeacherInfo,
        this.$options.data().addTeacherInfo
      );
    },
    handleUpdateTeacherClick(row) {
      this.selectTeacherById.t_id = row.t_id;
      // 显示弹框组件
      this.dialogUpdateTeacher = true;
      //发送请求进行回显数据
      selectTeacherById(this.selectTeacherById).then((res) => {
        this.updateTeacherInfo.t_id = res.t_id;
        this.updateTeacherInfo.t_name = res.t_name;
        this.updateTeacherInfo.t_age = Number(res.t_age);
        console.log(typeof this.updateTeacherInfo.t_age)
        this.updateTeacherInfo.t_gender = res.t_gender;
        this.updateTeacherInfo.t_desc = res.t_desc;
      });
    },
    handleUpdateTeacherDialog() {
      //updateTeacherFormDataRules  updateTeacherRef
      const updateTeacherRef = this.$refs["updateTeacherRef"];
      updateTeacherRef.validate((validate) => {
        if (validate) {
          updateTeacher(this.updateTeacherInfo).then((res) => {
            if (res.code == 200) {
              //修改信息成功，将弹出框关闭
              this.dialogUpdateTeacher = false;
              //刷新页面
              this.getAllTeacherData();
              //弹出提示框
              this.$message({
                message: res.msg,
                type: "success",
              });
            }
          });
        }
      });
    },
    handleUpdateTeacherDialogCancel() {
      this.dialogUpdateTeacher = false;
    },
  },

  created() {
    this.getAllTeacherData();
  },
};
</script>

<style lang="less" scoped>
.search-form {
  display: flex;
  justify-content: center;
  .search-form-items {
    display: flex;
  }
  // justify-content: space-evenly;
  // align-items: center;
  .search-btn {
    margin-left: 20px;
  }
}

.pagination {
  text-align: center;
  margin-top: 30px;
}
::v-deep .el-table .success-row {
  // background: 	#99BBFF;
  background: #ccccff;
}
</style>