<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px; margin-top: 30px">
      课程分类
    </h1>
    <div class="block">
      <el-tree
        :data="courseList"
        :props="courseList"
        highlight-current
        @node-click="handleNodeClick"
        node-key="label"
        ref="menuTree"
        :default-expanded-keys="defaultExpandedNodes"
      >
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ node.label }}</span>
          <span>
            <el-button
              v-if="node.level == 1"
              type="primary"
              circle
              size="mini"
              class="add"
              @click="handleAddCourse(data)"
            >
              新增
            </el-button>
            <el-button
              type="primary"
              icon="el-icon-edit"
              v-if="node.level == 2"
              size="mini"
              class="edit"
              circle
              @click="handleEditCourse(data)"
            ></el-button>

            <el-button
              icon="el-icon-check"
              circle
              type="success"
              v-if="node.level == 2"
              size="mini"
              class="add"
              @click="handleCourseDetail(data)"
            >
            </el-button>

            <el-button
              type="warning"
              icon="el-icon-delete"
              circle
              v-if="node.level == 2"
              size="mini"
              @click="handleDeleteCourse(data)"
            >
            </el-button>
          </span>
        </span>
      </el-tree>
    </div>

    <!-- 新增课程的弹框 -->
    <el-dialog
      title="新增课程"
      :visible.sync="AddCoursedialogVisible"
      width="30%"
      @open="openFun"
      :closeOnClickModal="false"
    >
      <div class="add-course-form">
        <el-form
          :model="addCourseFormData"
          :rules="addCourseFormDataRules"
          ref="AddCourseFormRef"
        >
          <el-form-item label="课程名" label-width="75px" prop="cs_name">
            <!-- #{cs_name},#{cs_price},#{cs_desc},#{cs_time},#{cat_id},#{te_id},#{limit_buy},#{sold} -->
            <el-input v-model="addCourseFormData.cs_name"></el-input>
          </el-form-item>
          <el-form-item label="教师姓名" label-width="80px" prop="te_id">
            <el-select
              style="width: 100%"
              v-model="addCourseFormData.te_id"
              clearable
            >
              <el-option
                v-for="(item, index) in teacherOption"
                :key="index"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="课程价格" label-width="80px" prop="cs_price">
            <el-input v-model="addCourseFormData.cs_price"></el-input>
          </el-form-item>
          <el-form-item label="课时" label-width="75px" prop="cs_time">
            <el-input v-model="addCourseFormData.cs_time"></el-input>
          </el-form-item>
          <el-form-item label="限售" label-width="75px" prop="limit_buy">
            <el-input v-model.number="addCourseFormData.limit_buy"></el-input>
          </el-form-item>
          <el-form-item label="已售" label-width="75px" prop="sold">
            <el-input v-model.number="addCourseFormData.sold"></el-input>
          </el-form-item>
          <el-form-item label="课程描述" prop="cs_desc">
            <el-input
              type="textarea"
              :rows="4"
              v-model="addCourseFormData.cs_desc"
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="AddCoursedialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleConfirmAddCourse"
          >确 定</el-button
        >
      </span>
    </el-dialog>
    <!-- 课程描述 -->
    <el-dialog
      title="课程详情"
      :visible.sync="detailDialogVisible"
      width="30%"
      :closeOnClickModal="false"
    >
      <div>
        <img :src="courseDetailData.cs_img" style="width: 100%" />
        <div class="course-name">
          <h3>课程名称：{{ courseDetailData.cs_name }}</h3>
        </div>
        <div class="course-price">
          <h3>课程价格：{{ courseDetailData.cs_price }}</h3>
        </div>
        <div class="course-time">
          <h3>课程时长：{{ courseDetailData.cs_time }}</h3>
        </div>
        <div class="course-limit_buy">
          <h3>限售：{{ courseDetailData.limit_buy }}</h3>
          <span></span>
        </div>
        <div class="course-sold">
          <h3>已售：{{ courseDetailData.sold }}</h3>
        </div>
        <div class="course-t-name">
          <h3>授课老师：{{ courseDetailData.t_name }}</h3>
        </div>
        <div class="course-t-desc">
          <span>教师描述：</span>
          <span>{{ courseDetailData.t_desc }}</span>
        </div>
        <div class="course-cs-desc">
          <span>课程描述：</span>
          <span>{{ courseDetailData.cs_desc }}</span>
        </div>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="detailDialogVisible = false"
          >关 闭</el-button
        >
      </span>
    </el-dialog>
    <!-- 修改课程 -->
    <el-dialog
      title="修改课程"
      :visible.sync="updateDialogVisible"
      width="30%"
      :closeOnClickModal="false"
    >
      <el-form
        :model="updateCourseFormData"
        :rules="updateCourseFormDataRules"
        ref="updateCourseRef"
      >
        <div>
          <img :src="updateCourseFormData.cs_img" style="width: 100%" />
          <div class="course-name">
            <h3>课程名称：{{ updateCourseFormData.cs_name }}</h3>
          </div>

          <el-form-item label="教师姓名" label-width="75px" prop="te_id">
            <el-select
              style="width: 100%"
              v-model.number="updateCourseFormData.te_id"
              clearable
            >
              <el-option
                v-for="(item, index) in teacherOption"
                :key="index"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="课程价格" label-width="75px" prop="cs_price">
            <el-input v-model="updateCourseFormData.cs_price"></el-input>
          </el-form-item>
          <el-form-item label="课时" label-width="75px" prop="cs_time">
            <el-input v-model="updateCourseFormData.cs_time"></el-input>
          </el-form-item>
          <div class="course-limit_buy">
            <span>限售：</span>
            <span>{{ updateCourseFormData.limit_buy }}</span>
          </div>
          <div class="course-sold">
            <span>已售：</span>
            <span>{{ updateCourseFormData.sold }}</span>
          </div>
          <el-form-item label="课程描述" prop="cs_desc">
            <el-input
              type="textarea"
              :rows="4"
              v-model="updateCourseFormData.cs_desc"
            ></el-input>
          </el-form-item>
        </div>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <span slot="footer" class="dialog-footer">
          <el-button @click="updateDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="handleConfirmUpdateCourse"
            >确 定</el-button
          >
        </span>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  getAllCourseList,
  addCourse,
  getCourseDetail,
  updateCourse,
  deleteCourse,
} from "@/api/course";
import { teacherOption } from "@/api/teacher";
export default {
  data() {
    return {
      updateCourseFormDataRules: {
        te_id: [{ required: true, message: "请输入课程名称", trigger: "blur" }],
        //cs_price cs_time cs_desc
        cs_price: [
          { required: true, message: "请输入课程价格", trigger: "blur" },
        ],
        cs_time: [{ required: true, message: "请输入课时", trigger: "blur" }],
        cs_desc: [
          { required: true, message: "请输入课程描述", trigger: "blur" },
        ],
      },
      defaultExpandedNodes: [],
      addCourseFormDataRules: {
        cs_name: [
          { required: true, message: "请输入课程名称", trigger: "blur" },
        ],
        te_id: [{ required: true, message: "请选择教师", trigger: "change" }],
        cs_price: [
          { required: true, message: "请输入课程价格", trigger: "blur" },
        ],
        cs_time: [{ required: true, message: "请输入课时", trigger: "blur" }],
        limit_buy: [
          { required: true, message: "请输入限售数量", trigger: "blur" },
          { type: "number", message: "限售数量必须为数字值" },
        ],
        sold: [
          { required: true, message: "请输入已售数量", trigger: "blur" },
          { type: "number", message: "已售数量必须为数字值" },
        ],
        cs_desc: [
          { required: true, message: "请输入课程描述", trigger: "blur" },
        ],
      },
      AddCoursedialogVisible: false,
      courseList: [],
      addCourseFormData: {
        cs_name: "",
        cs_price: "",
        cs_desc: "",
        cs_time: "",
        limit_buy: "",
        sold: 0,
        cat_id: "",
        te_id: "",
      },
      cat_id: "",
      teacherOption: [],
      deleteParam: {
        cs_id: "",
      },
      courseDetail: {
        cs_id: "",
      },
      courseDetailData: {
        cs_name: "",
        cs_price: "",
        cs_img: "",
        cs_desc: "",
        cs_time: "",
        limit_buy: "",
        sold: "",
        cat_id: "",
        t_name: "",
        t_desc: "",
      },
      detailDialogVisible: false,
      updateDialogVisible: false,
      // 价格 课程描述  课时 授课老师
      updateCourseFormData: {
        cs_price: "",
        cs_desc: "",
        cs_time: "",
        te_id: "",
        cs_id: "",
      },
    };
  },
  mounted() {
    this.setDefaultExpandedKeys();
  },
  methods: {
    //查看课程详情页
    handleCourseDetail(data) {
      this.detailDialogVisible = true;
      this.courseDetail.cs_id = data.id;
      getCourseDetail(this.courseDetail).then((res) => {
        this.courseDetailData = res;
      });
      console.log(this.courseDetailData);
    },

    openFun() {
      this.$nextTick(() => {
        if (this.$refs["AddCourseFormRef"]) {
          this.$refs["AddCourseFormRef"].resetFields();
        }
      });
    },
    // 获取到教师的下拉菜单
    getTeacherOPtion() {
      teacherOption().then((res) => {
        console.log(res);
        this.teacherOption = res.map((item) => {
          return {
            label: item.t_name,
            value: item.t_id,
          };
        });
        console.log(this.teacherOption);
      });
    },
    //页面首次加载显示所有课程
    getAllCourse() {
      const recurrence = (item) => {
        let children = [];
        if (item.courses && item.courses.length) {
          children = item.courses.map((children) => {
            return recurrence(children);
          });
        }
        return {
          id: item.id || item.cs_id,
          label: item.category || item.cs_name,
          children,
        };
      };
      getAllCourseList().then((res) => {
        console.log(res);
        this.courseList = res.courseList.map((item) => {
          return recurrence(item);
        });
        console.log(this.courseList);
      });
    },
    handleNodeClick(data) {
      this.setDefaultExpandedKeys();
    },

    //点击添加课程按钮，弹框，并将课程分类的id获取到
    handleAddCourse(data) {
      console.log(data);
      const { id } = data;
      this.cat_id = id;
      this.AddCoursedialogVisible = true;
    },
    setDefaultExpandedKeys() {
      // 获取树形组件实例
      let treeCompInstance = this.$refs["menuTree"];
      let allNodes = treeCompInstance.store._getAllNodes();
      let defaultExpandedNodes = [];
      allNodes.forEach((node) => {
        node.expanded && defaultExpandedNodes.push(node.data.label);
      });
      this.defaultExpandedKeys = defaultExpandedNodes;
    },
    //点击确认，新增课程
    handleConfirmAddCourse() {
      this.AddCoursedialogVisible = false;
      this.addCourseFormData.cat_id = this.cat_id;
      const AddCourseFormRef = this.$refs["AddCourseFormRef"];
      AddCourseFormRef.validate((validate) => {
        if (validate) {
          addCourse(this.addCourseFormData).then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.msg,
                type: "success",
              });
            }
            this.getAllCourse();
          });
        } else {
          this.$message.error("请将新增的教师信息填写完整！");
          this.AddCoursedialogVisible = true;
        }
      });
      this.AddCourseFormRef.resetFields();
    },
    //删除课程
    handleDeleteCourse(data) {
      //获取到当前点击课程的id
      this.deleteParam.cs_id = data.id;
      //发送请求
      deleteCourse(this.deleteParam).then((res) => {
        console.log(res);
        if (res.code == 200) {
          this.$message({
            message: res.msg,
            type: "success",
          });
        }
        //刷新页面
        this.getAllCourse();
      });

      //刷新页面
    },

    // 修改课程信息回显数据
    handleEditCourse(data) {
      this.updateDialogVisible = true;
      this.courseDetail.cs_id = data.id;
      getCourseDetail(this.courseDetail).then((res) => {
        this.updateCourseFormData = res;
        console.log(this.defaultKeys);
      });
    },
    handleConfirmUpdateCourse() {
      this.updateCourseFormData.cs_id = this.courseDetail.cs_id;
      let obj = {};
      obj.cs_id = this.courseDetail.cs_id;
      obj.cs_price = this.updateCourseFormData.cs_price;
      obj.cs_desc = this.updateCourseFormData.cs_desc;
      obj.cs_time = this.updateCourseFormData.cs_time;
      obj.te_id = this.updateCourseFormData.te_id;
      //进行参数校验不能为空  updateCourseRef
      const updateCourseRef = this.$refs["updateCourseRef"];
      updateCourseRef.validate((validate) => {
        if (validate) {
          updateCourse(obj).then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.msg,
                type: "success",
              });
            }
            this.updateDialogVisible = false;
            this.getAllCourse();
          });
        }
      });
    },
  },
  created() {
    this.getAllCourse();
    this.getTeacherOPtion();
  },
};
</script>

<style lang="less" scoped>
::v-deep .el-tree-node__content {
  margin: 15px;
}
.add {
  display: inline-block;
  margin: 10px 10px;
}
.edit {
  display: inline-block;
  margin: 10px 10px;
}
::v-deep .el-form-item__label {
  text-align: right;
  vertical-align: middle;
  float: left;
  font-size: 14px;
  color: #606266;
  line-height: 40px;
  padding: 0 7px 0 0;
  box-sizing: border-box;
}
.course-name {
  // display: flex;
  // justify-content: space-between;
}
.course-t-desc{
  line-height: 27px;
  font-size: 15px;
}
.course-cs-desc{
  line-height: 27px;
  font-size: 15px;
}
.course-sold{
  margin-bottom: 10px;
}
.course-limit_buy{
  margin-bottom: 10px;
}
</style>