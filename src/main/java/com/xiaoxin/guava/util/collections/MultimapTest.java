package com.xiaoxin.guava.util.collections;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/5/29 上午10:54
 */
public class MultimapTest {

    @Test
    public void multiMapTest() {
        // creates a ListMultimap with tree keys and array list values
        ListMultimap<String, Integer> treeListMultimap = MultimapBuilder.treeKeys().arrayListValues().build();
        treeListMultimap.put("a", 1);
        treeListMultimap.put("a", 2);
        treeListMultimap.put("a", 3);
        treeListMultimap.put("b", 5);
        treeListMultimap.put("b", 6);
        treeListMultimap.asMap().get("a").forEach(new ObjectConsumer());
        treeListMultimap.asMap().get("b").forEach(new ObjectConsumer());


    }
}
