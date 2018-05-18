/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.xiaoxin.config;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 下午1:54
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
public class MybatisTransactionTimeoutInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Statement stmt = (Statement) invocation.getArgs()[0];
        Collection<Object> values = TransactionSynchronizationManager.getResourceMap().values();
        if (!values.isEmpty()) {
            for (Object obj : values) {
                if (obj != null && obj instanceof ConnectionHolder) {
                    ConnectionHolder holder = (ConnectionHolder) obj;
                    if (holder.hasTimeout()) {
                        int queryTimeOut = holder.getTimeToLiveInSeconds();
                        if (stmt.getQueryTimeout() != 0) {
                            queryTimeOut = queryTimeOut < stmt.getQueryTimeout() ? queryTimeOut : stmt.getQueryTimeout();
                        }
                        stmt.setQueryTimeout(queryTimeOut);
                    }
                    break;
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        // Do nothing
    }
}
