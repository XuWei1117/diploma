<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px; margin-top: 30px">
      新闻列表
    </h1>
    <div>
      <el-form class="search-form" :model="SearchFormData">
        <el-row class="search-form-items">
          <el-form-item label="条件" label-width="75px">
            <el-input
              style="width: 300px"
              v-model="SearchFormData.condition"
              placeholder="可根据新闻题目进行搜索"
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
              @click="handleAddNewsClick"
              >新增</el-button
            >
          </el-form-item>
        </el-row>
      </el-form>
    </div>
    <div style="width: 1251px; margin: auto">
      <el-table
        :data="newsList"
        border
        style="width: 100%"
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
        <el-table-column prop="n_title" label="题目" width="500" align="center">
        </el-table-column>
        <el-table-column
          prop="n_date"
          label="发布时间"
          width="200"
          align="center"
          :formatter="formatTime"
        >
        </el-table-column>

        <el-table-column label="查看" width="150" align="center">
          <template slot-scope="scope">
            <el-button type="warning" @click="handleNewsDetailClick(scope.row)"
              >查看详情</el-button
            >
          </template>
        </el-table-column>

        <el-table-column label="修改" width="150" align="center">
          <template slot-scope="scope">
            <el-button
              type="warning"
              @click="handleNewsEditClick(scope.row)"
              icon="el-icon-edit"
              circle
            ></el-button>
          </template>
        </el-table-column>

        <el-table-column label="删除" width="150" align="center">
          <template slot-scope="scope">
            <el-button
              type="danger"
              @click="handleDeleteNewsClick(scope.row)"
              icon="el-icon-delete"
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
    ></el-pagination>
    <!-- 查看新闻详情 -->
    <el-dialog
      title="查看新闻详情"
      :visible.sync="detailDialogVisible"
      width="30%"
      :closeOnClickModal="false"
    >
      <div>
        <div class="course-name">
          <h3>{{ newsDetailData.n_title }}</h3>
        </div>
        <div>
          {{ newsDetailData.n_detail1 }}
        </div>
        <div>{{ dateFormat(newsDetailData.n_date) }}</div>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="detailDialogVisible = false"
          >关 闭</el-button
        >
      </span>
    </el-dialog>

    <el-dialog
      title="新增新闻"
      :visible.sync="AddNewslDialogVisible"
      width="30%"
      :closeOnClickModal="false"
      @open="openFun"
    >
      <div>
        <el-form
          :model="addNewsList"
          :rules="addNewsFormDataRules"
          ref="AddNewsRef"
        >
          <el-form-item
            label="新闻标题"
            prop="n_title"
            type="textarea"
            autosize
          >
            <el-input v-model="addNewsList.n_title"> </el-input>
          </el-form-item>
          <el-form-item label="新闻内容" prop="n_detail1">
            <el-input
              type="textarea"
              :row="8"
              v-model="addNewsList.n_detail1"
              autosize
            >
            </el-input>
          </el-form-item>

          <el-form-item label="新闻日期" prop="n_date_str">
            <el-date-picker
              v-model="addNewsList.n_date_str"
              type="date"
              placeholder="选择日期"
            >
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handAddNewsCancle">关 闭</el-button>
        <el-button type="primary" @click="handAddNews">确定</el-button>
      </span>
    </el-dialog>

    <!--  -->

    <el-dialog
      title="编辑新闻"
      :visible.sync="updateNewsDialogVisible"
      width="30%"
      :closeOnClickModal="false"
    >
      <div>
        <el-form
          :model="updateNewsList"
          :rules="updateNewsFormDataRules"
          ref="UpdateNewsRef"
        >
          <el-form-item label="新闻标题" prop="n_title">
            <el-input v-model="updateNewsList.n_title" type="textarea" autosize>
            </el-input>
          </el-form-item>
          <el-form-item label="新闻内容" prop="n_detail1">
            <el-input
              type="textarea"
              :row="8"
              v-model="updateNewsList.n_detail1"
              autosize
            >
            </el-input>
          </el-form-item>

          <el-form-item label="新闻日期" prop="n_date_str">
            <el-date-picker
              v-model="updateNewsList.n_date_str"
              type="date"
              placeholder="选择日期"
            >
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="updateNewsDialogVisible = false"
          >关 闭</el-button
        >
        <el-button type="primary" @click="handleUpdateNews">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import moment from "moment";
import {
  getAllNews,
  selectNewsById,
  addNews,
  deleteNews,
  updateNews,
} from "@/api/news";
export default {
  data() {
    return {
      updateNewsDialogVisible: false,
      updateNewsFormDataRules: {
        n_title: [
          { required: true, message: "请输入新闻标题", trigger: "blur" },
        ],
        n_detail1: [
          { required: true, message: "选择输入新闻内容", trigger: "blur" },
        ],
        n_date_str: [
          { required: true, message: "请选择新闻日期", trigger: "change" },
        ],
      },
      updateNewsList: {
        n_id: "",
        n_title: "",
        n_detail1: "",
        n_date: "",
      },
      updateNewsListNew: {
        n_id: "",
        n_title: "",
        n_detail1: "",
        n_date_str: "",
      },
      updateNewslDialogVisible: false,
      addNewsFormDataRules: {
        n_title: [
          { required: true, message: "请输入新闻标题", trigger: "blur" },
        ],
        n_detail1: [
          { required: true, message: "选择输入新闻内容", trigger: "blur" },
        ],
        n_date_str: [
          { required: true, message: "请选择新闻日期", trigger: "change" },
        ],
      },
      addNewsList: {
        n_title: "",
        n_detail1: "",
        n_date_str: "",
      },
      newsList: [],
      currentPage: 1,
      total: 0,
      SearchFormData: {
        condition: "",
        pageNum: 1,
        pageSize: 10,
      },
      detailDialogVisible: false,
      AddNewslDialogVisible: false,
      newsDetailData: {
        n_id: "",
        n_title: "",
        n_detail1: "",
        n_date: "",
      },
      deleteNewsData: {
        n_id: "",
      },
    };
  },
  methods: {
    //表格时间回显处理
    formatTime(row, column) {
      let date = row[column.property];
      if (date === undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD");
    },
    //输入框数据回显
    dateFormat(date) {
      const dt = new Date(date);
      const y = dt.getFullYear();
      const m = (dt.getMonth() + 1 + "").padStart(2, "0");
      const d = (dt.getDate() + "").padStart(2, "0");

      const hh = (dt.getHours() + "").padStart(2, "0");
      const mm = (dt.getMinutes() + "").padStart(2, "0");
      const ss = (dt.getSeconds() + "").padStart(2, "0");

      return `${y}-${m}-${d}`;
    },
    openFun() {
      this.$nextTick(() => {
        if (this.$refs["AddNewsRef"]) {
          this.$refs["AddNewsRef"].resetFields();
        }
      });
    },
    tableRowClassName({ row, rowIndex }) {
      return "success-row";
    },
    getNewsList() {
      getAllNews(this.SearchFormData).then((res) => {
        console.log(res);
        this.newsList = res.list;
        this.total = res.total;
      });
    },
    handleSizeChange(value) {
      this.SearchFormData.pageSize = value;
      this.getNewsList();
    },
    handleCurrentChange(value) {
      this.currentPage = value;
      this.SearchFormData.pageNum = value;
      this.getNewsList();
    },
    handleSearchClick() {
      this.getNewsList();
    },
    //查看新闻详情
    handleNewsDetailClick(value) {
      this.detailDialogVisible = true;
      this.newsDetailData.n_id = value.n_id;
      selectNewsById(this.newsDetailData).then((res) => {
        console.log(res);
        this.newsDetailData = res;
      });
    },
    handleAddNewsClick() {
      this.AddNewslDialogVisible = true;
    },
    //点击确定增加新闻按钮
    handAddNews() {
      const AddNewsRef = this.$refs["AddNewsRef"];
      AddNewsRef.validate((validate) => {
        if (validate) {
          addNews(this.addNewsList).then((res) => {
            Object.keys(this.addNewsList).forEach((key) => {
              this.addNewsList[key] = "";
            });
            console.log(res);
            if (res.code == 200) {
              this.$message({
                message: res.msg,
                type: "success",
              });
              this.AddNewslDialogVisible = false;
              this.getNewsList();
            }
          });
        }
      });
    },
    //编辑新闻回显数据
    handleNewsEditClick(value) {
      this.updateNewsDialogVisible = true;
      this.updateNewsList.n_id = value.n_id;
      selectNewsById(this.updateNewsList).then((res) => {
        console.log(res);
        this.updateNewsList = res;
        this.updateNewsList.n_date_str = moment(res.n_date).format(
          "YYYY-MM-DD"
        );
      });
    },
    //点击提交修改新闻
    handleUpdateNews() {
      this.updateNewsListNew.n_id = this.updateNewsList.n_id;
      this.updateNewsListNew.n_title = this.updateNewsList.n_title;
      this.updateNewsListNew.n_detail1 = this.updateNewsList.n_detail1;
      this.updateNewsListNew.n_date_str = this.updateNewsList.n_date_str;

      //先进行校验
      const UpdateNewsRef = this.$refs["UpdateNewsRef"];
      UpdateNewsRef.validate((validate) => {
        if (validate) {
          updateNews(this.updateNewsListNew).then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.msg,
                type: "success",
              });
              //关闭弹框
              this.updateNewsDialogVisible = false;
              //回显数据
              this.getNewsList();
            }
          });
        }
      });
    },
    handleDeleteNewsClick(value) {
      console.log(11);
      this.deleteNewsData.n_id = value.n_id;
      deleteNews(this.deleteNewsData).then((res) => {
        if (res.code == 200) {
          this.$message({
            message: res.msg,
            type: "success",
          });
          this.getNewsList();
        }
      });
    },
    handAddNewsCancle() {
      this.AddNewslDialogVisible = false;
      Object.assign(this.$data.addNewsList, this.$options.data().addNewsList);
    },
  },
  created() {
    this.getNewsList();
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

::v-deep .el-table .warning-row {
  background: #065279;
}

::v-deep .el-table .success-row {
  // background: 	#99BBFF;
  background: #ccccff;
}
</style>