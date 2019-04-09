package basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockTest
 * @Description null
 * @Created by yhl
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    private void method(Thread thread) throws InterruptedException {
//        lock.lock();
//        try{
//            System.out.println("thread name  "+thread.getName()+"  get lock");
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("thread name  "+thread.getName()+"  pop lock");
//            lock.unlock();
//        }
        if(lock.tryLock(1, TimeUnit.MICROSECONDS)){
            try {
                System.out.println("thread name  " + thread.getName() + "  get lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("thread name  " + thread.getName() + "  pop lock");
                lock.unlock();
            }
        }else {
            System.out.println("thread name  "+ thread.getName()+"   other get lock");
        }
    }

    public static void main(String arg[]){
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockTest.method(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockTest.method(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
