package com.se.sample.demoflywayenv.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Component
public class DataSourceConfigCloud {

    private static final Logger logger =
            LoggerFactory.getLogger(DataSourceConfigCloud.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Bean
    @Profile("dev")
    DataSource dataSourceDevProfile(org.springframework.core.env.Environment environment) throws Exception {
        logger.info("------------------dev profile ");
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost/msweater")
                .driverClassName("org.postgresql.Driver")
                .password("123456")
                .username("postgres")
                .build();
    }

    @Bean
    @Profile("heroku")
    public DataSource dataSource() throws SQLException {

        logger.info("------------------heroku  profile ");
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }
    }

//    @Bean()
//    @Profile("heroku")
//    protected DataSource dataSource(
//            @Value("${spring.datasource.driverClassName}") final String driverClass,
//            @Value("${spring.datasource.url}") final String jdbcUrl,
//            @Value("${spring.datasource.username}") final String username,
//            @Value("${spring.datasource.password}") final String password
//    ) throws URISyntaxException {
//
//
//        return DataSourceBuilder
//                .create()
//                .username(username)
//                .password(password)
//                .url(dbUrl)
//                .driverClassName(driverClass)
//                .build();
//    }
}