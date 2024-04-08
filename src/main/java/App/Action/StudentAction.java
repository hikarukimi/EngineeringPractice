package App.Action;

import App.MessageEnum;
import App.mappers.StudentMapper;
import App.pojo.Student;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("student")
@RestController
public class StudentAction {

    @Autowired
    private StudentMapper mapper;

    @RequestMapping("StudentList")
    public String StudentList()
    {
        ArrayList<Student> students = mapper.StudentList();
        return JSON.toJSONString(students);
    }
/**
 * @param student:
 * @return ResponseEntity<Integer>
 * @author hikarukimi
 * @description 用户注册, 检查出username重复发送用户名已存在
 */
    @PostMapping("studentRegister")
    public ResponseEntity<MessageEnum> studentRegister(@RequestBody Student student)
    {

        List<Student> students = mapper.selectList(new LambdaQueryWrapper<Student>().eq(Student::getUsername,student.getUsername()));
        if (students.isEmpty()){
            mapper.insert(student);
            return ResponseEntity.ok(MessageEnum.USER_REGISTER_SUCCESS);
        }else{
            return ResponseEntity.badRequest().body(MessageEnum.USERNAME_ALREADY_EXISTS);
        }
    }
    /**
     * @param student:
     * @return ResponseEntity<Integer>
     * @author hikarukimi
     * @description 用户登录
     */
    @PostMapping("studentLogin")
    public ResponseEntity<MessageEnum> studentLogin(@RequestBody Student student)
    {

        Student selectedStudent = mapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getUsername, student.getUsername())
                .eq(Student::getPassword, student.getPassword()));
        if(selectedStudent==null){
            return ResponseEntity.badRequest().body(MessageEnum.USERNAME_OR_PASSWORD_ERROR);
        }else {
            return ResponseEntity.ok(MessageEnum.USER_LOGIN_SUCCESS);
        }
    }

    @RequestMapping("StudentDelete")
    public int StudentDelete(@RequestParam("sid") String sid)
    {
        return mapper.deleteById(sid);
    }

//    @PostMapping("StudentEdit")
//    public int StudentEdit(@RequestBody Student student)
//    {
//        LambdaUpdateWrapper<Student> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
//        lambdaUpdateWrapper.set(Student::getName,student.getName()).set(Student::getQq,student.getQq())
//                .set(Student::getSchoolId,student.getSchoolId()).eq(Student::getSid,student.getSid());
//    return mapper.update(student,lambdaUpdateWrapper);
//    }

    @GetMapping("StudentInfo")
    public String StudentInfo(@RequestParam("sid") String sid)
    {
        return JSON.toJSONString(mapper.StudentInfo(sid));
    }
}
