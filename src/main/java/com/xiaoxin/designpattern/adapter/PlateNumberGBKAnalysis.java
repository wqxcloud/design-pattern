package com.xiaoxin.designpattern.adapter;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 上午11:50
 */
@Slf4j
public class PlateNumberGBKAnalysis {

   public String anaysisWithGBK(String url){
       String number = "%CB%D5A12345";// 假设这个厂商返回的是GBK格式的内容
       try {
           number= URLDecoder.decode(number,"GBK");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       log.info("解析出车牌为："+number);
           return number;
   }
}
