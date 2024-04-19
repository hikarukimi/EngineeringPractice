/**
 * 检查登录注册时信息是否完整
 * @param student
 * @param studentAction
 * @returns {boolean}
 */
export default function checkFormParamIsNotnull(student, studentAction) {
    if (student.username === '' || student.password === '') {
        alert('信息不完整')
        return false//不论登录或者注册通用的初步检查
    }
    if (studentAction === 'register' && (student.nickname === '' || student.school === '')) {
        alert('信息不完整')//注册行为时的进一步检查
        return false
    }
    return true
}