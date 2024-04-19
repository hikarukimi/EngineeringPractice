package App.Message

/**
 * @Description 用来将数据库返回的以整形的方式呈现startTime转化为意思更为明确的String
 * @Author hikarukimi
 */
class CourseMessage {
    enum class StartTimeMessage {
        大一上学期,
        大一下学期,
        大二上学期,
        大二下学期,
        大三上学期,
        大三下学期,
        大四上学期,
        大四下学期,
        Error
    }

    enum class CourseNature {
        必修,
        选修,
        Error
    }

}
