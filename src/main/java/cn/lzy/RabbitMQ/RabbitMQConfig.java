package cn.lzy.RabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:韦盛彪
 * @creat: 2023-10-18  12:15
 */
@Configuration
public class RabbitMQConfig {
    //自定义消息转换器
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    //1.定义fanout类型的交换器
    @Bean
    public Exchange topic_exchange(){
        return ExchangeBuilder.fanoutExchange("topic_exchange").build();
    }
    //2.定义两个不同名称的消息队列
    @Bean
    public Queue topic_queue_QQ(){
        return new Queue("topic_queue_QQ");
    }

    @Bean
    public Queue topic_queue_VX(){
        return new Queue("topic_queue_VX");
    }

    @Bean
    public Queue topic_queue_Email(){
        return new Queue("topic_queue_Email");
    }
    //绑定
    @Bean
    public Binding bindingQQ(){
        return BindingBuilder.bind(topic_queue_QQ()).to(topic_exchange()).with("").noargs();
    }

    @Bean
    public Binding bindingVX(){
        return BindingBuilder.bind(topic_queue_VX()).to(topic_exchange()).with("").noargs();
    }

    @Bean
    public Binding bindingEmail(){
        return
                BindingBuilder.bind(topic_queue_Email()).to(topic_exchange()).with("").noargs();
    }
}
