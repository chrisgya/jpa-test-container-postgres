package com.chrisgya.jpatestcontainerpostgres.dao;

import com.chrisgya.jpatestcontainerpostgres.entity.Dummy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DummyDao {
    private final JdbcTemplate template;

    public Dummy findDummyById(int id) {
        return (Dummy)template
                .queryForObject("SELECT * FROM dummy_test where id=?", new Object[]{id},
                        new DummyRowMapper());
    }

    public List readAll() {
        return template.query("SELECT id,name_value FROM dummy_test", new DummyRowMapper());
    }

    public int save(Dummy dummy) {
        return template.update("INSERT INTO dummy_test (id,name_value) VALUES (?,?) ",
                new Object[]{dummy.getId(), dummy.getName()});
    }

    static class DummyRowMapper implements RowMapper {
        @Override
        public Dummy mapRow(ResultSet rs, int rowNumber) throws SQLException {
            return new Dummy(rs.getInt("id"), rs.getString("name_value"));
        }
    }
}
