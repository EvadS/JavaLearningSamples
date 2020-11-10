package com.se.app.config;


import com.se.app.dao.UserDao;
import com.se.app.dao.UserDaoImpl;
import com.se.app.services.UserServiceImpl;
import com.se.app.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.se.app.services")
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        ((DriverManagerDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/vebinar");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getJdbcTemplate());
    }

    //@Bean
    //public UserServices getUserService() {
    //    return new UserServiceImpl();
    //}
}