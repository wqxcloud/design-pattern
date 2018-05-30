package com.xiaoxin.guava.util.collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/5/29 下午5:24
 */
@Slf4j
public class RangeMapTest {

    @Test
    public void rangeMapTest(){
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}
        for (int i = 1; i <=20 ; i++) {
            log.info("get key:{} value:{}",i,rangeMap.get(i));
        }

    }
}
