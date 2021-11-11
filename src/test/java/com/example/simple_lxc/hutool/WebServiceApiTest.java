package com.example.simple_lxc.hutool;

import cn.hutool.http.webservice.SoapClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @Description: hutool WebService 例子
 * @Author: lxc 672063
 * @CreateTime: 2021-11-10 15:53
 * @Email: 18867762063@163.com
 */
@Slf4j
@SpringBootTest
public class WebServiceApiTest {

    /**
     * webService接口测试
     */
    @Test
    public void webServiceSoap(){
        HashMap<String,Object> params = new HashMap<>();
        SoapClient client =  SoapClient.create("http://xxx/onews.asmx")
                .setMethod("MethodName")
                .setParams(params);
        log.info("测试数据->{}",client.send(true));
    }
}
