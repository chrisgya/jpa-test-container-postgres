package com.chrisgya.jpatestcontainerpostgres.reuseSameDB;

import com.chrisgya.jpatestcontainerpostgres.dao.DummyDao;
import com.chrisgya.jpatestcontainerpostgres.entity.Dummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * See https://stackoverflow.com/questions/59024184/spring-boot-with-testcontainers-how-to-prevent-db-initialization-on-context-re
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DummyDaoTest2 extends DatabaseBaseTest{

    @Autowired
    DummyDao dao;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(dao);
    }

    @Test
    void save_new_value() {
        Dummy value = new Dummy(1000, "dummy");
        int affectedRows = dao.save(value);
        assertEquals(1, affectedRows);
    }


    @Test
    void read_all() {
        assertThat(dao.readAll()).isNotEmpty();
    }


}
