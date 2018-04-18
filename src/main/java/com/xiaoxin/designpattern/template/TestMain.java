package com.xiaoxin.designpattern.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/4/16 下午7:32
 */
public class TestMain {
    /**
     * 总结：模板模型将功能的分支方法定义为抽象方法，将功能的组装流程定义为父类的共同方法，
     * 这样就只有分支方法的具体实现有差异。但是整个流程是完全一样的。
     * 这里将父类的共通方法定义为final的，就是不希望子类去重写。
     * 缺点：暂时没有想到
     * @param args
     */
    public static void main(String[] args){
        /**
         * 类似开放平台，所有订单处理从这边开始
         */
        Customer phoneCus = new Customer(1,"13952015678");
        Customer emailCus = new Customer(2,"13952015678@163.com");
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setCustomer(phoneCus);
        saleOrder.setOrderId("XSD001");
        saleOrder.setVoucherId("001");
        SaleOrderDetail saleOrderDetail = new SaleOrderDetail();
        saleOrderDetail.setAmount(1);
        saleOrderDetail.setCost(1000d);
        saleOrderDetail.setSkuId("00001");
        List<SaleOrderDetail> saleOrderDetailList = new ArrayList<>();
        saleOrderDetailList.add(saleOrderDetail);
        saleOrder.setDetailList(saleOrderDetailList);


        SaleOrder saleOrder2 = new SaleOrder();
        saleOrder2.setCustomer(emailCus);
        saleOrder2.setOrderId("XSD001");
        saleOrder2.setVoucherId("002");
        SaleOrderDetail saleOrderDetail2 = new SaleOrderDetail();
        saleOrderDetail.setAmount(2);
        saleOrderDetail.setCost(3000d);
        saleOrderDetail.setSkuId("00002");
        List<SaleOrderDetail> saleOrderDetailList2 = new ArrayList<>();
        saleOrderDetailList2.add(saleOrderDetail2);
        saleOrder2.setDetailList(saleOrderDetailList2);
        //手机客户
        List<Customer> customers = new ArrayList<>();
        customers.add(phoneCus);
        customers.add(emailCus);
        for(Customer customer:customers){
            if(customer.getAccountType() == 1){
                MobilePhoneOrderConfirm phoneOrderConfirm = new MobilePhoneOrderConfirm();
                phoneOrderConfirm.confirm(phoneCus.getAccount(),saleOrder);
            }else{
                EmailOrderConfirm emailOrderConfirm = new EmailOrderConfirm();
                emailOrderConfirm.confirm(emailCus.getAccount(),saleOrder2);
            }
        }




    }
}
