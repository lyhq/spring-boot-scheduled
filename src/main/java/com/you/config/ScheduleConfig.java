package com.you.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Create By YangRun 2020/02/18
 * <p>
 * 自定义线程池执行定时任务
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        /**
         * 推荐使用这种方式创建线程池执行器
         */
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5,
                new BasicThreadFactory.Builder().namingPattern("custom-schedule-pool-%d").daemon(true).build());
        taskRegistrar.setScheduler(executor);
        // 不推荐的方法
        // taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
    }
}