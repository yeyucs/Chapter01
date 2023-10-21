/*
package cn.lzy.Security.Redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

*/
/**
 * @author:韦盛彪
 * @creat: 2023-10-09  17:52
 *//*

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);

    Customer findByPassword(String password);

    @Transactional
    @Query("SELECT c.id from t_customer c where c.username = ?1")
    Integer  findIdByusername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE t_customer c SET c.username = ?1 WHERE c.id = ?2")
    int userDiscuss(String username,Integer id);



}
*/
