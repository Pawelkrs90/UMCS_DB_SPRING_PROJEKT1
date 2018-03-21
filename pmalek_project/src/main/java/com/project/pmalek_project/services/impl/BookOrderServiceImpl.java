package com.project.pmalek_project.services.impl;

import com.project.pmalek_project.repository.dao.BookDao;
import com.project.pmalek_project.repository.dao.BookOrderDao;
import com.project.pmalek_project.repository.dao.UserDao;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.BookOrder;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.services.BookOrderService;
import com.project.pmalek_project.services.BookService;
import com.project.pmalek_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    private BookOrderDao bookOrderDao;

    @Autowired
    public void setBookOrderDao(BookOrderDao bookOrderDao) {
        this.bookOrderDao = bookOrderDao;
    }

    @Override
    public BookOrder getById(Long id) {
        return bookOrderDao.getById(id);
    }

    @Override
    public List<BookOrder> getAll() {
        return bookOrderDao.getAll();
    }

    @Override
    @Transactional
    public void save(BookOrder bookOrder) {
        bookOrderDao.save(bookOrder);
    }

    @Override
    public void delete(BookOrder bookOrder) {
        bookOrderDao.delete(bookOrder);
    }
}
