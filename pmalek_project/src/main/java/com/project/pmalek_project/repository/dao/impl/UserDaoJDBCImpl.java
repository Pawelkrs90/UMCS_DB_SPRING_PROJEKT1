package com.project.pmalek_project.repository.dao.impl;

import com.project.pmalek_project.repository.dao.UserDao;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoJDBCImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getById(Long id){
        String sql = "SELECT * FROM USER WHERE USR_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void save(User user) {
            jdbcTemplate.update("INSERT INTO User (USR_ID, USR_FIRST_NAME, USR_LAST_NAME, USR_EMAIL, USR_BIRTH_DATE) VALUES(?, ?, ?, ?, ?)",
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                java.sql.Date.valueOf(user.getDateOfBirdt()));
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE User SET USR_FIRST_NAME=?, USR_LAST_NAME=?, USR_EMAIL=?, USR_BIRTH_DATE=? WHERE USR_ID = ?",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                java.sql.Date.valueOf(user.getDateOfBirdt()),
                user.getId());
    }

    @Override
    public void delete(User user) {
        jdbcTemplate.update("DELETE FROM User WHERE id = ?", user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM User WHERE id = ?", id);
    }
}
