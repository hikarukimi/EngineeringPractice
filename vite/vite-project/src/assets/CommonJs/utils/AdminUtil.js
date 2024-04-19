
import FetchUtil from "./BaseUtil/FetchUtil.js";
/**
 * 这个类用于封装一些和管理员相关的操作
 */
class AdminUtil{
    /**
     *  通过adminId获取管理员更多信息
     */
    static getMessage(adminId){
        const url=`http://localhost:8080/admin/message?adminId=${adminId}`
        return  FetchUtil.getRequest(url)
    }

    /**
     * 登录相关的操作集成到了loginOrRegisterCommonJs中去了
     * @param admin
     */
    static login(admin){
        admin.adminId=localStorage.getItem('adminId')
        this.getMessage(admin.adminId).then(response=>{
            Object.assign(admin,response)//登录成功之后将信息加载进入传入的admin对象
        })
    }

}

export default  AdminUtil