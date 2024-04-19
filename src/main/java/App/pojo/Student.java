package App.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;
    @TableField("school_id")
    private int schoolId;
    @TableField("nickname")
    private String nickname;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;

    @TableField(exist = false)
    private School school;//通过schoolId关联到school
    @TableField(exist = false)
    private List<Course> courseList;//表示该用户选择的课程列表

}
