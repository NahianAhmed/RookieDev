package com.nahian.github.io.rookiedev.services;

import com.nahian.github.io.rookiedev.models.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getAllBooks();
}
