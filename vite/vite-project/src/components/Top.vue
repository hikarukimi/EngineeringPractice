<script setup>
import {inject} from "vue";
import {useRouter} from "vue-router";

let router = useRouter()

/**
 * TODO 考量这个方法的合理性
 */



const isLogin = inject('isLogin')
const isAdmin = inject('isAdmin')
const updateLoginState = inject('updateLoginState')

function loginOut() {
  localStorage.removeItem('isLogin')
  localStorage.removeItem('isAdmin')
  localStorage.removeItem('sid')
  localStorage.removeItem('adminId')
  updateLoginState({ isLogin: false, isAdmin: false })
  router.push({ path: '/' })
}




</script>

<template>

  <header>
    <div class="top-nav">
      <h1 class="title" style="color: chocolate">傻逼选课系统</h1>
      <div class="left">
        <router-link to="/">
          <el-link :underline="false">主页</el-link>
        </router-link>
        <router-link to="/classesForStudent" v-if="!isAdmin">
          <el-link :underline="false">学生选课系统</el-link>
        </router-link>
        <router-link to="/classesForAdmin" v-if="isAdmin">
          <el-link :underline="false">管理员选课系统</el-link>
        </router-link>
        <router-link to="/myMessageForStudent" v-if="!isAdmin">
          <el-link :underline="false">学生个人中心</el-link>
        </router-link>

        <router-link to="/myMessageForAdmin" v-if="isAdmin">
          <el-link :underline="false">管理员个人中心</el-link>
        </router-link>
      </div>
      <div class="center"></div>
      <div class="right"></div>
      <router-link to="/login" v-if="!isLogin">
        <el-link :underline="false">我要登录</el-link>
      </router-link>
      <el-button type="primary" @click="loginOut" v-if="isLogin">退出登录</el-button>
    </div>

  </header>

</template>

<style scoped>
header {
  height: 60px;
  position: fixed;
  z-index: 999;
  width: 100%;
}

.top-nav {
  display: flex;
  align-items: center;
  justify-content: space-around;
  border-bottom: aqua 1px solid;
}

.left {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 350px;

}
</style>