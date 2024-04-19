package App.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId

/**
 * @Description
 * @Author hikarukimi
 */

data class Admin(
    @TableId("admin_id", type = IdType.AUTO)
    var adminId: Int?,
    var username: String,
    var password: String,
    var nickname: String?
)