package App.Request

import App.Message.MessageEnum

/**
 * @Description  用于student相关和前端交互实际完成数据转化的工作，目前作用仅为返回一个sid，messageEnum的对象,方便前端接受
 * @Author hikarukimi
 */
data class StudentRequest(
    var sid: Int, var messageEnum: MessageEnum
) {
    companion object {
        @JvmStatic
        fun returnMessage(sid: Int, messageEnum: MessageEnum): StudentRequest {
            return StudentRequest(sid, messageEnum)

        }
    }


}