<script setup>

</script>

<template>
  <el-form class="el-form" label-width="auto" @submit.prevent="login(student)">
    <el-form-item style="margin-left: 60px"><h1>用户登录</h1></el-form-item>
    <el-form-item  label="用户名" >
      <el-input v-model=student.username placeholder="请输入用户名" ></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model=student.password type="password" placeholder="请输入密码" ></el-input>
    </el-form-item>
    <el-form-item>
      <router-link to="/register" style="margin-left: 50px;margin-right: 30px">点我注册</router-link>
      <router-link to="/forgetPassword">忘记密码</router-link>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit" style="width:150px;margin-left: 50px" >登录</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>