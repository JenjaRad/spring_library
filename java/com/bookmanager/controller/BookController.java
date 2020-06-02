package com.bookmanager.controller;

import com.bookmanager.dto.Book;
import com.bookmanager.servise.Servise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {

    private Servise bookServise;

    @Autowired
    @Qualifier
    public void setServise(Servise servise) {
        this.bookServise = servise;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", new Book());
        model.addAttribute("listBooks", this.bookServise.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookServise.createBook(book);
        } else {
            bookServise.updateBook(book);
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("{id}") Long id) {
        this.bookServise.deleteBook(id);
        return "redirect:/books";
    }
    @RequestMapping(value = "/books/editing")
    public String editBook(@PathVariable("{id}") long id,Model model){
        model.addAttribute("editBooks",this.bookServise.getById(id));
        model.addAttribute("listBooks",this.bookServise.getAllBooks());
        return "books";
    }
    @RequestMapping(value = "checkBook")
    public String checkBook(@PathVariable("{id}") long id,Model model){
    model.addAttribute("checkBook",this.bookServise.getById(id));
    return "checkBook";
    }
}