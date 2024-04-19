<script setup>
import {inject, reactive} from "vue";
import CourseUtil from "../../assets/CommonJs/utils/CourseUtil.js";

let courseList = inject('courseList')
let startTime = CourseUtil.startTime
let natures = CourseUtil.natures

let course = reactive({
  'name': '',
  'courseNature': '',
  'totalTime': '',
  'score': '',
  'startTime': ''
})

function insertCourse(course) {

  const copyCourse = CourseUtil.reForm(course)

  CourseUtil.insert(copyCourse).then(response => {

    CourseUtil.reCourseList(courseList)
  })


}


</script>

<template>
  <el-form :model="course" style="width: 500px;margin: auto" @submit.prevent="insertCourse(course)">
    <el-form-item>
      <p>新建课程</p>
    </el-form-item>
    <el-form-item label="课程名称">
      <el-input placeholder="请输入课程名称" v-model="course.name"></el-input>
    </el-form-item>
    <el-form-item label="课程性质">
      <el-select placeholder="请做出选择" v-model="course.courseNature">
        <el-option v-for="nature in natures" :value="nature" :label="nature"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="课程总学时">
      <el-input placeholder="请输入课程的总学时" v-model="course.totalTime"></el-input>
    </el-form-item>
    <el-form-item label="学分">
      <el-select v-model="course.score">
        <el-option v-for="score in [1,2,3,4]" :value="score"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="开始时间">
      <el-select v-model="course.startTime">
        <el-option v-for="time in startTime" :value="time"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" native-type="submit">提交该课程</el-button>
    </el-form-item>


  </el-form>
</template>

<style scoped>

</style>