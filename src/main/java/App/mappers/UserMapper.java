package App.mappers;
import App.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    @Insert("insert into user (username, password, nickname)   values (#{username},#{password},#{nickname})")
    int UserAdd(User user);
    @Select("select * from user where username=#{username} and password=#{password}")
    User UserCheck(User user);
}
