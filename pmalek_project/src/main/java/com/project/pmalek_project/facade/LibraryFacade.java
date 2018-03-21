package com.project.pmalek_project.facade;


import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.results.Result;

public interface LibraryFacade {

    public Result rentBook(Long id, User user, Book book);

    public Result buyBook(Long id, User user, Book book);

    public Result giveBackBook(User user, Book book);

    public Result reportDestroyedBook(User user, Book book);

    public boolean checkIsBookAvailible(Book book);

    public Result extendBookTime(User user, Book book);

}
