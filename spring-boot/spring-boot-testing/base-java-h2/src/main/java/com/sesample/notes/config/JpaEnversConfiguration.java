package com.sesample.notes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Evgeniy Skiba on 13.11.2020
 * @project base-java-h2
 */

@Configuration
@EnableJpaAuditing
//@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)

public class JpaEnversConfiguration {
}
