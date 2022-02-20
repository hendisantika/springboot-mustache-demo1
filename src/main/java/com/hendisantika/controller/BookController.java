package com.hendisantika.controller;

import com.hendisantika.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mustache-demo1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 07.28
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BookController {
    @GetMapping("/books")
    public String getProducts(final Model model) {

        var bookList = IntStream.range(0, 7)
                .mapToObj(this::getBook)
                .collect(Collectors.toList());

        model.addAttribute("bookList", bookList);
        return "book";
    }

    private Book getBook(int i) {
        return new Book(i,
                "ISBN Number -" + i,
                "Book Name " + i,
                "Author " + i,
                (double) (100 * i));
    }
}
