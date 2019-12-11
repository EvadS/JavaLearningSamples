package com.se.spring.sample.web.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;



import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractTemplateResolver;

import javax.sql.DataSource;
import java.util.Locale;
/**
 * Webapp configuration
 * Created by Daniil Sanin<sdi@simple-digit.ru> on 27.06.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.se.spring.sample.web.controller", "com.se.spring.sample.web.config"})
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    final private static String WEB_APP = "webapp";
    final private static String ENCODING = "UTF-8";
    final private static String DEFAULT_LOCALE = "ru";

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "templateResolver")
    public AbstractTemplateResolver getTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix(WEB_APP + "/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Bean(name = "templateEngine")
    public SpringTemplateEngine getTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver());
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(getSpringSecurityDialect());
        return templateEngine;
    }

    @Bean(name = "viewResolver")
    public ThymeleafViewResolver getViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(getTemplateEngine());
        viewResolver.setViewNames(new String[]{"*"});
        viewResolver.setCharacterEncoding(ENCODING);
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testDb;MODE=PostgreSQL;INIT=RUNSCRIPT FROM 'classpath:/initSQL.sql'");
        ds.setUser("root");
        ds.setPassword("31323334");
        return ds;
    }

    @Bean
    public SpringSecurityDialect getSpringSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/" + WEB_APP + "/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/" + WEB_APP + "/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/" + WEB_APP + "/img/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/" + WEB_APP + "/favicon.ico");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(WEB_APP + "/nls/common");
        messageSource.setDefaultEncoding(ENCODING);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver resolver = new SessionLocaleResolver  ();
        resolver.setDefaultLocale(new Locale(DEFAULT_LOCALE));
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("locale");
        registry.addInterceptor(interceptor);
    }

}