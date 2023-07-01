package cn.lzy.profielconfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("intl")
public class IntlDBConnector implements DBConnector{

    @Override
    public String config() {
        return "这是个生产环境";
    }
}
