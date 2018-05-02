package com.xiaoxin.java.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther zhangyongxin
 * @date 2018/4/30 下午3:12
 */
@Slf4j
public class TestMain {
    @Test
    public void testIntern(){
//        String c =new String("hhhh");
//        String e =new String("syss");
//        String a = "syss";
//        String b = "syss";
//        String g = "hhh";
//        String d =c.intern();
//        String f = a.intern();
//        log.info("a==b:"+(a==b));
//        log.info("a==e:"+(a==e));
//        log.info("c==d:"+(c==d));
//        log.info("g==d:"+(g==d));
//        log.info("a==f:"+(a==f));
//        log.info("c==g:"+(c==g));

//        String str1 = new StringBuffer("计算机").append("软件").toString();
//        log.info("str1.intern() == str1::"+(str1.intern() == str1));
//
//        String str3 = new String("计算机软件");
//        log.info("str3.intern() == str3::"+(str3.intern() == str3));
//        log.info("str1.intern() == str3.intern()::"+(str1.intern() == str3.intern()));
//
//        String str4= "计算机软件";
//        log.info("str3.intern() == str4::"+(str3.intern() == str4));
//
//        String str2 = new StringBuffer("java").append("va").toString();
//        log.info("str2.intern() == str2::"+(str2.intern() == str2));

        Integer integer1 = new Integer(10);
        Integer integer2 = 10;
        Integer integer3 = new Integer(10);
//        assert integer1 == integer2;
//        assert integer3 == integer2;
        assert integer3 == integer1;
    }

}
