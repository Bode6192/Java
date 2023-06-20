package com.BookStore.bookStore.service;

import com.BookStore.bookStore.entity.MyBookList;
import com.BookStore.bookStore.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBooksRepository myBooksRepository;

    public void saveMyBooks(MyBookList myBookList) {

        myBooksRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks() {

        return myBooksRepository.findAll();
    }

    public void deleteById(Long id){

        myBooksRepository.deleteById(id);
    }
}
