package com.project.pmalek_project.repository.model;

public class Library {

    private Long id;
    private Book book;
    private int quantity;
    private int availible;

    public Library() {
    }

    public Library(Long id, Book book, int quantity, int availible) {
        this.id = id;
        this.book = book;
        this.quantity = quantity;
        this.availible = availible;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailible() {
        return availible;
    }

    public void setAvailible(int availible) {
        this.availible = availible;
    }
    
    

}
