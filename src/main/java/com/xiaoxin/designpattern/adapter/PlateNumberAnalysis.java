package com.xiaoxin.designpattern.adapter;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * 车牌号码解析，假如调用第三方的服务，我方传输车牌图片地址，对方返回车牌号
 * 一个车牌解析厂商返回消息使用GBK，另一个使用UTF-8
 * 那么这个时候就需要使用适配器
 * @Auther zhangyongxin
 * @date 2018/4/27 上午11:41
 */
@Slf4j
public class PlateNumberAnalysis {

    public String analysis(String url){
        String number = "苏A12345";
        // 默认使用utf-8
        log.info("车牌解析对方传来："+number);
        return number;
    }

}
