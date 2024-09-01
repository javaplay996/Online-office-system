<template>
  <div>
    <!--    头部-->
    <div style="display: flex; height: 100px; line-height: 60px; border-bottom: 1px solid #eee">
      <div style="width: 300px; display: flex; padding-left: 30px">
        <div style="width: 60px">
          <img src="../../assets/logo.jpg" alt="" style="width: 80px; position: relative; top: 8px; right: 0">
        </div>
        <div style="flex: 1;padding-left: 30px;">欢迎来到办公系统</div>
      </div>
      <div style="flex: 1;margin-top: 10px; margin-bottom: 10px">
        <el-card style="height: 80px; width: 800px;text-align: center;display: flex; justify-content: center">
          <template>
            <el-menu :default-active="'1'" class="el-menu-demo" style="display: flex;justify-content: center;line-height: 30px" mode="horizontal" router>
              <el-menu-item index="/front/home">
                首页
              </el-menu-item>
              <el-menu-item index="/front/myNotice">查看公告</el-menu-item>
              <el-menu-item index="/front/myEmail">发邮件</el-menu-item>
              <el-menu-item index="/front/myPersonFile">我的人事档案</el-menu-item>
              <el-menu-item index="/front/frontIm">在线聊天</el-menu-item>
            </el-menu>
          </template>
        </el-card>
      </div>
      <div style="width: 200px">
        <div v-if="!user.username" style="text-align: right; padding-right: 30px">
          <el-button @click="$router.push('/login')">登录</el-button>
          <el-button @click="$router.push('/register')">注册</el-button>
        </div>
        <div v-else>
          <el-dropdown style="width: 150px; cursor: pointer; text-align: right">
            <div style="display: inline-block">
              <img :src="user.avatarUrl" alt=""
                   style="width: 30px; border-radius: 50%; position: relative; top: 10px; right: 5px">
              <span>{{ user.nickname }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            </div>
            <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <router-link to="/front/password"><div>修改密码</div></router-link>
              </el-dropdown-item>
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <router-link to="/front/person"><div>个人信息</div></router-link>
              </el-dropdown-item>
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <span style="text-decoration: none" @click="logout"><div>退出</div></span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>

    <div style="width: 1000px; margin: 0 auto">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "Front",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {

  },
  methods: {
    logout() {
      this.$store.commit("logout")
      this.$message.success("退出成功")
    }
  }
}
</script>

<style>
.item{
  display: inline-block;
  width: 100px;

  text-align: center;
  cursor: pointer
}
.item a {
  color: 	#1E90FF;
}
.item:hover{
  background-color: 	LightPink;
}
</style>
