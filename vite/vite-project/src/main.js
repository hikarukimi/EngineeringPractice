import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import {createRouter, createWebHistory} from "vue-router";
import Home from "./components/Home.vue";
import Login from "./components/Login.vue";
import Classes from "./components/Classes.vue";
import Register from "./components/Register.vue"
import ForgetPassword from "./components/ForgetPassword.vue";
import MyMessage from "./components/MyMessage.vue";


const app = createApp(App)
const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/login',
        component: Login
    },{
        path: '/classes',
        component: Classes
    },{
        path:'/register',
        component: Register
    },{
        path: '/forgetPassword',
        component: ForgetPassword
    },{
        path:'/myMessage',
        component: MyMessage
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});
app.use(ElementPlus)
app.use(router)
app.mount('#app')

