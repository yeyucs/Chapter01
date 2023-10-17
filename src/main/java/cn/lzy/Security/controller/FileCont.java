package cn.lzy.Security.controller;

import cn.lzy.Security.Redis.RedisSecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author:韦盛彪
 * @creat: 2023-10-09  10:51
 */
@Controller
public class FileCont {
    //影片详情页
    private String TAG = "访问记录";
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type")String type,
                           @PathVariable("path")String path) {
        String value = "detail/"+type+"/"+path;
        System.out.println(TAG+"===toDetail==="+value);
        return value;
    }



    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login";
    }


    @PostMapping(value = "/userLogin")
    public String updateUser(@RequestParam String username, @RequestParam String password,
                             HttpServletRequest request) {
        String user = "userLogin"+username+password;
        String csrf_token = request.getParameter("_csrf");
        System.out.println(csrf_token);
        System.out.println(user);
        return user;
    }
    @GetMapping("//getuserByContext1")
    @ResponseBody
    public void getUser(HttpSession session) {
        //从当前HttpSession获取绑定到此会话的所有对象的名称
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            //获取HttpSession中会话名称
            String element = names.nextElement();
            //获取HttpSession中的应用上下文
            SecurityContextImpl attribute =
                    (SecurityContextImpl) session.getAttribute(element);
            System.out.println("element:"+element);
            System.out.println("attribute:"+attribute);
            //获取用户相关信息
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username:"+principal.getUsername());
        }
    }

    @GetMapping("/getuserByContext")
    @ResponseBody
    public void getUser2(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userDetails:"+context);
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username"+principal.getUsername());

    }
}
