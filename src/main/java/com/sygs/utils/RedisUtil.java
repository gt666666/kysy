package com.sygs.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object obj) {
        this.redisTemplate.opsForValue().set(key, obj);
    }

    public String get(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    public String getName(HttpServletRequest request) {
        String token = request.getParameter("jsession");
        Map<Object, Object> info = this.redisTemplate.opsForHash().entries(token);
        return info.get("member").toString().split(",")[3].substring(6);
    }
    public Object getHash(String jsession) {
        return  this.redisTemplate.opsForHash().entries(jsession);
    }


}
