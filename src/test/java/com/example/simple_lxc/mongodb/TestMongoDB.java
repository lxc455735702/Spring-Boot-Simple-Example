package com.example.simple_lxc.mongodb;


import com.example.simple_lxc.mongodb.bean.ConfigItem;
import com.example.simple_lxc.mongodb.bean.Info;
import com.example.simple_lxc.mongodb.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMongoDB {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void findAllUser() {
        List<User> userList = mongoTemplate.findAll(User.class);
        System.out.println("userList = " + userList);
    }

    @Test
    public void createConfig() {
        // List<User> userList = mongoTemplate.findAll(User.class);
        List<ConfigItem> configItems = new ArrayList<>();
        for (int i = 1; i < 300; i++) {
            ConfigItem configItem = new ConfigItem();
            configItem.setName("column" + i);
            configItem.setShowName("列" + i);
            configItem.setType("字符串");
            configItems.add(configItem);
        }
        Collection<ConfigItem> configItemList = mongoTemplate.insertAll(configItems);
        System.out.println("configItemList = " + configItemList);
    }

    @Test
    public void generateBean() {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.setSuperclass(Info.class);
        List<ConfigItem> configItems = mongoTemplate.findAll(ConfigItem.class);
        log.info("configItemList ->{}",configItems);
        configItems.stream().forEach(configItem -> {
            beanGenerator.addProperty(configItem.getName(), String.class);
        });
       List<Object> objects = new ArrayList<>();
        for(int i = 1;i<20;i++){
            Object object =  beanGenerator.create();
            BeanMap beanMap = BeanMap.create(object);
            configItems.stream().forEach(configItem -> {
                beanMap.put(configItem.getName(),System.currentTimeMillis()+"");
            });
            objects.add(beanMap);
        }
        mongoTemplate.insertAll(objects);
       log.info("objects ->{}",objects);
    }
}
