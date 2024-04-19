import FetchUtil from "./BaseUtil/FetchUtil.js";
import {reactive} from "vue";
import ObjectArrayUtil from "./BaseUtil/ObjectArrayUtil.js";

class CourseUtil {
    static baseURL='http://localhost:8080/course/'

    /**
     * 课程性质的列表
     * TODO 改为从数据库获取
     */
    static natures=reactive(['必修','选修'])
    /**
     * 课程开始时间的列表
     * TODO 改为从数据库获取
     */
    static startTime=reactive(['大一上','大一下','大二上','大二下','大三上','大三下','大四上','大四下'])


    static insert(course){
        return FetchUtil.postRequest(CourseUtil.baseURL+'submit',course)
    }

    /**
     *
     * @param courseList 筛选出其中被选择的课程，在数据库层面完成与student的courseList属性绑定
     * @param student 用于更新student的信息和更新courseList中的isHave
     * 完成课程的选择
     * 重新加载新的学生课程列表
     * 更新courseList表中各个course的isHave属性
     */
    static async insertList(courseList,student){
        let selectedCourseList = []//只筛选出被选中的课程
        courseList.forEach((item) => {
            if (item.isSelected === true) {
                let courseStudent = {
                    'sid': student.sid,
                    'courseId': item.courseId
                }
                selectedCourseList.push(courseStudent)//临时创建列表将添加的课程放入其中
            }
        })

        if(selectedCourseList!==[]){

            await  FetchUtil.postRequest('http://localhost:8080/student/selectCourse',selectedCourseList)//提交选择的课程
            await  this.getCourseListForStudent(student)//重新获取学生的信息（学生选择的课程列表）
            this.initCourseIsHave(courseList,student.courseList)//将重新获得的学生课程列表和courseList作对比，将添加的课程在courseList的isHave设为true

        }
    }

    static delete(courseId){
        return FetchUtil.getRequest(CourseUtil.baseURL+'delete?courseId='+courseId)
    }



    /**
     * 学生主导的课程删除事件，即将该课程从学生的课程列表中删除
     * @param courseId
     * @param student
     */
    static async deleteByStudent(courseId,student){

        await FetchUtil.getRequest(`http://localhost:8080/courseStudent/delete?courseId=${courseId}&sid=${student.sid}`)

        student.courseList = student.courseList.filter(course => course.courseId !== courseId);




    }
    static update(course){
        const copyCourse=this.reForm(course)//将课程中的一些字符串转回int
        return FetchUtil.postRequest(
            CourseUtil.baseURL+'update',copyCourse)

    }

    static getByCourseId(courseId){
        return FetchUtil.getRequest(CourseUtil.baseURL+'getByCourseId?courseId='+courseId)

    }

    /**
     * 查询所有课程,传入一个courseList会将所有数据放入其中
     */
    static async getCourseList(courseList) {

        const data=await FetchUtil.getRequest(CourseUtil.baseURL+'list')

        data.forEach((it,index) => {
                it.isSelected = false//为每个course添加一个该属性，描述该course是否被选中
                if (ObjectArrayUtil.isIncludeSameValue(courseList, it, 'courseId')) {

                    courseList[index] = it//如果该数组存在该courseId的元素则对其进行更新操作

                } else {
                    courseList.push(it)//防止reCourse时重复添加course进入courseList
                }
            }
        )
        if(data.length<courseList.length){
            courseList.pop()//如果执行了删除操作，则将courseList中多余的课程删除
        }

    }

    /**
     *
     *  查询传入学生对象对应的课程列表
     */
    static async getCourseListForStudent(student) {
        const courseIdResponse = await FetchUtil.getRequest(`http://localhost:8080/courseStudent/selectCourseIds?sid=${student.sid}`);
        student.courseList = await FetchUtil.postRequest(this.baseURL + 'listForOneStudent', courseIdResponse);
        student.school = await FetchUtil.getRequest(`http://localhost:8080/school/get?schoolId=${student.schoolId}`);
    }

    /**
     * 传入courseList 用于对课程做了增删改操作之后实时更新courseList列表
     * @param courseList
     */
    static async reCourseList(courseList){
       await this.getCourseList(courseList)

    }
    /**
     * 前端中有些参数以文字的形式展示，但是在后端是以数字存存储的，本方法是将前端的字符串转化为后端的数字
     * 返回一个拷贝对象
     * @param course
     */
    static reForm(course){
        let copyCourse=JSON.parse(JSON.stringify(course))//对course实现深拷贝，防止更改其中的courseNature和startTime之后页面显示发生变化
        copyCourse.courseNature=(this.natures.indexOf(course.courseNature)+1)
        copyCourse.startTime=(this.startTime.indexOf(course.startTime)+1)
        return copyCourse

    }

    /**
     * 对上方的操作进行取反
     * @param course
     */
    static backForm(course){
        course.courseNature=this.natures[course.courseNature-1]
        course.startTime=this.startTime[course.startTime-1]
    }

    static initCourseIsHave(courseList,studentCourseList){


        courseList.forEach(item=>{
                item.isHave = ObjectArrayUtil.isIncludeSameValue(studentCourseList, item, 'courseId');
            }
        )

    }

}

export default CourseUtil