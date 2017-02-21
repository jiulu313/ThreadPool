import com.zhj.threadpool.DefaultThreadPool;
import com.zhj.threadpool.PrintTask;
import com.zhj.threadpool.ThreadPool;

import java.util.LinkedList;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool = new DefaultThreadPool();
        pool.initWorkers(3);
        pool.start();

        for (int i = 0; i < 10; i++) {
            pool.execute(new PrintTask("任务 : " + (i + 1)));
        }


    }

}
