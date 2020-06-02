package com.bookmanager.dao;

import com.bookmanager.dto.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createBook(Book book) {
       Session session = sessionFactory.getCurrentSession();
       session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void deleteBook(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class,new Long(id));
        if(book!=null) {
            session.delete(book);
        }

        }

    @Override
    public Book getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class,new Long(id));
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
     CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<Book>bookList = query.getResultList();
        return bookList;
    }
}
