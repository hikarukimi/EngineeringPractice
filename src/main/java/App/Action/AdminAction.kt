package App.Action

import App.Message.MessageEnum
import App.Request.AdminRequest
import App.mappers.AdminMapper
import App.pojo.Admin
import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @Description
 * @Author hikarukimi
 */
@CrossOrigin(origins = ["http://localhost:5173/"])
@RestController
@RequestMapping("/admin")
class AdminAction @Autowired constructor(private val adminMapper: AdminMapper) {
    /**
     * @description 管理员登录的接口 返回的消息是adminId和message
     * 用户名和密码均正确时才能登录成功
     */
    @PostMapping("/login")
    fun login(@RequestBody admin: Admin): ResponseEntity<String> {
        val selectOne = adminMapper.selectOne(QueryWrapper<Admin>()
            .eq("username", admin.username).eq("password",admin.password))
            ?: return ResponseEntity.badRequest().body(MessageEnum.USERNAME_OR_PASSWORD_ERROR.toString())
        return ResponseEntity.ok(
            JSON.toJSONString(
                AdminRequest.returnMessage(
                    selectOne.adminId!!,
                    MessageEnum.USER_LOGIN_SUCCESS
                )
            )
        )
    }
    /**
     * @description 根据adminId获取管理员相关的信息
     */
    @GetMapping("/message")
    fun message(@RequestParam("adminId") adminId:Int):ResponseEntity<String>{
        val admin = adminMapper.selectById(adminId)
        return ResponseEntity.ok(JSON.toJSONString(admin))
    }

}