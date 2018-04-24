package com.xiaoxin.designpattern.watcher.delegate;

public abstract class Notifier {
    private ActionHandler ActionHandler = new ActionHandler();

    public ActionHandler getActionHandler() {
        return ActionHandler;
    }

    public void setActionHandler(ActionHandler ActionHandler) {
        this.ActionHandler = ActionHandler;
    }

    /**
     * 增加需要帮忙 放哨 的 学生
     * 
     * @param object 要执行方法的对象
     * @param methodName 执行方法 的方法名
     * @param args   执行方法的参数
     */
    public abstract void addListener(Object object, String methodName,
            Object... args);

    /**
     * 告诉所有要帮忙放哨的学生：老师来了
     */
    public abstract void notifyX();
}