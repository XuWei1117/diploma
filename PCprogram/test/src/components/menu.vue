<template>
  <div class="nav-menu">
    <el-row class="tac">
      <el-col>
        <el-menu
          :default-active="defaultActive"
          class="el-menu-vertical-demo"
          background-color="	#9999FF"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
          style="margin-top:60px"
        >
    <el-menu-item v-for="(item,index) in navMenuList" :key="index" :index="item.path" style="text-align:center;">
    {{item.title}}
    </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Menu",
  props: {
    msg: String,
  },
  data() {
    return {
      navMenuList: [
        {
          path:'/home/ClassList',
          title:"课程列表"
        },
            {
          path:'/home/TecherList',
          title:"教师列表"
        },
            {
          path:'/home/OrderList',
          title:"订单列表"
        },
            {
          path:'/home/UserList',
          title:"用户列表"
        },
            {
          path:'/home/CommentList',
          title:"评论列表"
        },
        {
          path:'/home/NewsList',
          title:"新闻列表"
        }
      ],
      defaultActive:null
    };
  },
  created(){
    this.defaultActive = this.$route.path
    console.log(this.defaultActive);
  },
  watch:{
    $route:function() {
        this.defaultActive = this.$route.path
    }
  }
};
</script>

<style lang="less" scoped>
.nav-menu{
  width: 100%;
  height: 100%;
      background-color: 	#9999FF;
  .tac{

  }
}
</style>