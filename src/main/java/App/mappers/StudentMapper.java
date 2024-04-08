package App.mappers;
import App.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface StudentMapper extends BaseMapper<Student> {
    ArrayList<Student> StudentList();
    @Select("select * from student where sid=#{sid}")
    Student StudentInfo(String sid);
}
