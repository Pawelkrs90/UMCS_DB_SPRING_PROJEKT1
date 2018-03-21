package com.project.pmalek_project.services;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.BookOrder;
import com.project.pmalek_project.repository.model.User;

import java.util.List;

public interface BookOrderService {

    public BookOrder getById(Long id);
    public List<BookOrder> getAll();
    public void save(BookOrder bookOrder);
    public void delete(BookOrder bookOrder);
}
