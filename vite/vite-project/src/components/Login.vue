<script setup>
import {reactive} from "vue";
let userLoginMessage=reactive({
  username:'',
  password:''

})
</script>

<template>

  <el-form class="userLoginMessage">
    <el-form-item class="usernameAndPassword">
      <el-input  v-model=userLoginMessage.username placeholder="请输入用户名" class="username"></el-input>
      <el-input v-model=userLoginMessage.password type="password" placeholder="请输入密码" class="password"></el-input>
    </el-form-item>
  </el-form>
</template>

<style scoped>
  .userLoginMessage{
    width: 200px;
    margin: auto;

  }
</style>