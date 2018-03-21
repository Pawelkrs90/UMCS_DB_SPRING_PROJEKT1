package com.project.pmalek_project.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class BookOrder {

    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate bookingDate;
    private String type;
    
    public interface Type{
        public static final String RENT = "R";
        public static final String BUY = "B";
        public static final String DESTROY = "D";
    }
    
    public BookOrder() {
    }

    public BookOrder(Long id, Long bookId, Long userId, LocalDate bookingDate, String type) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
