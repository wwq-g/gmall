package com.gustavo.gmall.manage;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import util.RedisUtil;

@Controller
public class RedissonTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedissonClient redissonClient;


    @RequestMapping("testRedsson")
    public String testRedisson(){

        Jedis jedis = redisUtil.getJedis();

        RLock lock = redissonClient.getLock("lock");

        return null;
    }

}
