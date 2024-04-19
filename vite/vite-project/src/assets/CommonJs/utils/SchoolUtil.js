import FetchUtil from "./BaseUtil/FetchUtil.js";

class SchoolUtil{
    /**
     * 获取学院列表
     * @param schoolList
     */
    static getList(schoolList){
        FetchUtil.getRequest('http://localhost:8080/school/list').then(response=>{
            Object.assign(schoolList,response)
        })
    }
}
export default SchoolUtil