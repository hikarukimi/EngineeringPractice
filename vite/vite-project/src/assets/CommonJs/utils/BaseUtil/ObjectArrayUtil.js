/**
 * 本类封装了一些用于对元素为对象类型的数组的相关方法
 */
class ObjectArrayUtil{
    /**
     *
     * @param array 传入的数组
     * @param item  比较用的对象
     * @param target 需要用于比较的根基
     * @returns {boolean}
     * 根据传入的target判断数组中是否有对象中的target属性值与it的target的值相等
     */
    static   isIncludeSameValue(array, item, target) {

        let boolean = array.some(
            (arrayItem) => {
                if (arrayItem[target] === item[target]) {
                    return true//这里的true只是结束掉了array.some函数，想要结束掉isInclude还需要再写一个return
                }
            }
        )
        return !!boolean;
    }
}
export default ObjectArrayUtil