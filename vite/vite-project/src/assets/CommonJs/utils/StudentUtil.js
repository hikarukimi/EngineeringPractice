import CourseUtil from "./CourseUtil.js";
import FetchUtil from "./BaseUtil/FetchUtil.js";

class StudentUtil{
    /**
     *
     * @param student
     * @param courseList
     */
    static login(student,courseList){
        student.sid=localStorage.getItem('sid')//执行登录操作时student为空对象
        StudentUtil.getMessage(student).then(_=>{
            CourseUtil.initCourseIsHave(courseList,student.courseList)
        })//初始化用户信息，这个初始化因为只有sid为真时才能执行，所以是一个只有用户成功登录后才会执行的代码
    }
/**
 *
 * @returns {Promise<void>}这个方法返回了该系统中用户相关的所有信息，包括nickname，username等student表中基本数据，也获取了schoolId的映射和courseList
 */
static  async getMessage(student) {

    return   FetchUtil.getRequest(`http://localhost:8080/student/message?sid=${student.sid}`).then(async response => {
        Object.assign(student, response)//此处的response是student对象基本属性如nickname，username等等


         await CourseUtil.getCourseListForStudent(student)//再通过student对象获取他的班级及所选课程的信息


    })




}
}
export {StudentUtil}