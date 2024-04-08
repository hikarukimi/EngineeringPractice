package App.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Student {
    @TableId(value = "sid",type = IdType.AUTO)
    private int sid;
    @TableField("school_id")
    private int schoolId;
    private String name;
    private String nickname;
    private String username;
    private String password;

}
