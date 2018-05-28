package com.xiaoxin.guava.util.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.xiaoxin.guava.util.compare.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 不可变集合
 *  more memory-efficient than their mutable siblings
 * @Auther zhangyongxin
 * @date 2018/5/28 下午5:30
 */
@Slf4j
public class ImmutableCollectionsTest {



    @Test
    public void immutableSetTest() {
        ImmutableSet<String> colorsSet = ImmutableSet.of("orange","red", "orange", "yellow", "green","green", "blue", "purple");
//        colorsSet.add("tets");//unSupport
        log.info(colorsSet.asList().get(2));// 可以转换成list按照index获取
    }

    @Test
    public void immutableMapTest(){
        ImmutableMap<String,String> strMap = ImmutableMap.of("1","zhangsan","2","lisi");
        strMap.get("2");
//        strMap.put("3","wanger");//unSupport
    }

    @Test
    public void immutableListTest(){
        Person zhangsan = new Person("1", "zhangsan", 20);
        Person lisi = new Person("2", "lisi", 20);
        Person alibaba = new Person("3", "alibaba", 40);
        Person wanger = new Person("4", "wanger", 22);
        ImmutableList<Person> list = ImmutableList.of(zhangsan,lisi,alibaba,wanger);
        ImmutableList<Person> list2 = ImmutableList.sortedCopyOf(list).reverse();
        for (Person person :list) {
            log.info("list {}",person);
        }

        for (Person person :list2) {
            log.info("list2 {}",person);// person 按照姓名、年龄、id排序
        }
    }






}
