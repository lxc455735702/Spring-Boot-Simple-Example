package com.example.simple_lxc.pool;

import com.example.simple_lxc.pool.impl.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * @Description: 线程池测试类
 * @Author: lxc 672063
 * @CreateTime: 2021-12-08 11:42
 * @Email: 18867762063@163.com
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyExecutorPoolTest {

    @Autowired
    private ITestService testService;

    /**
     * java.lang.InterruptedException: sleep interrupted
     * 原因是因为单元测试启动的主线程很快就结束了，而子线程确sleep5秒，使得主线程强行打断子线程的sleep,因此抛出异常
     */
    @Test
    public void testPool() {
        testService.TaskOne();
        testService.TaskTwo();
        testService.TaskThree();
        try {
            // 线程一直在阻塞，无法终止。自己等待自己结束
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}







