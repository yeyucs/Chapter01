package cn.lzy.Security.CSRF;

import cn.lzy.Security.Redis.Customer;
import cn.lzy.Security.Redis.CustomerRepository;
import cn.lzy.mybatiscatalog.jpa.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author:韦盛彪
 * @creat: 2023-10-15  20:31
 */
@Controller
public class CSRFController {

    @Autowired
    private CustomerRepository customerRepository;
    //向用户修改页跳转
    @GetMapping("/toUser")
    public String toUser() {
        return "csrf/CSRTest";
    }
    //用户修改提交处理
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam String username, @RequestParam String password,
                             HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        String csrf_token = request.getParameter("_csrf");
        System.out.println(csrf_token);

        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userDetails:"+context);
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username"+principal.getUsername());

        Integer Date = customerRepository.findIdByusername(principal.getUsername());
        System.out.println("获取到的用户名:"+principal.getUsername()+"的id为:"+Date);
        Integer user = customerRepository.userDiscuss(username, Date);
        if (user == null) {
             return  "修改失败";
        }
        return "ok";
    }

}
