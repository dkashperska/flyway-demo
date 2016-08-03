package luxoft;

import luxoft.beans.User;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class V4__Login_Creation implements SpringJdbcMigration {

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

        String selector = "SELECT * FROM Users";

        String updater = "UPDATE Users " +
                "SET login = ? " +
                "WHERE id = ? ;";

        List<User> users  = jdbcTemplate.query(selector, new BeanPropertyRowMapper(User.class));

        for (User user : users) {
            String login = user.getFirstname().charAt(0) + user.getLastname();
            jdbcTemplate.update(updater, login, user.getId());
        }
    }
}