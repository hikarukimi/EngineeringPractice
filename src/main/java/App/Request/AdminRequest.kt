package App.Request

import App.Message.MessageEnum

/**
 * @Description
 * @Author hikarukimi
 */
data class AdminRequest(var adminId: Int, var messageEnum: MessageEnum) {
    companion object {
        fun returnMessage(adminId: Int, messageEnum: MessageEnum): AdminRequest {
            return AdminRequest(adminId, messageEnum)
        }
    }
}
