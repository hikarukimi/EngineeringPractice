<script setup>

</script>

<template>
  <header>
    <div class="top-nav">
      <h1 class="title" style="color: chocolate">傻逼选课系统</h1>
      <div class="left">
        <router-link to="/"><el-link :underline="false">主页</el-link></router-link>
        <p>选课系统</p>
        <p>巴拉巴拉小魔仙</p>
      </div>
      <div class="center"></div>
      <div class="right"></div>

        <router-link to="/login"> <el-link :underline="false">我要登录</el-link></router-link>


    </div>

  </header>

</template>

<style scoped>
  header{
    height: 60px;
    position: fixed;
    z-index: 999;
    width: 100%;
  }
  .top-nav{
    display: flex;
    align-items: center;
    justify-content: space-around;
    border-bottom: aqua 1px solid;
  }
  .left{
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 350px;

  }




</style>