package com.project.pmalek_project.repository.model.rowMapper;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.BookOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookOrderMapper  implements RowMapper<BookOrder> {

    @Override
    public BookOrder mapRow(ResultSet resultSet, int i) throws SQLException {

        BookOrder bookOrder = new BookOrder();
        bookOrder.setId(resultSet.getLong("BKORD_ID"));
        bookOrder.setBookId(resultSet.getLong("BKORD_BK_ID"));
        bookOrder.setUserId(resultSet.getLong("BKORD_USR_ID"));
        Date date = resultSet.getDate("BKORD_BOOKING_DATE");
        if(null!=date){
            bookOrder.setBookingDate(date.toLocalDate());
        }
        bookOrder.setType(resultSet.getString("BKORD_TYPE"));
        return bookOrder;
    }
}
