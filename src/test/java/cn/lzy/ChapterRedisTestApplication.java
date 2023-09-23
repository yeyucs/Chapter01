package cn.lzy;

import cn.lzy.configbean.Persona;
import cn.lzy.mybatiscatalog.redis.Address;
import cn.lzy.mybatiscatalog.redis.Family;
import cn.lzy.mybatiscatalog.redis.Person;
import cn.lzy.mybatiscatalog.redis.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterRedisTestApplication {
    @Autowired
    private PersonRepository repository;
    @Test
    public void savePerson(){
        cn.lzy.mybatiscatalog.redis.Person person=new Person();
        person.setFirstname("张");
        person.setLastname("龙");

        Address address=new Address();
        address.setCity("x");
        address.setCountry("y");
        person.setAddress(address);

        List<Family> list=new ArrayList<>();
        Family dad=new Family("父亲","李你");
        Family mad=new Family("母亲","刘你");
        list.add(dad);
        list.add(mad);
        person.setFamilyList(list);
        Person personResult= repository.save(person);
        System.out.println(personResult);
    }
}
