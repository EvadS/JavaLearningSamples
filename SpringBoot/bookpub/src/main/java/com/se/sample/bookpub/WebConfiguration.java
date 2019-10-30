package com.se.sample.bookpub;


import com.se.sample.bookpub.formatters.BookFormatter;
import com.se.sample.bookpub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new BookFormatter(bookRepository));
    }
}
