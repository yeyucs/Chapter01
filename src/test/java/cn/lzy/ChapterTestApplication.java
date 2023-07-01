package cn.lzy;

import cn.lzy.configbean.Person;
import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.controller.ChapterController;
import cn.lzy.customconfig.CustomProperties;
import cn.lzy.customconfig.MyProperties;
import cn.lzy.mybatiscatalog.Comment;
import cn.lzy.mybatiscatalog.CommentMapper;
import cn.lzy.profielconfig.DBConnector;
import cn.lzy.profielconfig.TestDBConnector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTestApplication {
    private String TAG = "ChapterTestApplication";
    @Autowired
    ChapterController chapterController;

    @Autowired
    Student student;

    @Autowired
    User user;

    @Autowired
    Person person;

    @Autowired
    CustomProperties customProperties;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DBConnector dbConnector;

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void contextLoads(){
        System.out.println("单元测试返回==="+chapterController.sayHello());
        System.out.println("单元测试返回的student数据===="+student);
        System.out.println("单元测试返回的数据---"+user);
        System.out.println("单元测试返回的Person数据---"+person);
        System.out.println("单元测试返回---"+customProperties);

        MyProperties myProperties = (MyProperties) applicationContext.getBean("myProperties");
        if (myProperties != null){
            myProperties.getResult();
        }
        System.out.println(dbConnector.config());

        Comment comment = commentMapper.findById(5);
        System.out.println("单元测试返回的Comment表的数据-----"+comment);

        Comment comment1 = new Comment();
        comment1.setContent("小蓝");
        comment1.setAuthor("钢琴");
        comment1.setaId(2);
        commentMapper.insertComment(comment1);
        System.out.println("插入成功----"+comment1);

        Comment comment2 = new Comment();
        comment2.setId(1);
        comment2.setContent("小刚");
        commentMapper.updateComment(comment2);
        System.out.println("更新成功----"+comment2);


        commentMapper.deleteComment(6);
        System.out.println("删除成功");

        Comment comment3 = commentMapper.findByauthor("张三");
        System.out.println("单元测试返回的Comment表的数据-----"+comment3);

        Comment comment5 = new Comment();
        comment5.setAuthor("钢琴");
        comment5.setContent("小刚");
        commentMapper.updateComment(comment5);
        System.out.println("更新成功----"+comment5);
    }
}
