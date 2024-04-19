import CourseUtil from "./CourseUtil.js";
import FetchUtil from "./BaseUtil/FetchUtil.js";

class StudentUtil{
    /**
     *
     * @param student
     * @param courseList
     */
    static login(student,courseList){
        student.sid=localStorage.getItem('sid')//ִ�е�¼����ʱstudentΪ�ն���
        StudentUtil.getMessage(student).then(_=>{
            CourseUtil.initCourseIsHave(courseList,student.courseList)
        })//��ʼ���û���Ϣ�������ʼ����Ϊֻ��sidΪ��ʱ����ִ�У�������һ��ֻ���û��ɹ���¼��Ż�ִ�еĴ���
    }
/**
 *
 * @returns {Promise<void>}������������˸�ϵͳ���û���ص�������Ϣ������nickname��username��student���л������ݣ�Ҳ��ȡ��schoolId��ӳ���courseList
 */
static  async getMessage(student) {

    return   FetchUtil.getRequest(`http://localhost:8080/student/message?sid=${student.sid}`).then(async response => {
        Object.assign(student, response)//�˴���response��student�������������nickname��username�ȵ�


         await CourseUtil.getCourseListForStudent(student)//��ͨ��student�����ȡ���İ༶����ѡ�γ̵���Ϣ


    })




}
}
export {StudentUtil}