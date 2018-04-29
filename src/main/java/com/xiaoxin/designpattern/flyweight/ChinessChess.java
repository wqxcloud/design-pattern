package com.xiaoxin.designpattern.flyweight;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 中国象棋
 * @Auther zhangyongxin
 * @date 2018/4/29 下午4:39
 */
@Slf4j
public class ChinessChess {

    private Map<String,Chesspiece> chesspieces = new HashMap<>();

    private Chessboard chessboard;

    public synchronized Chessboard getChessboard(int length,int width) {
        if(chessboard == null){
           chessboard = new Chessboard(16,16);
        }
        return chessboard;
    }

    /**
     * 象棋 车马相士炮各两个，兵各五个，将一个。
     * 将生成一盘棋的模式简化。认为车马相士炮将各一个，实际肯定不是如此。
     * @param name
     * @param belongsTo
     * @return
     */
    public synchronized Chesspiece getChesspiece(String name,String belongsTo){
        if (chesspieces.get(name)==null) {
            chesspieces.put(name,new Chesspiece(name,belongsTo));
        }
        return chesspieces.get(name);
    }

    public void show(){
        log.info(chessboard.toString());
        log.info(chesspieces.toString());
    }

}
