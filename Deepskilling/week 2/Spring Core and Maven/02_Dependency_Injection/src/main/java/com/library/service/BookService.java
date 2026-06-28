package com.library.service;

import com.library.repository.BookRepository;

public class BookService{

    BookRepository bookRepository;

    public BookService( ) {
        System.out.println("BookService Object is created...");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void logNewBook(){
        System.out.println("processing book business logic in BookService...");
        bookRepository.saveData();
    }
}
