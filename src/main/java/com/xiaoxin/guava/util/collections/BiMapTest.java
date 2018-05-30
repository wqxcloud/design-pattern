package com.xiaoxin.guava.util.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @Auther zhangyongxin
 * @date 2018/5/29 下午4:58
 */
@Slf4j
public class BiMapTest {
    /**
     * 传统方式如果想将value映射为key需要维护两个Map
     */
    @Test
    public void testTraditionalMap(){
        Map<String, Integer> nameToId = Maps.newHashMap();
        Map<Integer, String> idToName = Maps.newHashMap();

        nameToId.put("Bob", 42);
        idToName.put(42, "Bob");
    }

    /**
     * 使用biMap则轻松应对
     */
    @Test
    public void testBiMap(){
        BiMap biMap = HashBiMap.create(2);
        biMap.put("a","liudehua");
        biMap.put("b","zhaobenshan");

        log.info("get key :{}",biMap.inverse().get("liudehua"));
        log.info("get value :{}",biMap.get("a"));
    }


}
