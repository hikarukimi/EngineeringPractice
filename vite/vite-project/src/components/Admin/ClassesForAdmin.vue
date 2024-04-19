<script setup>
import {inject, reactive, ref} from "vue";
import CourseUtil from "../../assets/CommonJs/utils/CourseUtil.js";


let isLogin = ref(JSON.parse(localStorage.getItem('isLogin')))
let courseList = reactive(inject('courseList'))

function deleteCourse(courseId) {
  CourseUtil.delete(courseId).then(_ => {
    CourseUtil.reCourseList(courseList)
  })
}


</script>

<template>
  <el-table :data="courseList" style="width: 800px;margin: auto;">
    <el-table-column prop="name" label="名字" width="100px"></el-table-column>
    <el-table-column prop="courseNature" label="课程性质" width="100px"></el-table-column>
    <el-table-column prop="score" label="学分" width="100px"></el-table-column>
    <el-table-column prop="totalTime" label="总共课时"></el-table-column>
    <el-table-column prop="startTime" label="起始学期"></el-table-column>
    <el-table-column>
      <template #default="{ row }">
        <router-link :to="`/classesForAdmin/updateCourse?courseId=${row.courseId}`">
          <el-button type="primary">修改课程</el-button>
        </router-link>
      </template>
    </el-table-column>
    <el-table-column>
      <template #default="{row}">
        <el-button type="danger" @click="deleteCourse(row.courseId)">删除课程</el-button>
      </template>

    </el-table-column>

  </el-table>
  <router-link to="/classesForAdmin/insertCourse">
    <el-button type="primary" style="margin-left: 50%">增加课程</el-button>
  </router-link>


</template>

<style scoped>


</style>