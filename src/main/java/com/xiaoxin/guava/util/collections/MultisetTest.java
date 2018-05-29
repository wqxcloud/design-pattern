package com.xiaoxin.guava.util.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

/**
 * 可以支持多种数据类型的set
 * @Auther zhangyongxin
 * @date 2018/5/28 下午8:10
 */
public class MultisetTest {

    @Test
    public void mutiSetTest(){
        Multiset multiset = HashMultiset.create();
        multiset.add(12);
        multiset.add("12");
        multiset.add(null);
        multiset.forEach(new ObjectConsumer());
    }

    @Test
    public void immutableMultisetTest() {
        ImmutableMultiset immutableMultiset = ImmutableMultiset.of("333", 444, 44.00);//不能包含null值，否则java.lang.NullPointerException
        immutableMultiset.forEach(new ObjectConsumer());
    }


}
