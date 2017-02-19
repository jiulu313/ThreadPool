package com.zhj.threadpool;

import java.util.LinkedList;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public class DefaultThreadPool implements ThreadPool {
    //最大工作线程个数
    public static final int MAX_WORK_NUM = 10;

    //最小工作线程个数
    public static final int MIN_WORK_NUM = 1;

    //默认工作线程个数
    public static final int DEFAULT_WORK_NUM = 5;

    //工作线程个数
    protected int workNum = DEFAULT_WORK_NUM;

    //线程是否正在运行
    protected boolean running = false;

    //任务列表
    protected LinkedList<Task> taskList = new LinkedList<>();

    //工作线程列表
    protected LinkedList<Worker> workerList = new LinkedList<>();


    @Override
    public void start() {
        if (running) {
            return;
        }

        initWorkers(workNum);
        for (Worker worker : workerList) {
            worker.start();
        }

        running = true;
    }

    @Override
    public void shutdown() {
        for (Worker worker : workerList) {
            worker.shutdown();
        }

        running = false;
    }

    @Override
    public void initWorkers(int num) {
        if (num > MAX_WORK_NUM) {
            workNum = MAX_WORK_NUM;
        } else if (num < MIN_WORK_NUM) {
            workNum = MIN_WORK_NUM;
        } else {
            workNum = num;
        }

        for (int i = 0; i < workNum; i++) {
            Worker worker = new Worker();
            worker.setThread(new Thread(worker));
            worker.setTaskList(taskList);
            workerList.add(worker);
        }
    }

    @Override
    public void execute(Task task) {
        if(taskList != null){
            synchronized (taskList){
                taskList.addLast(task);
                taskList.notifyAll();
            }
        }
    }
}
