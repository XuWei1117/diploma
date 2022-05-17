<template>
  <div>
    <h1 style="text-align: center; margin-bottom: 30px; margin-top: 30px">
      订单列表
    </h1>
    <div>
      <el-form class="search-form" :model="SearchFormData">
        <el-row class="search-form-items">
          <el-form-item label="条件" label-width="75px">
            <el-input
              style="width: 300px"
              v-model="SearchFormData.condition"
              placeholder="可根据购买者、课程名、授课老师进行搜索"
            ></el-input>
          </el-form-item>

          <el-form-item label="订单状态" label-width="75px">
            <el-select
              style="width: 100%"
              v-model="SearchFormData.r_status"
              clearable
            >
              <el-option
                v-for="(item, index) in r_statusList"
                :key="index"
                :label="item.label"
                :value="item.value"
                style="width: 100px"
              >
              </el-option>
            </el-select>
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
    <div style="width: 1291px; margin: auto">
      <el-table
        :data="orderList"
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
          prop="r_number"
          label="订单编号"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="user_name"
          label="购买者"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="r_name"
          label="课程名"
          width="190"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="r_price"
          label="课程价格"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="r_teacher"
          label="授课老师"
          width="150"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="r_status"
          label="订单状态"
          width="150"
          align="center"
        >
          <template slot-scope="scope">
            <el-button v-if="scope.row.r_status === 0" type="warning"
              >未支付</el-button
            >
            <el-button v-if="scope.row.r_status === 1" type="info"
              >已支付</el-button
            >
          </template>
        </el-table-column>

        <el-table-column
          label="删除"
          width="100"
          align="center"
        >
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.r_status === 0"
              type="danger"
              @click="handleDeleteOrderClick(scope.row)"
              icon="el-icon-delete"
              circle
            ></el-button>
          </template>
        </el-table-column>

        <el-table-column
          label="支付"
          width="100"
          align="center"
        >
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.r_status === 0"
              style="background-color:#99BBFF"
              @click="handlePayOrderClick(scope.row)"
            >去支付</el-button>
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
import { getAllOrderList, deleteOrder,payOrder } from "@/api/order";
export default {
  data() {
    return {
      orderList: [],
      currentPage: 1,
      total: 0,
      SearchFormData: {
        condition: "",
        pageNum: 1,
        pageSize: 10,
      },
      r_statusList: [
        {
          value: 0,
          label: "未支付",
        },
        {
          value: 1,
          label: "已支付",
        },
      ],
      deleteOrderData: {
        r_id: "",
      },
      payOrderData: {
        r_id: "",
      },
    };
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      return "success-row";
    },
    getOrderList() {
      getAllOrderList(this.SearchFormData).then((res) => {
        console.log(res);
        this.orderList = res.list;
        this.total = res.total;
      });
    },
    handleSizeChange(value) {
      this.SearchFormData.pageSize = value;
      this.getOrderList();
    },
    handleCurrentChange(value) {
      this.currentPage = value;
      this.SearchFormData.pageNum = value;
      this.getOrderList();
    },
    handleSearchClick() {
      this.getOrderList();
    },
    handleDeleteOrderClick(value) {
      this.deleteOrderData.r_id = value.r_id;
      deleteOrder(this.deleteOrderData).then((res) => {
        if (res.code == 200) {
          this.$message({
            message: res.msg,
            type: "success",
          });
        }
        this.getOrderList();
      });
    },

    handlePayOrderClick(value) {
      this.payOrderData.r_id = value.r_id;
      payOrder(this.payOrderData).then((res) => {
        if (res.code == 200) {
          this.$message({
            message: res.msg,
            type: "success",
          });
        }
        this.getOrderList();
      });
    },
  },
  created() {
    this.getOrderList();
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