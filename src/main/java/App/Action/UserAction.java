package App.Action;
import App.mappers.UserMapper;
import App.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
@Controller
public class UserAction {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("UserAdd")
    public String UserADD(User user){
        userMapper.UserAdd(user);
        return JSON.toJSONString(user);
    }
    @ResponseBody
    @RequestMapping("userCheck")
    public Boolean userCheck(@RequestBody User user) {
        User resultUser = userMapper.UserCheck(user);
        return resultUser != null;
    }
}
