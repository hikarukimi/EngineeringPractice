
import FetchUtil from "./utils/BaseUtil/FetchUtil.js";
import {StudentUtil} from "./utils/StudentUtil.js";
import AdminUtil from "./utils/AdminUtil.js";
/**
 *
 * @param entity 放在请求体中的数据
 * @param entityAction 请求的地址，用来区分该请求是登陆还是注册
 * @param router
 * @param courseList
 * 这个方法是为了解耦登录注册时几乎一致的代码

 * @param student
 */
class LoginOrRegisterUtil{
    /**
     * 登录或注册的基本操作
     * @param entity post请求中的对象
     * @param entityAction 标识当前操作是登录还是注册
     * @param router 更新路由
     * @param courseList 用于初始化课程列表的isHave信息
     * @param messageGetter
     * @returns {Promise<*>}
     */
    static async  loginOrRegister(entity, entityAction,router,courseList,messageGetter) {

        let path = `http://localhost:8080/student/${entityAction}`//如果是学生则通过该默认path
        if (entity.isAdmin) {
            path = `http://localhost:8080/admin/${entityAction}`//如果判断当前是以管理员身份登录则更改路径
        }
        let message=await FetchUtil.postRequest(path,entity)
        localStorage.setItem('isLogin', 'true')
        entity.isLogin=true
        if(message.hasOwnProperty('adminId')){
            localStorage.setItem('isAdmin', entity.isAdmin)
            localStorage.setItem('adminId', message.adminId)
            AdminUtil.login(messageGetter)
        }else if(message.hasOwnProperty('sid')){
            localStorage.setItem('sid', message.sid)
            StudentUtil.login(messageGetter,courseList)

        }
        router.push({path: '/'});
        return message
    }
}
export default LoginOrRegisterUtil








