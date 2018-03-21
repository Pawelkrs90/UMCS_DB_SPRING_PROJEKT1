package com.project.pmalek_project.services;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;

import java.util.List;

public interface BookService {

    public Book getById(Long id);
    public List<Book> getAll();
    public Book getByName(String name);
    public void save(Book book);
    public void update(Book book);
    public void delete(Book book);
    public void delete(Long id);
}
