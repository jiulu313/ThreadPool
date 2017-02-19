import com.zhj.threadpool.DefaultThreadPool;
import com.zhj.threadpool.PrintTask;
import com.zhj.threadpool.Task;
import com.zhj.threadpool.ThreadPool;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool = new DefaultThreadPool();
        pool.start();

        for (int i = 0; i < 10; i++) {
            pool.execute(new PrintTask());
        }

        try {
            Thread.currentThread().sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
