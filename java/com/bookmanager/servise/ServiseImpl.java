package com.bookmanager.servise;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class ServiseImpl implements Servise {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void createBook(Book book) {
        this.bookDao.createBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
    this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        this.bookDao.deleteBook(id);
    }

    @Override
    @Transactional
    public Book getById(long id) {
        return this.bookDao.getById(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return this.bookDao.getAllBooks();
    }
}
