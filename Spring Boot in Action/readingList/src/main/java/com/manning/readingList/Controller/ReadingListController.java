package com.manning.readingList.Controller;

import com.manning.readingList.Configuration.AmazonProperties;
import com.manning.readingList.Entity.Book;
import com.manning.readingList.Entity.Reader;
import com.manning.readingList.Repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {

    private final AmazonProperties amazonProperties;
    private final ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
        List<Book> readingList =
                readingListRepository.findByReader(String.valueOf(reader));
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public  String addToReadingList (Reader reader, Book book) {
        book.setReader(String.valueOf(reader));
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
