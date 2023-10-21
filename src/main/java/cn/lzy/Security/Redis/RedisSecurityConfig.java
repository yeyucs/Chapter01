/*
package cn.lzy.Security.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

*/
/**
 * @author:韦盛彪
 * @creat: 2023-10-10  00:10
 *//*


@EnableWebSecurity
public class RedisSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //可以关闭Spring Security默认开启的CSRF防护功能
//        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //需要对static文件夹下静态资源进行统一放行
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/common/**").hasAnyRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                .anyRequest().authenticated();
        //自定义用户登录控制
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");
        //自定义用户退出控制
        http.logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/");
        //定制Remember-me记住我功能
        http.rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(20)
                //对Cookie信息进行持久化管理
                .tokenRepository(tokenRepository());
    }
    //持久化Token储存
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl jr=new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
*/
