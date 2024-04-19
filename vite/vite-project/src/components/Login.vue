<script setup>
import {inject, reactive, ref} from "vue";
import checkParam from "../assets/CommonJs/check/LoginOrRegisterCheckParam.js"
import {useRouter} from "vue-router";
import LoginOrRegisterUtil from "../assets/CommonJs/LoginOrRegisterCommonJs.js";


const ACTION = 'login'//定义该用户行为的全局常量，登陆时区别于注册action
let roleMessage = ref('我是管理员')
let router=useRouter()
let courseList=inject('courseList')
let student=inject('student')
let admin=inject('admin')
let isAdmin=inject('isAdmin')
let isLogin=inject('isLogin')


let entity = reactive({
  username: '',
  password: '',
  isAdmin: isAdmin,//判断当前用户是否为管理员
  isLogin:isLogin
})//登陆时需要的entity信息，账号密码及其是否是管理员


/**
 * 调用loginOrRegister方法发起登录请求并且获得返回的数据(登录成功或者登录失败)
 */
function changeRole() {
  entity.isAdmin = !entity.isAdmin
  if (entity.isAdmin === true) {
    roleMessage.value = '我是用户'
  } else {
    roleMessage.value = '我是管理员'
  }
}

function login(entity) {
  checkParam(entity)//检查参数是否合法
  if(entity.isAdmin===true){
    LoginOrRegisterUtil.loginOrRegister(entity, ACTION,router,courseList,admin)//执行登录操作
  }else{
    LoginOrRegisterUtil.loginOrRegister(entity, ACTION,router,courseList,student)//执行登录操作
  }


}


</script>

<template>

  <el-form class="el-form" label-width="auto" @submit.prevent="login(entity)">
    <el-form-item style="margin-left: 60px"><h1>登录</h1></el-form-item>
    <el-form-item label="用户名">
      <el-input v-model=entity.username placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model=entity.password type="password" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item>
      <router-link to="/register">点我注册</router-link>
      <router-link to="/forgetPassword" style="margin-left: 10px;margin-right: 8px">忘记密码</router-link>
      <ins class="iAmAdmin" @click="changeRole">{{ roleMessage }}</ins>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit" style="width:150px;margin-left: 50px">登录</el-button>
    </el-form-item>
  </el-form>

</template>

<style scoped>
.el-form {
  width: 200px;
  margin: auto;
}
.iAmAdmin:hover {
  cursor: pointer;
}
</style>