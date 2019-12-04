package com.se.sample.demo.daotesting;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.se.sample.demo.dao.NotificationRepository;
import com.se.sample.demo.domain.Notification;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static net.bytebuddy.matcher.ElementMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = { NotificationRepositoryTest.Initializer.class })

public class NotificationRepositoryTest {
    @Autowired
    private NotificationRepository repository;

    /**
     * This configuration now loads up a Postgres container in Docker at the start of the test.
     * This can be configured per test if required.
     */
    //step 2
    @ClassRule
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest");

    /**
     * This code allows us to get a handle on the container configuration and override the spring boot properties,
     * in doing so that test will now apply the flyway script to our containerised database and the jpa code is connected.
     */
    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }

    }

    @Test
    public void shouldStoreEachNotification() {

        // given
        repository.save(new Notification("message1", "test"));
        repository.save(new Notification("message2", "test"));

        // when
        long count = repository.count();

        // then
        Assert.assertEquals(count, 2);
    }

    @Test
    public void shouldStoreEachNotificationWithAUniqueIdentifier() {

        // given
        Notification n1 = repository.save(new Notification("message3", "test"));
        Notification n2 = repository.save(new Notification("message4", "test"));

        // when
        Notification persistedNotification1 = repository.getOne(n1.getId());
        Notification persistedNotification2 = repository.getOne(n2.getId());

        // then
        assertThat(persistedNotification1, equalTo(n1));
        assertThat(persistedNotification2, equalTo(n2));

    }



    @Test
    public void should_correct_init(){

    }

}