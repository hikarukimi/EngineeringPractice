/**
 * �����װ��һЩ���ڶ�Ԫ��Ϊ�������͵��������ط���
 */
class ObjectArrayUtil{
    /**
     *
     * @param array ���������
     * @param item  �Ƚ��õĶ���
     * @param target ��Ҫ���ڱȽϵĸ���
     * @returns {boolean}
     * ���ݴ����target�ж��������Ƿ��ж����е�target����ֵ��it��target��ֵ���
     */
    static   isIncludeSameValue(array, item, target) {

        let boolean = array.some(
            (arrayItem) => {
                if (arrayItem[target] === item[target]) {
                    return true//�����trueֻ�ǽ�������array.some��������Ҫ������isInclude����Ҫ��дһ��return
                }
            }
        )
        return !!boolean;
    }
}
export default ObjectArrayUtil