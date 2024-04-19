import FetchUtil from "./BaseUtil/FetchUtil.js";

class SchoolUtil{
    /**
     * ��ȡѧԺ�б�
     * @param schoolList
     */
    static getList(schoolList){
        FetchUtil.getRequest('http://localhost:8080/school/list').then(response=>{
            Object.assign(schoolList,response)
        })
    }
}
export default SchoolUtil