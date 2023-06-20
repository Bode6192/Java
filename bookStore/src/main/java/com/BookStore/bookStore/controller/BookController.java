package com.BookStore.bookStore.controller;

import com.BookStore.bookStore.entity.Book;
import com.BookStore.bookStore.entity.MyBookList;
import com.BookStore.bookStore.service.BookService;
import com.BookStore.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/")
public class BookController {

    @Autowired
    private MyBookListService myBookListService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {

        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {

        List<Book> listOfAvailableBooks = bookService.getAllBooks();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject(listOfAvailableBooks);

        return new ModelAndView("bookList", "books", listOfAvailableBooks);
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {

        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("books", list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){

        bookService.saveBook(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") Long id) {

        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());

        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {

        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);

        return  "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {

        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
