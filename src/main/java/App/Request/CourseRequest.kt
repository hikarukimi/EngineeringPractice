package App.Request

import App.Message.CourseMessage
import App.pojo.Course

/**
 * @Description 用于course相关和前端交互实际完成数据转化的工作
 * @Author hikarukimi
 */
data class CourseRequest(
    var courseId: Int, var name: String,
    var courseNature: String, var totalTime: Int,
    var score: Int, var startTime: String
) {

    /**
     * @author hikarukimi
     * @description 将List<Course>转化为List<CourseRequest> 完成startTime从int转换为String
     */
    companion object {
        @JvmStatic
        fun buildList(courseList: List<Course>): List<CourseRequest> {
            return courseList.map { course ->
                CourseRequest(
                    course.courseId!!, course.name,
                    courseNature =
                    when (course.courseNature) {
                        1 -> CourseMessage.CourseNature.必修.toString()
                        2 -> CourseMessage.CourseNature.选修.toString()
                        else -> {
                            CourseMessage.CourseNature.Error.toString()
                        }
                    }, course.totalTime, course.score,
                    startTime =
                    when (course.startTime) {
                        1 -> CourseMessage.StartTimeMessage.大一上学期.toString()
                        2 -> CourseMessage.StartTimeMessage.大一下学期.toString()
                        3 -> CourseMessage.StartTimeMessage.大二上学期.toString()
                        4 -> CourseMessage.StartTimeMessage.大二下学期.toString()
                        5 -> CourseMessage.StartTimeMessage.大三上学期.toString()
                        6 -> CourseMessage.StartTimeMessage.大三下学期.toString()
                        7 -> CourseMessage.StartTimeMessage.大四上学期.toString()
                        8 -> CourseMessage.StartTimeMessage.大四下学期.toString()
                        else -> CourseMessage.StartTimeMessage.Error.toString()
                    }

                )
            }
        }


    }
}