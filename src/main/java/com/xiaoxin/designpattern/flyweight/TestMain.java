package com.xiaoxin.designpattern.flyweight;

import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/29 下午5:02
 */
public class TestMain {


    /**
     * 享元模式可以避免大量非常相似类的开销。在程序设计中，有时需要生成大量细粒度的类实例来表示数据。
     * 如果能发现这些实例除了几个参数外基本上都是相同的，有时就能够大幅度地减少需要实例化类的数量。
     * 如果能把那些参数移到类实例的外面，在方法调用时将它们传递进来，就可以通过共享进而达到减少
     * 实例数量的目的。本例中ChinessChess采用了单例模式和变型的单例模式进行实现。
     */
    @Test
    public void testFlyweight(){

        /**
         * 单机游戏无论你开多少盘，棋子和棋盘的数量是固定的。
         * 这样很适合享元模式
         */
        ChinessChess chinessChess = new ChinessChess();
        Chesspiece che = chinessChess.getChesspiece("车","红方");
        Chesspiece ma = chinessChess.getChesspiece("马","红方");
        Chesspiece xiang = chinessChess.getChesspiece("相","红方");
        Chesspiece shi = chinessChess.getChesspiece("士","红方");
        Chesspiece jiang = chinessChess.getChesspiece("将","红方");
        Chesspiece pao = chinessChess.getChesspiece("炮","红方");
        Chesspiece bing = chinessChess.getChesspiece("兵","红方");
        Chesspiece bing2 = chinessChess.getChesspiece("兵","红方");
        Chessboard chessboard = chinessChess.getChessboard(18,18);
        chinessChess.show();
        assert bing == bing2;

    }
}
