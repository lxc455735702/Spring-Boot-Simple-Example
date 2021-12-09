package com.example.simple_lxc.support.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Description: 重试服务的实现类
 * @Author: lxc 672063
 * @CreateTime: 2021-12-09 14:43
 * @Email: 18867762063@163.com
 */
@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 1.5))
    @Override
    public void doTask(String params) {
        log.info("执行doTask方法");
        if("retry".equals(params)){
            int test = 1/0;
        }
        log.info("执行doTask方法结束");
    }


    /**
     * 这里要注意 要和重试注解的入参和返回一致才会进入回调
     * @param e
     * @param params
     */
    @Recover
    public void recover(Exception e,String params){
        log.info("重试结束的回调 error-> {} params => {}",e.getMessage(),params);
    }

}
