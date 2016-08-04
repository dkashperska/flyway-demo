package db.migration;

import luxoft.beans.User;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class V4__Login_Creation implements SpringJdbcMigration {

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

        String selector = "SELECT * FROM Users";

        String updater = "UPDATE Users " +
                "SET login = ? " +
                "WHERE id = ? ;";

        List<User> users  = jdbcTemplate.query(selector, new BeanPropertyRowMapper(User.class));

        List<Object[]> args = new ArrayList<>();

        args.addAll(users.stream().map(
                u -> { return new Object[] {
                u.getFirstname().charAt(0) + u.getLastname(),
                u.getId()}; }
            ).collect(Collectors.toList()));

        jdbcTemplate.batchUpdate(updater, args);
    }
}