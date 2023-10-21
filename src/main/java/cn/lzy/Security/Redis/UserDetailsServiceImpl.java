/*
package cn.lzy.Security.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

*/
/**
 * @author:韦盛彪
 * @creat: 2023-10-10  13:16
 *//*

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerServices.getCustomer(username);
        List<Authority> authorities = customerServices.getCustomerAuthority(username);
        //对用户权限进行封装
        List<SimpleGrantedAuthority> list = authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
       */
/* System.out.println("登录的用户名:"+username);
        String password = customer.getPassword();
        String encode = passwordEncoder.encode(password);
        System.out.println("登录的密码:"+password);
        System.out.println("加密"+encode)*//*
;
        //返回封装的UserDetails用户详情类
        if (customer != null){
            UserDetails userDetails = new User(customer.getUsername(),customer.getPassword(),list);
            return userDetails;
        }else {
            //如果查询用户不存在（用户名不存在），必须抛出此异常
            throw new UsernameNotFoundException("当前用户不存在！");
        }




    }
}
*/
