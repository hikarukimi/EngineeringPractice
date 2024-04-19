package App.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class School implements Serializable {
    @TableField("name")
    private String name;
    @TableId(value = "school_id", type = IdType.AUTO)
    private int schoolId;


}
