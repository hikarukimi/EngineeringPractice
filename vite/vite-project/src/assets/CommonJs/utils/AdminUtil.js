
import FetchUtil from "./BaseUtil/FetchUtil.js";
/**
 * ��������ڷ�װһЩ�͹���Ա��صĲ���
 */
class AdminUtil{
    /**
     *  ͨ��adminId��ȡ����Ա������Ϣ
     */
    static getMessage(adminId){
        const url=`http://localhost:8080/admin/message?adminId=${adminId}`
        return  FetchUtil.getRequest(url)
    }

    /**
     * ��¼��صĲ������ɵ���loginOrRegisterCommonJs��ȥ��
     * @param admin
     */
    static login(admin){
        admin.adminId=localStorage.getItem('adminId')
        this.getMessage(admin.adminId).then(response=>{
            Object.assign(admin,response)//��¼�ɹ�֮����Ϣ���ؽ��봫���admin����
        })
    }

}

export default  AdminUtil