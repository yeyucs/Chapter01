package cn.lzy.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author:韦盛彪
 * @creat: 2023-10-18  12:16
 */
@Service
public class RabbitMQService {

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic_queue_QQ"),exchange = @Exchange(value = "topic_ex",type = "topic"),key = "info.#.QQ.#"))
    public void topicConsumerQQ(String message) {
        System.out.println("接收到QQ的消息:"+message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic_queue_VX"),exchange = @Exchange(value = "topic_ex",type = "topic"),key = "info.#.VX.#"))
    public void topicConsumerVX(String message) {
        System.out.println("接收到微信的消息:"+message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic_queue_Email"),exchange = @Exchange(value = "topic_ex",type = "topic"),key = "info.#.Email.#"))
    public void topicConsumerEmail(String message) {
        System.out.println("接收到邮件的消息:"+message);
    }
}
