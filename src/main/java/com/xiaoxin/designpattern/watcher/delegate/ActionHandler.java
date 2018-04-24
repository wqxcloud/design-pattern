package com.xiaoxin.designpattern.watcher.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/4/24 下午3:16
 */
public class ActionHandler {
    //是用一个List
    private List<Action> objects;

    public ActionHandler(){
        objects=new ArrayList<Action>();
    }
    //添加某个对象要执行的事件，及需要的参数
    public void addEvent(Object object,String methodName,Object...args){
        objects.add(new Action(object,methodName,args));
    }
    //通知所有的对象执行指定的事件
    public void notifyX() throws Exception{
        for(Action e : objects){
            e.invoke();
        }
    }
}
