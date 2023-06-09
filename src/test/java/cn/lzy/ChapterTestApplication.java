package cn.lzy;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTestApplication {

    @Autowired
    ChapterController chapterController;
    @Test
    public void grtHello(){
        String result = chapterController.sayHello();
        System.out.println("单元测试返回==="+result);
    }
}
