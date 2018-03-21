package com.project.pmalek_project;


import com.project.pmalek_project.facade.LibraryFacade;
import com.project.pmalek_project.repository.dto.LibraryDto;
import com.project.pmalek_project.repository.dto.impl.LibraryDtoImpl;
import com.project.pmalek_project.repository.model.Book;
import com.project.pmalek_project.repository.model.User;
import com.project.pmalek_project.repository.model.results.Result;
import com.project.pmalek_project.services.BookService;
import com.project.pmalek_project.services.LibraryService;
import com.project.pmalek_project.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

//@Slf4j
@ComponentScan
@SpringBootApplication
public class PmalekProjectApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private UserService userService;
        private BookService bookService;
        private LibraryService libraryService;
        
        @Autowired
        private LibraryFacade libraryFacade;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
        
        @Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
        
        @Autowired
	public void setLibraryService(LibraryService libraryService) {
		this.libraryService = libraryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PmalekProjectApplication.class, args);
	}

	@Override
	public void run(String... args) {

		logger.info("asdasdas");

		User user = new User(); //(new Long(1),"asd", "sadas", "asdasd", LocalDate.of(1900, 10, 29));
		user.setId(new Long(3));
		user.setFirstName("sadas");
		user.setLastName(("sdfdsf"));
		user.setEmail("sadsad");
		user.setDateOfBirdt(LocalDate.of(1900, 10, 29));


		userService.save(user);
		User u2 = userService.getById(new Long(3));


		List<User> users = userService.getAll();


		System.out.println(u2);

		//List<User> users = userService.getAll();

		users.stream().forEach(System.out::println);


		user.setLastName("xxxxxxx");
		userService.update(user);

		users.stream().forEach(System.out::println);
		System.out.println(	userService.getById(new Long(3)));

                Book book2 = bookService.getById(new Long(1));
                System.out.println(book2);
                //LibraryDto lib = new LibraryDtoImpl();
                logger.info("Availible ?: "+libraryService.checkBookIsVailible(book2));
                
                User user2 = userService.getById(new Long(2));
                
                /* TO DO
                    SEQUENCE FOR ORDERS ID
                */
                Result result = libraryFacade.rentBook(new Long(1), user2, book2);
                
                logger.info("Rent Book result: "+result.getErrorDescription());
                
                
                User user3 = userService.getById(new Long(3));
                
                result = libraryFacade.rentBook(new Long(2), user3, book2);
                
                logger.info("Rent Book result: "+result.getErrorDescription());
                
                
                User user4 = userService.getById(new Long(1));
                
                result = libraryFacade.rentBook(new Long(3), user4, book2);
                
                logger.info("Rent Book result: "+result.getErrorDescription());
                
                
                result = libraryFacade.giveBackBook(user3, book2);
                
                logger.info("Give back Book result: "+result.getErrorDescription());
                
                
                result = libraryFacade.rentBook(new Long(3), user4, book2);
                
                logger.info("Rent Book result: "+result.getErrorDescription());

	}


}


