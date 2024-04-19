package App.Action;

import App.Message.MessageBuilder;
import App.Message.MessageEnum;
import App.Request.StudentRequest;
import App.mappers.CourseStudentMapper;
import App.mappers.StudentMapper;
import App.pojo.CourseStudent;
import App.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173/")//允许跨域请求
@RequestMapping("/student")
@RestController
public class StudentAction {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseStudentMapper courseStudentMapper;
    /**
     * @description 用户注册, 检查出username重复发送用户名已存在
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Student student) {

        List<Student> students = studentMapper.selectList(new LambdaQueryWrapper<Student>().eq(Student::getUsername, student.getUsername()));
        if (students.isEmpty()) {
            studentMapper.insert(student);
            return ResponseEntity.ok(MessageEnum.USER_REGISTER_SUCCESS.toString());
        } else {
            return ResponseEntity.badRequest().body(JSON.toJSONString( new MessageBuilder(MessageEnum.USERNAME_ALREADY_EXISTS.toString())));
        }
    }

    /**
     * @description 用户登录
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student) {

        Student selectedStudent = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getUsername, student.getUsername())
                .eq(Student::getPassword, student.getPassword()));
        if (selectedStudent == null) {
            return ResponseEntity.badRequest().body(MessageEnum.USERNAME_OR_PASSWORD_ERROR.toString());
        } else {
            return ResponseEntity.ok(JSON.toJSONString(StudentRequest.returnMessage(selectedStudent.getSid(), MessageEnum.USER_LOGIN_SUCCESS)));
        }
    }

    /**
     * @description 通过学生的sid查询学生的其他信息
     */
    @GetMapping("/message")
    public ResponseEntity<String> message(@RequestParam(value = "sid") int sid) {
        Student student = studentMapper.selectById(sid);
        return ResponseEntity.ok(JSON.toJSONString(student));
    }

    /**
     * @description 用户选择课程
     */
    @PostMapping("/selectCourse")
    public ResponseEntity<String> selectCourse(@RequestBody List<CourseStudent> courseStudentList) {
        courseStudentList.forEach(
                (courseStudent ->
                    courseStudentMapper.insert(courseStudent)
                )
        );
        return ResponseEntity.ok( JSON.toJSONString(new MessageBuilder(MessageEnum.SELECT_COURSE_SUCCESS.toString())));
    }

}
