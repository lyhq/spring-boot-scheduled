package com.you.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/***
 * PrintTask 打印测试
 *
 * @author: YangRun
 * @date: 2020/2/18
 */
@Component
public class PrintTask {

    /**
     * 每小时的15分执行该方法
     */
    @Scheduled(cron = "0 15 * * * *")
    public void cron() {
        System.out.println("当前线程[ " + Thread.currentThread().getName() + " ] 执行定时任务(cron)...");
        System.out.println("执行测试cron时间：" + new Date(System.currentTimeMillis()));
    }


    /**
     * 是上一个调用开始后再次调用的延时（调用频率，不用等待上一次调用完成）
     * 但是经过验证，是等到上次执行完才进行下一次的执行
     */
    @Scheduled(fixedRate = 5000)
    public void fixedRate() throws Exception {
        System.out.println("当前线程[ " + Thread.currentThread().getName() + " ] 执行定时任务(fixedRate)...");
        System.out.println("执行测试fixedRate时间：" + new Date(System.currentTimeMillis()));
        //Thread.sleep(5000);
    }

    /**
     * 上一个调用完成后再次调用的延时调用
     */
    @Scheduled(fixedDelay = 3000)
    public void fixedDelay() throws Exception {
        System.out.println("当前线程[ " + Thread.currentThread().getName() + " ] 执行定时任务(fixedDelay)...");
        //Thread.sleep(3000);
        System.out.println("执行测试fixedDelay时间：" + new Date(System.currentTimeMillis()));
    }

    /**
     * 第一次被调用前的延时，单位毫秒
     */
    @Scheduled(initialDelay = 1000 * 10, fixedDelay = 1000 * 2)
    public void initialDelay() throws Exception {
        System.out.println("当前线程[ " + Thread.currentThread().getName() + " ] 执行定时任务(initialDelay)...");
        System.out.println("执行测试initialDelay时间：" + new Date(System.currentTimeMillis()));
    }
}
