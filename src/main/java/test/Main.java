package test;



import com.google.common.util.concurrent.RateLimiter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;


public class Main {
        public static void main(String[] args) {
            RateLimiter rateLimiter = RateLimiter.create(10);
//            ArrayList<String> list = new ArrayList<>();
//            for (int i = 0; i < 100000; i++) {
//                list.add("Hello");
//            }
            Test test = new Test();
            final Test2 test2 = new Test2();

            for (int i = 0; i < 100000; i++) {
                try{
                    Thread.sleep(10);
                } catch (Exception e) {

                }
                //final String string = list.get(i) + " " +i;
                int finalI = i;
                new Thread(()->{


                    new Thread(()->{
                        //rateLimiter.acquire();
                        test.hello(finalI, test2);}).start();

                    //System.out.println("Hello "+ string);
                }).run();

            }
//            while(true) {
//                String ip = "8.8.8.8";
//                String pingResult = "";
//                String pingCmd = "wmic cpu get loadpercentage";
//                try {
//                    Runtime r = Runtime.getRuntime();
//                    Process p = r.exec(pingCmd);
//
//                    BufferedReader in = new BufferedReader(new
//                            InputStreamReader(p.getInputStream(), "Cp866"));
//                    String inputLine;
//                    while ((inputLine = in.readLine()) != null) {
//                        System.out.println(inputLine);
//                        pingResult += inputLine;
//                    }
//                    in.close();
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//
//            }
        }



        }



