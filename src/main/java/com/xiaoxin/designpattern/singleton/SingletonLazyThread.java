package com.xiaoxin.designpattern.singleton;

public class SingletonLazyThread extends Thread{

    private static String type;
      
    @Override  
    public void run() {   
        if("unsafe".equals(type)){
            System.out.println(SingletonLazyDemo.getInstance().hashCode());
        }else if("safe".equals(type)){
            System.out.println(SingletonLazySafeDemo.newInstance().hashCode());
        }else{
            System.out.println(SingletonHungerDemo.newInstance().hashCode());

        }
    }  
      
    public static void testLazy() {
        type = "unsafe";
        SingletonLazyThread[] mts = new SingletonLazyThread[100];
        for(int i = 0 ; i < mts.length ; i++){  
            mts[i] = new SingletonLazyThread();
        }  
          
        for (int j = 0; j < mts.length; j++) {  
            mts[j].start();  
        }  
    }
    public static void testLazySafe() {
        type = "safe";
        SingletonLazyThread[] mts = new SingletonLazyThread[100];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new SingletonLazyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
    public static void testHunger() {
        type = "hunger";
        SingletonLazyThread[] mts = new SingletonLazyThread[100];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new SingletonLazyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}  