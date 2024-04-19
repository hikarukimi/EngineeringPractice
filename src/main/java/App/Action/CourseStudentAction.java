package App.Action;

import App.Message.MessageBuilder;
import App.mappers.CourseStudentMapper;
import App.pojo.CourseStudent;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author hikarukimi
 */
@RestController
@RequestMapping("courseStudent")
@CrossOrigin("http://localhost:5173/")
public class CourseStudentAction {
    @Autowired
    private CourseStudentMapper courseStudentMapper;
    /**
     * @description 查询所有与参数相同sid的数据
     */
    @GetMapping("selectCourseIds")
    public ResponseEntity<String>selectCourseIds(@RequestParam("sid") int sid) {
        List<CourseStudent> courseStudents = courseStudentMapper.selectAllBySid(sid);
        return ResponseEntity.ok(JSON.toJSONString(courseStudents));

    }
    /**
     * @param courseId:
     * @param sid:
     * @return ResponseEntity<String>
     * @description 根据传入的courseId和sid删除对应的数据
     */
    @GetMapping("delete")
    public ResponseEntity<String> delete(@RequestParam("courseId")int courseId,@RequestParam("sid") int sid){
        Map<String,Object> map=new HashMap<>();
        map.put("course_id",courseId);
        map.put("sid",sid);
        courseStudentMapper.deleteByMap(map);
        return ResponseEntity.ok(JSON.toJSONString(new MessageBuilder("ok")));
    }
}
