package com.project.pmalek_project.facade.impl;

import com.project.pmalek_project.facade.LibraryFacade;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.BookOrder;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.results.Result;
import com.project.pmalek_project.repository.model.results.impl.LibraryActionResult;
import com.project.pmalek_project.services.BookOrderService;
import com.project.pmalek_project.services.BookService;
import com.project.pmalek_project.services.LibraryService;
import com.project.pmalek_project.services.UserService;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryFacadeImpl implements LibraryFacade {

    private UserService userService;
    private BookService bookSevice;
    private BookOrderService bookOrderService;
    private LibraryService libraryService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setBookOrderService(BookOrderService bookOrderService){
        this.bookOrderService = bookOrderService;
    }
    
    @Autowired
    public void setBookService(BookService bookSevice){
        this.bookSevice = bookSevice;
    }

    @Autowired
	public void setLibraryService(LibraryService libraryService) {
	    this.libraryService = libraryService;
    }
        
        
    @Override
    public Result rentBook(Long id, User user, Book book) {
        
        LibraryActionResult result = new LibraryActionResult();
        
        if(libraryService.checkBookIsVailible(book)){
            BookOrder bookOrder = new BookOrder();
              
            bookOrder.setId(id);
            bookOrder.setBookId(book.getId());
            bookOrder.setUserId(user.getId());
            bookOrder.setBookingDate(LocalDate.of(2018, Month.MARCH, 21));
            bookOrder.setType(BookOrder.Type.RENT);

            bookOrderService.save(bookOrder);
            
            result.setErrorCode(0);
            result.setErrorDescription("SUCCES");
        }else{
            /*TO DO
            
                CONSTANT ERROR CODES
            
            */
            result.setErrorCode(1);  
            result.setErrorDescription("BOOK NOT AVAILIBLE");
        }
      return result;
    }

    @Override
    public Result buyBook(Long id, User user, Book book) {
        LibraryActionResult result = new LibraryActionResult();
        
        if(libraryService.checkBookIsVailible(book)){
            BookOrder bookOrder = new BookOrder();
              
            bookOrder.setId(id);
            bookOrder.setBookId(book.getId());
            bookOrder.setUserId(user.getId());
            bookOrder.setBookingDate(LocalDate.of(2018, Month.MARCH, 21));
            bookOrder.setType(BookOrder.Type.BUY);

            bookOrderService.save(bookOrder);
            
            result.setErrorCode(0);
            result.setErrorDescription("SUCCES");
        }else{
            /*TO DO
            
                CONSTANT ERROR CODES
            */
            result.setErrorCode(1);  
            result.setErrorDescription("BOOK NOT AVAILIBLE");
        }
      return result;
    }

    @Override
    public Result giveBackBook(User user, Book book) {
        LibraryActionResult result = new LibraryActionResult();
        
        libraryService.giveBackBook(user, book);
        
        return result;
    }

    @Override
    public Result reportDestroyedBook(User user, Book book) {
       
        return null; 
    }

    @Override
    public boolean checkIsBookAvailible(Book book) {
        return false;
    }

    @Override
    public Result extendBookTime(User user, Book book) {
        return null;
    }
}
