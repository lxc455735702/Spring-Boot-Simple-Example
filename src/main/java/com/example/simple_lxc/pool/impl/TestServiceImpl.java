package com.example.simple_lxc.pool.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Description:
 * @Author: lxc 672063
 * @CreateTime: 2021-12-08 11:50
 * @Email: 18867762063@163.com
 */
@Slf4j
@Service
public class TestServiceImpl implements ITestService{

    public static Random random = new Random();

    @Async("LxcAsync")
    @Override
    public void TaskOne()  {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("LxcAsync")
    @Override
    public void TaskTwo()  {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("LxcAsync")
    @Override
    public void TaskThree()  {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
