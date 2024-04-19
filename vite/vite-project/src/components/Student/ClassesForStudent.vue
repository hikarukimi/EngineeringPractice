<script setup>
import {inject, reactive, ref} from "vue";
import CourseUtil from "../../assets/CommonJs/utils/CourseUtil.js";



let isLogin = ref(JSON.parse(localStorage.getItem('isLogin')))
let student = reactive(inject('student'))//从app组件获取到student对象
let courseList = reactive(inject('courseList'))


// courseUtil.initCourseIsHave(courseList,student.courseList)

let isClick = ref(false)

function changeClick() {
  isClick.value = !isClick.value
}


/**
 * 对单个课程做出选择动作时执行的函数
 * @param course 选择的单个课程对象
 */
function selectCourse(course) {
  course.isSelected = !course.isSelected
  if (course.isHave) {
    alert('你已经选择了该课程')
  }

}

/**
 * 用户选择完所需课程时调用，
 */
function confirmCourse() {

  CourseUtil.insertList(courseList, student)
  changeClick()//切换dialog状态


}

async function deleteByStudent(courseId, student) {

  await CourseUtil.deleteByStudent(courseId, student)//先执行完当前函数再执行下一步


  CourseUtil.initCourseIsHave(courseList, student.courseList)

}

</script>

<template>

  <div v-if="!isLogin">你还没有登录</div>
  <div v-if="isLogin"><!--登录时才展示该div中的内容-->

    <h1>学生端选课系统页面</h1>

    <el-table :data="courseList" style="width: 600px;margin: auto;">
      <el-table-column prop="name" label="名字" width="100px"></el-table-column>
      <el-table-column prop="courseNature" label="课程性质" width="100px"></el-table-column>
      <el-table-column prop="score" label="学分" width="100px"></el-table-column>
      <el-table-column prop="totalTime" label="总共课时"></el-table-column>
      <el-table-column prop="startTime" label="起始学期"></el-table-column>
      <el-table-column type="selection" width="100px">
        <template #default="{row,}"><!--row插槽可以获得一行的数据-->
          <el-checkbox @change="selectCourse(row)" v-if="row.isHave===false"></el-checkbox>
          <el-button v-if="row.isHave===true" @click="deleteByStudent(row.courseId,student)">退钱</el-button>
        </template>
      </el-table-column>

    </el-table>
    <el-button type="primary" style="margin-left:700px;margin-top: 50px;width: 300px" @click="changeClick">确认选择
    </el-button>
    <el-dialog v-model="isClick" title="傻逼选课系统" :center="true">
      <span>你确定要选择这些吗</span><br>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="changeClick">Cancel</el-button>
          <el-button type="primary" @click="confirmCourse()">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>


<style scoped>
</style>