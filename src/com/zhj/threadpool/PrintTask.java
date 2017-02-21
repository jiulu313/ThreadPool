package com.zhj.threadpool;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public class PrintTask implements Task{
    String name = "";

    public PrintTask(String name){
        this.name = name;
    }

    @Override
    public void excute() {
        System.out.println(Thread.currentThread().getName() + " 打印了: "+name);
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
