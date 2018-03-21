package com.project.pmalek_project.repository.dao.impl;

import com.project.pmalek_project.repository.dao.BookOrderDao;
import com.project.pmalek_project.repository.model.BookOrder;
import com.project.pmalek_project.repository.model.rowMapper.BookOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookOrderDaoJDBCImpl implements BookOrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BookOrder getById(Long id) {
        String sql = "SELECT * FROM BOOK_ORDER WHERE BKORD_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookOrderMapper());
    }

    @Override
    public List<BookOrder> getAll() {
        String sql = "SELECT * FROM BOOK_ORDER";
        return jdbcTemplate.query(sql, new BookOrderMapper());
    }

    @Override
    public void save(BookOrder bookOrder) {
        jdbcTemplate.update("INSERT INTO BOOK_ORDER (BKORD_ID, BKORD_BK_ID, BKORD_USR_ID, BKORD_BOOKING_DATE, BKORD_TYPE) VALUES(?, ?, ?, ?, ?)",
                bookOrder.getId(),
                bookOrder.getUserId(),
                bookOrder.getBookId(),
                java.sql.Date.valueOf( bookOrder.getBookingDate()),
                bookOrder.getType());
        
        jdbcTemplate.update("UPDATE LIBRARY SET LIB_AVAILIBLE_QUANTITY = LIB_AVAILIBLE_QUANTITY - 1 WHERE LIB_BK_ID = ?",
                bookOrder.getBookId());
    }

    @Override
    public void delete(BookOrder bookOrder) {

    }
}
