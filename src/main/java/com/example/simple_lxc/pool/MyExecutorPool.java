package com.example.simple_lxc.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: 线程池 初始化配置
 * @Author: lxc 672063
 * @CreateTime: 2021-12-08 11:39
 * @Email: 18867762063@163.com
 */
@EnableAsync // 开启注解
@Configuration
public class MyExecutorPool {

    @Autowired
    private ThreadPoolProperties threadPoolProperties;

    @Bean(name = "LxcAsync")
    public ThreadPoolTaskExecutor myTaskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());//表示线程池核心线程，正常情况下开启的线程数量。
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());//当核心线程都在跑任务，还有多余的任务会存到此处。
        executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());//如果queueCapacity存满了，还有任务就会启动更多的线程，直到线程数达到maxPoolSize。如果还有任务，则根据拒绝策略进行处理。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//该策略是又调用任务的线程执行。
        executor.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());//非核心线程的超时时长，超长后会被回收。
        executor.setThreadNamePrefix(threadPoolProperties.getThreadNamePrefix());
        executor.initialize();//初始化线程池。
        return executor;
    }
}
