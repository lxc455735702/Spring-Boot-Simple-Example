package com.example.simple_lxc.pool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义线程池配置
 * @Author: lxc 672063
 * @CreateTime: 2021-12-08 11:32
 * @Email: 18867762063@163.com
 */
@Data
@ConfigurationProperties("custom-executor-config")
@Component
public class ThreadPoolProperties {
    // 核心线程数
    private Integer corePoolSize;
    // 最大线程数
    private Integer maxPoolSize;
    // 队列容量
    private Integer queueCapacity;
    // 线程活跃时间
    private Integer keepAliveSeconds;
    // 线程名字前缀
    private String threadNamePrefix;

}
