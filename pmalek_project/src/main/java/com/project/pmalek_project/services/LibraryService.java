/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.pmalek_project.services;

import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;

/**
 *
 * @author Comarch
 */
public interface LibraryService {
    
      public boolean checkBookIsVailible(Book book);
      public void giveBackBook(User user, Book book);

}
