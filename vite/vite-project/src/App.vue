<script setup>

import Top from "./components/Top.vue";
import {reactive, provide, ref} from "vue";
import CourseUtil from "./assets/CommonJs/utils/CourseUtil.js";


/**
 * 以下是对课程列表的初始化
 */
let courseList = reactive([])
CourseUtil.getCourseList(courseList)//最初执行一次获取courseList列表的操作，之后在课程增删改后再次执行
provide('courseList', courseList)

/**
 *
 * 以下代码是对student的初始化
 */
let student = reactive({})
provide('student', student)//利用provide向全局提供一个student对象


/**
 * 以下是对admin的初始化
 */
let admin = reactive({})
provide('admin', admin)


let isLogin = ref(localStorage.getItem('isLogin') === 'true')
let isAdmin = ref(localStorage.getItem('isAdmin') === 'true')

function updateLoginState(newState) {
  isLogin.value = newState.isLogin
  isAdmin.value = newState.isAdmin
}

provide('isLogin', isLogin)
provide('isAdmin', isAdmin)
provide('updateLoginState', updateLoginState)


</script>

<template>
  <Top></Top>
  <div class="apart"></div><!--因为top脱离了文档流所有这里的div只是为了撑开top所占的位置-->
  <router-view></router-view>


</template>

<style scoped>
.apart {
  height: 130px;
}

</style>
