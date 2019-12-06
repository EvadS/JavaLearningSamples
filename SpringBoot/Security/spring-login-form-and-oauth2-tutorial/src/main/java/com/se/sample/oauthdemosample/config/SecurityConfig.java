package com.se.sample.oauthdemosample.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Шифровать пароли с помощью BCryptPasswordEncoder:

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthProvider authProvider;

    //Осуществлять вход по специально написанному провайдеру аутентификации:

    @Bean
    PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    //Разрешать доступ анонимным пользователям к главной странице, страницам регистрации и входа.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/", "/login**", "/registration").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/notes").failureUrl("/login?error").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }
}

