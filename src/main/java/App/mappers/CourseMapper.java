package App.mappers;

import App.pojo.Course;
import App.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author hikarukimi
 */
@Transactional
public interface CourseMapper extends BaseMapper<Course> {

    Student selectStudentCourse(int sid);
}
