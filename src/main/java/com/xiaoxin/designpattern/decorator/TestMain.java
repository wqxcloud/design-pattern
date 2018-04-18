package com.xiaoxin.designpattern.decorator;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 上午11:59
 */
public class TestMain {

    /**
     * 总结：装饰模式适用于，在原有功能上增加功能，或者功能链顺序无关紧要时可以使用。
     * 缺点：个人感觉装饰模式的继承关系有点混乱
     *
     * @param args
     */
    public static void main(String[] args){
        Tree tree = new Tree("圣诞树");
        ShiningDecorator shiningDecorator = new ShiningDecorator();
        shiningDecorator.decorator(tree);
        WishPaperDecorator wishPaperDecorator = new WishPaperDecorator();
        wishPaperDecorator.decorator(shiningDecorator);
        wishPaperDecorator.makeWish();
    }
}
