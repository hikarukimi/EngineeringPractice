package App.Action

import App.mappers.SchoolMapper
import App.pojo.School
import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @Description
 * @Author hikarukimi
 */
@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/school")
class SchoolAction @Autowired constructor(private val schoolMapper: SchoolMapper) {

/**
 * @description 获取学院列表
 */
    @GetMapping("/list")
    fun list(): ResponseEntity<String> {

        val selectList = schoolMapper.selectList(QueryWrapper())
        return ResponseEntity.ok(JSON.toJSONString(selectList))
    }
    /**
     * @description 通过传入的schoolId获取对应的学院
     */
    @GetMapping("get")
    fun getSchool(@RequestParam("schoolId") schoolId:Int):ResponseEntity<String>{
        return ResponseEntity.ok(JSON.toJSONString(schoolMapper.selectOne(QueryWrapper<School?>().eq("school_id",schoolId))))
    }

}