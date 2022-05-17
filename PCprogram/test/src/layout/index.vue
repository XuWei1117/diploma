<template>
  <div class="layout">
    <el-container class="app-container">
      <!-- <el-header class="app-header">
                  <h1>未来教育后台管理系统</h1>
      </el-header> -->
      <el-container class="app-content">
        <el-aside width="200px" class="app-menu">
             <Menu /> 
        </el-aside>
  <el-main class="app-main">
      <router-view />
  </el-main>
      </el-container>
    </el-container>

    
  </div>
</template>

<script>
import Menu from "@/components/menu.vue";

export default {
  components: {
    Menu,
  },
};
</script>

<style lang="less" scoped>
.layout{
  width: 100%;
  height: 100%;
  .app-container{
  width: 100%;
  height: 100%;
  .app-header{
    width: 100%;
    padding: 0;
    & h1{
      font-size: 18px;
      line-height: 60px;
      margin-left: 10px;
    }
  }
  .app-content{
    display: flex;
    width: 100%;
    height: 100%;
    .app-menu{
      width: 200px;
    }
    .app-main{
      flex: 1;
    }
  }
}
}

</style>