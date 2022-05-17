<template>
  <div class="container">
    <div class="login-wrapper">
      <div class="header">
        <span class="title">未来教育后台管理系统</span>
        <h1 >登录</h1>
      </div>

      <div class="form-wrapper">
        <el-form
          :model="ruleForm"
          status-icon
          label-width="100px"
          class="demo-ruleForm"
          style="text-align: center"
          :rules="loginRules"
          ref="loginRef"
        >
          <el-form-item label="用户名" class="usernameCss" prop="u_name" style="margin-top:40px">
            <el-input
              type="text"
           v-model="ruleForm.u_name"
              autocomplete="off"
              placeholder="请输入用户名"
              
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="u_password">
            <el-input
              type="password"
              v-model="ruleForm.u_password"
              autocomplete="off"
              placeholder="请输入密码"
            ></el-input>
          </el-form-item>
          <el-button  class="btn" @click="login">
            登录
          </el-button>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { Login } from "@/api/login";
export default {
  data() {
    return {
      loginRules: {
        u_name: [{ required: true, message: "请输入用户名", trigger: "blur" }],
        u_password: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ],
      },
      ruleForm: {
        u_name: "",
        u_password: "",
      },
    };
  },
  methods: {
    login() {
      console.log(123)
      //进行参数校验
      const loginRef = this.$refs["loginRef"];
      loginRef.validate((validate) => {
        if (validate) {
          Login(this.ruleForm).then((res) => {
            if (res.code == 200) {
              this.$message({
                message: res.msg,
                type: "success",
              });

              setTimeout(() => {
                this.$router.push("/home"); // 强制切换当前路由 path
                loading.close();
              }, 2000);
            }
            if (res.code == 400) {
              this.$message({
                message: res.msg,
                type: "warning",
              });
            }
          });
        }
      });
    },
  },
};
</script>

<style lang="less" scoped>
/* 清除浏览器默认边距，
使边框和内边距的值包含在元素的width和height内 */
* {
  margin: 0;
  padding: 0;
}
html {
  height: 100%;
}
body {
  height: 100%;
}
.container {
  height: 100%;
  background-image: linear-gradient(to right, #e2f4c3, #a6c1ee);
}
.login-wrapper {
  background-color: #fff;
  width: 400px;
  height: 588px;
  border-radius: 15px;
  padding: 0 50px;
  position: relative;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.header {
  text-align: center;
}
.header .title {
  line-height: 200px;
  font-size: 38px;
  font-weight: bold;
}
.input-item {
  display: block;
  width: 100%;
  margin-bottom: 20px;
  border: 0;
  padding: 10px;
  border-bottom: 1px solid rgb(128, 125, 125);
  font-size: 15px;
  outline: none;
}
.input-item:placeholder {
  text-transform: uppercase;
}
.btn {
  text-align: center;
  padding: 10px;
  width: 100%;
  margin-top: 40px;
  background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
  color: #fff;
  border: none;
}
a {
  text-decoration-line: none;
  color: #abc1ee;
}

.form-wrapper .el-form-item__label {
  text-align: center;
}
.usernameCss {
  margin-bottom: 30px;
}
.login {
  font-size: 38px;
  font-weight: bold;
  text-align: center;
  line-height: 200px;
}
</style>