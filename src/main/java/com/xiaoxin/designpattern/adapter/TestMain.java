package com.xiaoxin.designpattern.adapter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 上午11:54
 */
public class TestMain {

    /**
     * 总结：适配模式，将一个类的接口转换为客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
     * 例如本例中，原本车牌解析需要调用默认的utf-8解码的厂商提供的接口，但是现在要转用GBK解码的厂商提供的接口。原本的UTF-8也要随时能用。
     * 这样需要适配模式，客户端调用则像调用原本的接口一样。
     */
    @Test
    public void testAnaysis() {
        PlateNumberAnalysis analysis = new PlateNumberAnalysisAdapter();
        analysis.analysis("这是车牌号的网络图片地址");
    }
}
