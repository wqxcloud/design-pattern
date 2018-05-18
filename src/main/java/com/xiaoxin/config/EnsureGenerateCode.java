package com.xiaoxin.config;

import java.util.Scanner;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 下午8:29
 */
public class EnsureGenerateCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入Y/N来继续生成代码...");
        String inputStr = scanner.nextLine();
        switch (inputStr){
            case "Y":
                break;
            case "N":
                System.out.println("您取消了代码的生成。");
                break;
            default:
                break;
        }
    }

}
