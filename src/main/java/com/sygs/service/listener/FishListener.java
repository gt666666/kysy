package com.sygs.service.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * 监听发送的消息
 */
public class FishListener implements MessageListener {



    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("我是Fish监听" + message.toString());
    }
}
