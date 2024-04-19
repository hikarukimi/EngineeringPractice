package App.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 因为course和student是多对多的关系所以用中间表承接两表的关联
 * @Author hikarukimi
 */
@Data
public class CourseStudent implements Serializable {

    private int sid;

    private int courseId;
}
