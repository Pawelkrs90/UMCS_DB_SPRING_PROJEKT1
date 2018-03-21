package com.project.pmalek_project.repository.model.rowMapper;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Book book = new Book();
        book.setId(resultSet.getLong("BK_ID"));
        book.setName(resultSet.getString("BK_NAME"));
        book.setAuthor(resultSet.getString("BK_AUTHOR"));
        book.setGenre(resultSet.getString("BK_GENRE"));
        book.setStatus(resultSet.getString("BK_STATUS"));

        return book;
    }
}