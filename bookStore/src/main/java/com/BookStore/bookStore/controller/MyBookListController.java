package com.BookStore.bookStore.controller;

import com.BookStore.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Long id) {

        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }
}
