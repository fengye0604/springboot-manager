package com.example.examplesecurity.config;

import com.example.examplesecurity.service.CustomUserDetailsService;
import com.sun.net.httpserver.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    /**
     * 配置用户信息的获取方式
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //手动添加用户名和密码
//        auth.inMemoryAuthentication().withUser("用户名").password("密码").authorities("权限1","权限2","权限3");

//        通过userDetailsService可以动态的从数据库、缓存中获取用户名和密码。
        //登录时的密码加密及校验
        auth.userDetailsService(userDetailsService).passwordEncoder(myPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        http.authorizeRequests().antMatchers("访问路径").hasAnyAuthority("访问权限")
                .antMatchers("/addOrder").hasAnyAuthority("admin")
                .antMatchers("/queryOrder").hasAnyAuthority("user").and();
        */
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();
        expressionInterceptUrlRegistry.antMatchers("222").hasAnyAuthority("");


        http.authorizeRequests().antMatchers().fullyAuthenticated()
                // 如果有允许匿名的url，填在下面
//                .antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
                //security常用的两种验证方式(basic,表单验证)
                //.httpBasic()  //basic的验证方式
                // 设置form表单的登录方式
                .formLogin().loginPage("/login").permitAll()
                // 设置登陆成功页
                //.defaultSuccessUrl("/").permitAll()
                // 自定义登陆用户名和密码参数，默认为username和password
//                .usernameParameter("username")
//                .passwordParameter("password")
                .and()
                .logout().permitAll();

        // 关闭CSRF跨域校验
        http.csrf().disable();
    }


    /**
     * 配置静态资源不用验证
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
