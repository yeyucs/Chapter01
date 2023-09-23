package cn.lzy;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import cn.lzy.mybatiscatalog.jpa.DiscussReppository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterJPATestApplication {
    @Autowired
    private DiscussRepository reppository;

    @Test
    public void selectComment() {
        Optional<Discuss> optional = reppository.findById(9);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println();
    }

    @Test
    public void selectCommentByKeys() {
        List<Discuss> list = reppository.findByAuthorNotNull();
        System.out.println(list);
    }


    @Test
    public void selectCommentExample() {
        Discuss discuss = new Discuss();
        discuss.setAuthor("导师");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = reppository.findAll(example);
        System.out.println(list);
    }

    @Test
    public void selectCommentByeXAMPLEm() {
        Discuss discuss = new Discuss();
        discuss.setAuthor("");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author", startsWith());
        Example<Discuss> example = Example.of(discuss, matcher);
        List<Discuss> list = reppository.findAll(example);
        System.out.println(list);
    }

    @Test
    public void deleteComment() {
         reppository.deleteById(1);
    }
}