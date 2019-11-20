package com.snail.booklist.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Scanner;

/**
 * @author liwenbo
 * @Date 2019/11/20 9:28
 * @Description
 */
public class Producer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        producer.setNamesrvAddr("10.10.65.18:9876");
        producer.setInstanceName("rmq-instance1");
        producer.start();
        try {
            Message message = new Message("demo-topic", "demo-tag", "这是一条测试消息".getBytes());
            producer.send(message);

            while (true) {
                Thread.sleep(3000);
                String text = String.valueOf(System.currentTimeMillis());
                Message msg = new Message("demo-topic",// topic
                        "demo-tag1",// tag
                        text.getBytes() // body
                );
                SendResult sendResult = producer.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
