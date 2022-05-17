<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px; margin-top: 30px">
      评论列表
    </h1>
    <div>
      <el-form class="search-form" :model="SearchFormData">
        <el-row class="search-form-items">
          <el-form-item label="条件" label-width="75px">
            <el-input
              style="width: 300px"
              v-model="SearchFormData.condition"
              placeholder="可根据评论者、课程名称进行搜索"
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
        </el-row>
      </el-form>
    </div>
    <div style="width: 1101px; margin: auto">
      <el-table
        :data="commentList"
        border
        style="width: 100%"
        :header-cell-style="{ background: '#9999FF ', color: 'white' }"
        :row-class-name="tableRowClassName"
      >
        <el-table-column
          align="center"
          type="index"
          label="序号"
          width="150"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          prop="user_name"
          label="评论者"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="course_name"
          label="评论课程"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="comment_date"
          label="评论时间"
          width="250"
          align="center"
          :formatter="formatTime"
        >
        </el-table-column>
        <el-table-column
          prop="comment_desc"
          label="评论内容"
          width="300"
          align="center"
        >
        </el-table-column>
        <el-table-column label="操作" width="100" align="center">
          <template slot-scope="scope">
            <el-button
              type="danger"
              @click="handleDeleteCommentClick(scope.row)"
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
  </div>
</template>

<script>
import moment from "moment";
import { getAllCommentList, deleteCommentList } from "@/api/comment";
export default {
  data() {
    return {
      commentList: [],
      currentPage: 1,
      total: 0,
      SearchFormData: {
        condition: "",
        pageNum: 1,
        pageSize: 10,
      },
      deleteCommentInfo: {
        comment_id: 0,
      },
    };
  },
  methods: {
    //格式化时间
    formatTime(row, column) {
      let date = row[column.property];
      if (date === undefined) {
        return "";
      }
      return moment(date).format("YYYY-MM-DD HH:mm:ss");
    },
    handleDeleteCommentClick(row) {
      this.deleteCommentInfo.comment_id = row.comment_id;
      deleteCommentList(this.deleteCommentInfo).then((res) => {
        if (res.code == 200) {
          this.getCommentList();
          this.$message({
            message: res.msg,
            type: "success",
          });
        }
      });
    },
    tableRowClassName({ row, rowIndex }) {
      return "success-row";
    },
    getCommentList() {
      getAllCommentList(this.SearchFormData).then((res) => {
        console.log(res);
        this.commentList = res.list;
        this.total = res.total;
      });
    },
    handleSizeChange(value) {
      this.SearchFormData.pageSize = value;
      this.getCommentList();
    },
    handleCurrentChange(value) {
      this.currentPage = value;
      this.SearchFormData.pageNum = value;
      this.getCommentList();
    },
    handleSearchClick() {
      this.getCommentList();
    },
  },
  created() {
    this.getCommentList();
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