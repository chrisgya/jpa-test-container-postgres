package com.chrisgya.jpatestcontainerpostgres.reuseSameDB;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@ContextConfiguration(initializers = DatabaseBaseTest.Initializer.class)
public abstract class DatabaseBaseTest {
    static final PostgreSQLContainer DATABASE = new PostgreSQLContainer();

    static {
        DATABASE.start();
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + DATABASE.getJdbcUrl(),
                    "spring.datasource.username=" + DATABASE.getUsername(),
                    "spring.datasource.password=" + DATABASE.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}