package cn.lzy.configbean;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "user")
@Validated

public class User {
    @URL
    String url;
    public void  setUrl(String url){
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "url='" + url + '\'' +
                '}';
    }
}