package com.project.pmalek_project.repository.dao.impl;

import com.project.pmalek_project.repository.dao.BookDao;
import com.project.pmalek_project.repository.dao.UserDao;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.rowMapper.BookRowMapper;
import com.project.pmalek_project.repository.model.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoJDBCImpl implements BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Book getById(Long id){
        String sql = "SELECT * FROM Book WHERE BK_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookRowMapper());
    }

    @Override
    public List<Book> getAll() {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public Book getByName(String name) {
        String sql = "SELECT * FROM Book WHERE BK_NAME=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new BookRowMapper());
    }

    @Override
    public void save(Book book) {
            jdbcTemplate.update("INSERT INTO Book (BK_ID, BK_NAME, BK_AUTHOR, BK_GENRE, BK_STATUS) VALUES(?, ?, ?, ?, ?)",
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getStatus());
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update("UPDATE User SET BK_NAME=?, BK_AUTHOR=?, BK_GENRE=?, BK_STATUS=? WHERE BK_ID = ?",
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getStatus(),
                book.getId());
    }

    @Override
    public void delete(Book book) {
        jdbcTemplate.update("DELETE FROM Book WHERE id = ?", book.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id = ?", id);
    }
}
