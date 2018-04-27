package com.xiaoxin.designpattern.adapter;

/**
 * @Auther zhangyongxin
 * @date 2018/4/27 上午11:48
 */
public class PlateNumberAnalysisAdapter extends PlateNumberAnalysis{

    PlateNumberGBKAnalysis analysis;
    @Override
    public String analysis(String url) {
        if(null == analysis){
            analysis = new PlateNumberGBKAnalysis();
        }
        return analysis.anaysisWithGBK(url);
    }
}
