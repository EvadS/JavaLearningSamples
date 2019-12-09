package com.se.sample.oauthdemosample.config;


import com.se.sample.oauthdemosample.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Шифровать пароли с помощью BCryptPasswordEncoder:

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private UserSevice userSevice;



    //Разрешать доступ анонимным пользователям к главной странице, страницам регистрации и входа.

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/resources/**", "/", "/login**", "/registration").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login")
//                .defaultSuccessUrl("/notes").failureUrl("/login?error").permitAll()
//                .and().logout().logoutSuccessUrl("/").permitAll();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                .antMatchers("/resources/**", "/", "/login**", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSevice)
                .passwordEncoder(passwordEncoder);
    }
}

