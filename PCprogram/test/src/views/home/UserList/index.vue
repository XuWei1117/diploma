<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px;margin-top:30px">用户列表</h1>
    <div style="width: 801px; margin: auto">
      <el-table :data="userList" border style="width: 100%" :header-cell-style="{ background: '#9999FF ', color: 'white' }"
      :row-class-name="tableRowClassName">
        <el-table-column
          align="center"
          type="index"
          label="序号"
          width="200"
          header-align="center"
        >
        </el-table-column>
        <el-table-column
          prop="u_name"
          label="用户名"
          width="200"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="u_gender"
          label="性别"
          width="200"
          align="center"
        >
          <template slot-scope="scope">
            <span v-if="scope.row.u_gender === 0">男</span>
            <span v-if="scope.row.u_gender === 1">女</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="u_newLogin"
          label="最近登录时间"
          width="200"
          align="center"
        >
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
import { getAllUser } from "@/api/user";
export default {
  data() {
    return {
      userList: [],
      currentPage: 1,
      total: 0,
      SearchFormData: {
        pageNum: 1,
        pageSize: 10,
      },
    };
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      return "success-row";
    },
    getUserList() {
      getAllUser(this.SearchFormData).then((res) => {
        console.log(res);
        this.userList = res.list;
        this.total = res.total;
      });
    },
    handleSizeChange(value) {
      this.SearchFormData.pageSize = value;
      this.getUserList();
    },
    handleCurrentChange(value) {
      this.currentPage = value;
      this.SearchFormData.pageNum = value;
      this.getUserList();
    },
    handleSearchClick(){
         this.getUserList();
    }
  },
  created() {
    this.getUserList();
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