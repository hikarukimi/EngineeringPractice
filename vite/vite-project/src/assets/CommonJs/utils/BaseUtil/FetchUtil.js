/**
 * �����װһЩfetchApi�ĳ��ò���
 * ���صĶ��ǽ��״̬��promise�������������ݾ��ǰ�json����
 */
class FetchUtil{
    /**
     * @param url
     * @returns ��������ɹ�ʱ��promise����
     */
    static async  getRequest(url){
            return await
            fetch(url).then(response => response.json())
        }


    /**
     * @param url
     * @param data
     * @returns ��������ɹ�ʱ��promise����
     */
    static async postRequest(url, data) {

        return await
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            }).then(response => response.json())
    }


}

export  default  FetchUtil