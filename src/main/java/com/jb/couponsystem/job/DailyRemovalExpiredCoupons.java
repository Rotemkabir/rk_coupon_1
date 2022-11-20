package com.jb.couponsystem.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyRemovalExpiredCoupons {

    //@Scheduled(fixedRate = 1000*60*60*24)
    @Scheduled(fixedRate = 1000*5)
    public void expired(){
        System.out.println("daily removal expired");
    }
}
