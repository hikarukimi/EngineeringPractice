/**
 * 这个js文件是为了实现鼠标点击时在周围出现色块同时向左和向右运动的效果
 */


/**
 * @returns String 返回一个随机的颜色
 */
function generateRandomColor() {
    // 生成随机颜色的函数实现
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

/**
 * 色块类
 */

class colorSpan {
    constructor(x, y) {
        //通过该constructor创造一个element
        this.element = document.createElement('span');
        this.element.className = 'random-color-span';
        this.element.style.backgroundColor = generateRandomColor();
        this.element.style.width = '5px';
        this.element.style.height = '5px';
        this.element.style.position = 'absolute';
        this.element.style.borderRadius = '100%'
        this.element.style.left = `${x}px`;
        this.element.style.top = `${y}px`;
        this.element.style.zIndex = 30;
        // 开始动画
        this.animate();
    }

    /**
     * 更新当前色块的位置
     */

    animate() {
        this.vx = Math.floor(Math.random() * 3);//每一帧的速度都需要重新生成
        this.vy = Math.floor(Math.random() * 3);

        const newLeft = parseInt(this.element.style.left.split('px')[0]) + this.vx;
        const newTop = parseInt(this.element.style.top.split('px')[0]) + this.vy

        // 检查边界条件，防止元素移出视口
        if (newLeft + this.element.offsetWidth > window.innerWidth || newLeft < 0) {
            this.vx = -this.vx; // 反向移动0
        }
        if (newTop + this.element.offsetHeight > window.innerHeight || newTop < 0) {
            this.vy = -this.vy; // 反向移动
        }
        // 更新元素位置
        this.element.style.left = `${newLeft}px`;
        this.element.style.top = `${newTop}px`;
        // 请求下一帧动画
        requestAnimationFrame(this.animate.bind(this));
    }

    // 0.5秒后让span元素消失
    startFadeOut() {
        setTimeout(() => {
            document.body.removeChild(this.element)
        }, 1000);
    }
}

document.addEventListener('DOMContentLoaded', function () {
    document.body.addEventListener('click', function (e) {
        let x = e.pageX;
        let y = e.pageY;

        for (let i = 0; i < 15; i++) {
            const span = new colorSpan(x, y);
            document.body.appendChild(span.element);
            span.startFadeOut();
        }

    });
});