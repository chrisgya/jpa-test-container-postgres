package com.chrisgya.jpatestcontainerpostgres.dao;


import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

/*
NB:
use this only when u do not want to use the default as specified in the "application.yml" under
test resources directory
 */

@Slf4j
public class CustomPostgresContainer extends PostgreSQLContainer<CustomPostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:alpine";
    private static CustomPostgresContainer container;

    private CustomPostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static CustomPostgresContainer getInstance() {
        if (container == null) {
            container = new CustomPostgresContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        log.debug("POSTGRES INFO");
        log.debug("DB_URL: " + container.getJdbcUrl());
        log.debug("DB_USERNAME: " + container.getUsername());
        log.debug("DB_PASSWORD: " + container.getPassword());
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());


    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}