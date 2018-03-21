package com.project.pmalek_project.services.impl;

import com.project.pmalek_project.repository.dao.BookDao;
import com.project.pmalek_project.repository.dao.UserDao;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.services.BookService;
import com.project.pmalek_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book getById(Long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getByName(String name) {
        return bookDao.getByName(name);
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }
}
