<script setup>
import {inject} from "vue";


let isLogin = localStorage.getItem('isLogin')
let sid = localStorage.getItem('sid')


let student = inject('student')


</script>

<template>
  <div v-if="!isLogin"><h1>还没有登录哦</h1></div>
  <div v-if="isLogin">

    <el-card style="width: 500px;margin: auto">
      <template #header>
        my profile
      </template>

      <p>昵称:{{ student.nickname }}</p>
      <p v-if="student.school">学院:{{ student.school.name }}</p><!--这个if是防止程序报错-->
      <p>已经参与的课程</p>
      <div v-if="student.courseList" v-for="course in student.courseList">
        {{ course.name }}
        <p v-if="student.courseList.length===0">您还没有参加任何课程</p>
      </div><!--这个if是防止程序报错-->

    </el-card>
  </div>

</template>

<style scoped>

</style>