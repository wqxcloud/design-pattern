package com.xiaoxin.guava.util;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xiaoxin.guava.util.compare.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/5/28 下午4:44
 */
@Slf4j
public class ObjectCommonMethodsTest {

    /**
     * Objects.equal
     */
    @Test
    public void objectsEquals() {
        log.info("Objects.equal {}", Objects.equal("a", "a")); // returns true
        log.info("Objects.equal {}", Objects.equal(null, "a")); // returns false
        log.info("Objects.equal {}", Objects.equal("a", null)); // returns false
        log.info("Objects.equal {}", Objects.equal(null, null)); // returns true
    }

    /**
     *ComparisonChain
     */
    @Test
    public void compareTo() {

        Person zhangsan = new Person("1", "zhangsan", 20);
        Person lisi = new Person("2", "lisi", 20);
        Person alibaba = new Person("3", "alibaba", 40);
        Person wanger = new Person("4", "wanger", 22);

        List<Person> persons = Lists.newArrayList(zhangsan, lisi, alibaba,wanger);
        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person);
        }
    }



}
