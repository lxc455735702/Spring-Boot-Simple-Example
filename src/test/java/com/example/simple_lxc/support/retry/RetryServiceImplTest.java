package com.example.simple_lxc.support.retry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Description:
 * @Author: lxc 672063
 * @CreateTime: 2021-12-09 14:50
 * @Email: 18867762063@163.com
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class RetryServiceImplTest {

    @Autowired
    RetryService retryService;

    @Test
    void doTask() {
        retryService.doTask("1");
    }

    @Test
    void doRetryTask() {
        retryService.doTask("retry");
    }
}