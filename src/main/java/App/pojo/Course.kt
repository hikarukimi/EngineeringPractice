package App.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId

/**
 * @Description course表对应的实体类
 * @Author hikarukimi
 */

data class Course(
    @TableId(value = "course_id", type = IdType.AUTO)
    var courseId: Int?,
    @TableField(value = "name")
    var name: String,
    /**
     * @description 描述课程性质，选修/必修
     */
    @TableField(value = "course_nature")
    var courseNature: Int,
    @TableField(value = "total_time")
    var totalTime: Int,
    @TableField(value = "score")
    var score: Int,
    @TableField(value = "start_time")
    var startTime: Int,

    )