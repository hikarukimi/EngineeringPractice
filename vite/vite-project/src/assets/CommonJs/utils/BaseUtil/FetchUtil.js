/**
 * 本类封装一些fetchApi的常用操作
 * 返回的都是解决状态的promise，并且其中内容均是按json解析
 */
class FetchUtil{
    /**
     * @param url
     * @returns 返回请求成功时的promise对象
     */
    static async  getRequest(url){
            return await
            fetch(url).then(response => response.json())
        }


    /**
     * @param url
     * @param data
     * @returns 返回请求成功时的promise对象
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