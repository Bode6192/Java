package com.BookStore.bookStore.service;

import com.BookStore.bookStore.entity.Book;
import com.BookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book) {

        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Long id){

        return bookRepository.findById(id).get();
    }

    public void deleteById(Long id) {

        bookRepository.deleteById(id);
    }
}
