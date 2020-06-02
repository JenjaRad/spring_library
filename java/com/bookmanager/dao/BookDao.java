package com.bookmanager.dao;

import com.bookmanager.dto.Book;

import java.util.List;

public interface BookDao {
    void createBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
    Book getById(long id);
    List<Book> getAllBooks();

}
