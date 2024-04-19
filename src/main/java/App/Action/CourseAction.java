package App.Action;

import App.Message.MessageBuilder;
import App.mappers.CourseMapper;
import App.pojo.Course;
import App.pojo.CourseStudent;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin("http://localhost:5173/")
public class CourseAction {

    @Autowired
    private CourseMapper courseMapper;
/**
 * @description 管理员插入课程
 */
    @PostMapping("/submit")
    public ResponseEntity<String> submit(@RequestBody Course course) {
        courseMapper.insert(course);
        return ResponseEntity.ok(JSON.toJSONString(new MessageBuilder("ok")));
    }

/**
 * @description 单纯地返回课程列表
 */
    @GetMapping("/list")
    public ResponseEntity<String> list() {
        List<Course> courseList = courseMapper.selectList(new QueryWrapper<>());
        return ResponseEntity.ok(JSON.toJSONString(courseList));
    }

    /**
     * @description 通过传来的courseStudent中携带的courseId，关联查询到student对应的courseList
     */
    @PostMapping("listForOneStudent")
    public ResponseEntity<String> listForOneStudent(@RequestBody List<CourseStudent> listCourseStudent) {
        List<Course> courseList = new ArrayList<>();
        for (CourseStudent courseStudent : listCourseStudent) {
            Course course = courseMapper.selectById(courseStudent.getCourseId());
            if (course != null) {
                courseList.add(course);
            }
        }
        return ResponseEntity.ok(JSON.toJSONString(courseList));
    }

    /**
     * @description 根据id查找课程信息
     */
    @GetMapping("/getByCourseId")
    public ResponseEntity<String> getByCourseId(@RequestParam("courseId")int courseId){
        Course course = courseMapper.selectById(courseId);
        return ResponseEntity.ok(JSON.toJSONString(course));
    }
    /**
     * @description 更新课程
     */
    @PostMapping("update")
    public ResponseEntity<String> update(@RequestBody Course course){
             courseMapper.updateById(course);
             return ResponseEntity.ok(JSON.toJSONString(new MessageBuilder("ok")));

    }
    @GetMapping("delete")
    public ResponseEntity<String> delete(@RequestParam("courseId") int courseId){
        courseMapper.deleteById(courseId);
        return ResponseEntity.ok(JSON.toJSONString(new MessageBuilder("ok")));
    }

}
