package cn.lzy.mybatiscatalog.redis;

import cn.lzy.configbean.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,String> {
    List<Persona> findByLastname(String lastname);
    Page<Persona> findPersonByLastname(String lastname, Pageable page);
    List<Persona> findByFirstnameAndLastname(String firstname, String lastname);
    List<Persona> findByAddress_City(String city);
    List<Persona> findByFamilyList_Username(String username);
}
