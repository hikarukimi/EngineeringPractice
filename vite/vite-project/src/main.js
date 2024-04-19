import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import {createRouter, createWebHistory} from "vue-router";
import Home from "./components/Home.vue";
import Login from "./components/Login.vue";
import ClassesForStudent from "./components/Student/ClassesForStudent.vue";
import ClassesForAdmin from "./components/Admin/ClassesForAdmin.vue";
import Register from "./components/Register.vue";
import ForgetPassword from "./components/ForgetPassword.vue";
import MyMessageForStudent from "./components/Student/MyMessageForStudent.vue";
import MyMessageForAdmin from "./components/Admin/MyMessageForAdmin.vue";
import insertCourse from "./components/CourseUtilComponent/insertCourse.vue";
import updateCourse from "./components/CourseUtilComponent/updateCourse.vue"



const app = createApp(App)
const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/login',
        component: Login
    }, {
        path: '/classesForStudent',
        component: ClassesForStudent
    }, {
        path: '/classesForAdmin',
        component: ClassesForAdmin,
    },
    {
        path: '/register',
        component: Register
    }, {
        path: '/forgetPassword',
        component: ForgetPassword
    }, {
        path: '/myMessageForStudent',
        component: MyMessageForStudent
    }, {
        path: '/myMessageForAdmin',
        component: MyMessageForAdmin
    },{
        path:'/classesForAdmin/insertCourse',
        component: insertCourse
    },{
        path:'/classesForAdmin/updateCourse',
        component: updateCourse
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});
app.use(ElementPlus)
app.use(router)
app.mount('#app')

