package com.xiaoxin.guava.util;

import com.google.common.base.Preconditions;
import com.xiaoxin.guava.util.compare.Person;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/5/28 下午5:08
 */
public class PreconditionsExplainedTest {

    @Test
    public void preconditionsTest(){
        Person p = new Person();
        p.setName("张三");

        Preconditions.checkArgument(!"张三".equals(p.getName()));//java.lang.IllegalArgumentException
        Preconditions.checkNotNull(p.getId());//java.lang.NullPointerException
    }
}
