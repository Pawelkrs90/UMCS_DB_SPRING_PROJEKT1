/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.pmalek_project.services.impl;

import com.project.pmalek_project.repository.dto.LibraryDto;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Comarch
 */
@Service
public class LibraryServiceImpl implements LibraryService{

    private LibraryDto libraryDtoImpl;

    @Autowired
    public void setLibraryDto(LibraryDto libraryDtoImpl) {
        this.libraryDtoImpl = libraryDtoImpl;
    }
    
    @Override
    @Transactional
    public boolean checkBookIsVailible(Book book) {
        return libraryDtoImpl.checkBookIsVailible(book);
    }

    @Override
    @Transactional
    public void giveBackBook(User user, Book book) {
        libraryDtoImpl.giveBackBook(user, book);
    }
    
}
