package com.project.pmalek_project.repository.dao;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.BookOrder;

import java.util.List;

public interface BookOrderDao {

    public BookOrder getById(Long id);

    public List<BookOrder> getAll();

    public void save(BookOrder bookOrder);

    public void delete(BookOrder bookOrder);

}
