package App.mappers

import App.pojo.CourseStudent
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Select

/**
 * @Description
 * @Author hikarukimi
 */
interface CourseStudentMapper : BaseMapper<CourseStudent> {
    @Select("select sid,course_id from course_student where course_student.sid=#{sid}")
    fun selectAllBySid(sid: Int): List<CourseStudent>//查询所有sid等于参数的CourseStudent

}