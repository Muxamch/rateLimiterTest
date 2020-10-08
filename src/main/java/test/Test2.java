package test;




import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Test2 {
    RateLimiter rateLimiter = RateLimiter.create(5);
    Stopwatch timer = null ;
    public synchronized void hello(int i){
        rateLimiter.acquire();

        if(i == 0){
            timer = Stopwatch.createStarted();
        }
        if(i % 10 == 0) {
            System.out.println("Method took: " + timer.elapsed(TimeUnit.MILLISECONDS));
            //System.exit(1);
        }
        System.out.println("Hello" + i);
        try {
            Thread.sleep(50);
        } catch (Exception e){

        }
    } //66784 68458
}
