package App

/**
 * @Description 用来描述后端返回信息的类
 * @Author hikarukimi
 */
enum class MessageEnum {
    /**
     * @author hikarukimi
     * @description 用户名已存在
     */
    USERNAME_ALREADY_EXISTS,
    USER_REGISTER_SUCCESS,
    USER_LOGIN_SUCCESS,
    USERNAME_OR_PASSWORD_ERROR,
    USER_NOT_EXISTS
}