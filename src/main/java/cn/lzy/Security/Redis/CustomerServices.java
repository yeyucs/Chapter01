/*
package cn.lzy.Security.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * @author:韦盛彪
 * @creat: 2023-10-10  11:43
 *//*

@Service
public class CustomerServices {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AuthorityRepository authorityRepository;


    public Customer getCustomer(String username){
        Customer customer = null;
        //去redis数据库里面取数据
        Object objectCustomer = redisTemplate.opsForValue().get("customer_"+username);
        if (objectCustomer !=null){
            customer = (Customer) objectCustomer;
        }else {
            //去mysql数据库里面取数据
            customer = customerRepository.findByUsername(username);
            if (customer!= null){
                redisTemplate.opsForValue().set("customer_"+username,customer);
            }
        }
        return customer;
    }


    public List<Authority> getCustomerAuthority(String username){
        List<Authority> authorities = null;
        Object objectAuthority = redisTemplate.opsForValue().get("authorities_"+username);
        if (objectAuthority !=null){
            authorities = (List<Authority>) objectAuthority;
        }else {
            authorities = authorityRepository.findAuthoritiesByUsername(username);
            if (authorities != null){
                redisTemplate.opsForValue().set("authorities_"+username,authorities);
            }
        }
        return authorities;
    }
}
*/
