package test;

import com.google.common.util.concurrent.RateLimiter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Test {
    RateLimiter rateLimiter = RateLimiter.create(100);
    public void hello(int i, Test2 test2){

            //rateLimiter.acquire();

            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                //new Thread(()-> {test2.hello(finalI);}).start();
                test2.hello(finalI);
            }).run();



    }

}
