package cn.lzy;

import cn.lzy.mybatiscatalog.domainjpa.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

import java.util.Optional;
@EnableCaching
@ServletComponentScan
@SpringBootApplication
@ImportResource("classpath:xmlproperties.xml")
public class ChapterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }

}
