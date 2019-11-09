package com.dream.demo.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TestJob {

    @Scheduled(cron = "0 56 20 * * ?")
    public void runfirst(){
        System.out.println("1");
    }
    @Scheduled(cron = "0 55 20 * * ?")
    public void runfirst1(){
        System.out.println("1");
    }
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void runfirst3(){
//        System.out.println("3");
//    }
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void runfirst5(){
//        System.out.println("5");
//    }
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void runfirst6(){
//        System.out.println("6");
//    }


}
