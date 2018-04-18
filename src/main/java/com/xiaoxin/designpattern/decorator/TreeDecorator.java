package com.xiaoxin.designpattern.decorator;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 上午11:53
 */
public abstract class TreeDecorator extends Tree{
    private Tree tree;

    public void decorator(Tree tree){
       this.tree = tree;
    }

    @Override
    public void makeWish() {
        if(null != tree){
            tree.makeWish();
        }
    }
}
