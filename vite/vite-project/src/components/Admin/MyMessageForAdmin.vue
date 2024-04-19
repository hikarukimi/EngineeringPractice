<script setup>
import {inject} from "vue";


let admin = inject('admin')
</script>

<template>


  <el-card style="width: 500px;margin: auto">
    <template #header>
      my profile
    </template>
    <p>昵称:{{ admin.nickname }}</p>
    <p>username:{{ admin.username }}</p>
    <template #footer>
      还没能让你发挥全力真是抱歉啊
    </template>


  </el-card>

</template>

<style scoped>

</style>