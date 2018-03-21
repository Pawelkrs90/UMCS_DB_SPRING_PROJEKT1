package com.project.pmalek_project.repository.model.rowMapper;

import com.project.pmalek_project.repository.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setId(resultSet.getLong("USR_ID"));
        user.setFirstName(resultSet.getString("USR_FIRST_NAME"));
        user.setLastName(resultSet.getString("USR_LAST_NAME"));
        user.setEmail(resultSet.getString("USR_EMAIL"));
        Date dob = resultSet.getDate("USR_BIRTH_DATE");
        if (null != dob) {
            user.setDateOfBirdt(dob.toLocalDate());
        }
        return user;
    }
}