<script setup>
import {reactive, ref, watch} from "vue";
import LoginOrRegisterUtil from "../assets/CommonJs/LoginOrRegisterCommonJs.js";
import checkParam from "../assets/CommonJs/check/LoginOrRegisterCheckParam.js"
import SchoolUtil from "../assets/CommonJs/utils/SchoolUtil.js";


const entity_ACTION = 'register'//定义该用户行为的全局常量，登陆时区别于登录action

let checkPassword = ref('')//用于确认密码
let resultTimes = ref(1)//其实只是为了解决监视result改变导致的多次点击不再提示该用户名已被占用的问题罢了
let result = ref('')


let entity = reactive({
  nickname: '',
  username: '',
  password: '',
  schoolId: ''
})
/**
 * 对学院列表进行初始化
 * @type {UnwrapNestedRefs<*[]>}
 */
let schools = reactive([])
SchoolUtil.getList(schools)


function register(entity) {
  if (checkParam(entity, entity_ACTION)) {
    if (checkPassword.value !== entity.password) {
      alert('两次输入的密码不一致')
    }
    LoginOrRegisterUtil.loginOrRegister(entity, entity_ACTION).then(response => {
          resultTimes.value += 1
          result.value = response
        }
    )
  }
}

watch(resultTimes, function () {
  if (result.value === 'USERNAME_ALREADY_EXISTS') {
    alert('该用户名已被占用')
    result.value = ''//重置result防止一直弹窗
  }
})

</script>

<template>
  <el-form class="el-form" label-width="auto" @submit.prevent="register(entity)">
    <el-form-item style="margin-left: 60px"><h1>用户注册</h1></el-form-item>
    <el-form-item label="昵称">
      <el-input v-model=entity.nickname placeholder="请输入你的昵称"></el-input>
    </el-form-item>
    <el-form-item label="用户名">
      <el-input v-model=entity.username placeholder="请输入用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model=entity.password type="password" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item label="确认密码">
      <el-input v-model=checkPassword type="password" placeholder="请再次输入密码"></el-input>
    </el-form-item>
    <el-select v-model="entity.schoolId">
      <el-option v-for="school in schools" :key="school.schoolId" :value="school.schoolId" :label="school.name">
      </el-option>
    </el-select>
    <el-form-item style="margin-top: 10px">
      <el-button type="primary" native-type="submit" style="width:150px;margin-left: 50px">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>
.el-form {
  width: 200px;
  margin: auto;
}
</style>