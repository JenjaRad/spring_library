package com.bookmanager.config;

import com.bookmanager.dao.BookDaoImpl;
import com.bookmanager.servise.ServiseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Analog configuration in xml file(Not for using)
 *
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public BookDaoImpl bookDao() {
        BookDaoImpl bookDao = new BookDaoImpl();
       // bookDao.setSessionFactory();
        return bookDao;
    }

    @Bean
    public ServiseImpl servise() {
        ServiseImpl servise = new ServiseImpl();
        servise.setBookDao(bookDao());
        return servise;
    }
}
