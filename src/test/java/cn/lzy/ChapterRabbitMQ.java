package cn.lzy;

import cn.lzy.RabbitMQ.RabbitMQConfig;
import cn.lzy.RabbitMQ.WeUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:韦盛彪
 * @creat: 2023-10-18  17:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterRabbitMQ {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void psubPublisher() {
        WeUser weUser = new WeUser();
        weUser.setId(2);
        weUser.setName("小刚");
        rabbitTemplate.convertAndSend("topic_exchange","",weUser);
    }
    @Test
   public void topicPublisherQQ(){
        //只发给QQ
        rabbitTemplate.convertAndSend("topic_ex","info.QQ","topics send QQ massage");
    }

    @Test
    public void topicPublisherVX(){
        //只发给微信
        rabbitTemplate.convertAndSend("topic_ex","info.VX","topics send VX massage");
    }

    @Test
    public void topicPublisherEmail(){
        //只发给邮件
        rabbitTemplate.convertAndSend("topic_ex","info.Email","topics send Email massage");
    }

    @Test
    public void topicPublisher(){
        //同时发送给QQ，微信，邮件
        rabbitTemplate.convertAndSend("topic_ex","info.Email.QQ.VX","topics send Email and QQ and VX massage");
    }

    @Test
    public void topicPublisherQQVX(){
        //只给QQ和微信发
        rabbitTemplate.convertAndSend("topic_ex","info.QQ.VX","topics send QQ and VX massage");
    }
}
