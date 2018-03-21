/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.pmalek_project.repository.dto.impl;

import com.project.pmalek_project.repository.dto.LibraryDto;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.rowMapper.BookOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Comarch
 */
@Repository
public class LibraryDtoImpl implements LibraryDto{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean checkBookIsVailible(Book book) {
        
        String sql = "SELECT LIB_AVAILIBLE_QUANTITY FROM Library WHERE LIB_BK_ID=?";
        Integer count = jdbcTemplate.queryForObject(
                        sql, new Object[] { book.getId() }, Integer.class);
        
        return count>0;
    }

    @Override
    public void giveBackBook(User user, Book book) {
        
        jdbcTemplate.update("DELETE FROM BOOK_ORDER WHERE BKORD_BK_ID = ? AND BKORD_USR_ID = ?",
                book.getId(),
                user.getId());
        
        jdbcTemplate.update("UPDATE LIBRARY SET LIB_AVAILIBLE_QUANTITY = LIB_AVAILIBLE_QUANTITY + 1 WHERE LIB_BK_ID = ?",
                book.getId());
    }
}
