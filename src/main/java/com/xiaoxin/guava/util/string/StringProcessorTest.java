package com.xiaoxin.guava.util.string;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xiaoxin.guava.util.consumer.BiPrinterConsumer;
import com.xiaoxin.guava.util.consumer.ObjectPrintConsumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Joiner Splitter
 * @Auther zhangyongxin
 * @date 2018/5/30 上午10:53
 */
@Slf4j
public class StringProcessorTest {

    @Test
    public void joinerTest(){
        // list 操作，在数据库操作in时很有用
        Joiner joiner1 = Joiner.on(",");
        List<String> list = Lists.newArrayList("0012","0033");
        String listString = joiner1.join(list);
        log.info("joined list:{}",listString);
        // map 操作,在httpClient get请求时拼接参数时很有用
        Map<String,String> map = Maps.newHashMapWithExpectedSize(2);
        map.put("storeId","0012");
        map.put("customerId","1000988888373");
        Joiner joiner2 = Joiner.on("&");
        String mapString =joiner2.withKeyValueSeparator("=").join(map);
        log.info("joined map:{}",mapString);//storeId=0012&customerId=1000988888373
    }

    @Test
    public void splitterTest(){
        // split 成list
        String testString = "1,,33,445, ss ,kkk";
        // skip null and trim
        Splitter splitter = Splitter.on(",");
        Iterable<String> iterable= splitter.omitEmptyStrings().trimResults().split(testString);
        List stringList = Lists.newArrayList(iterable);
        stringList.forEach(new ObjectPrintConsumer());

        // split 成 map
        String mapString = "storId=0012&customerId=999008";
        Splitter splitter1 = Splitter.on("&");
        Map<String,String> map =splitter1.withKeyValueSeparator("=").split(mapString);
        map.forEach(new BiPrinterConsumer());
    }

    @Test
    public void caseFormat(){
        String camelStr = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "tb_user");
        log.info("formated string:{}",camelStr);
        String underScoreStr = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "tbUser");
        log.info("formated string:{}",underScoreStr);

    }
}
