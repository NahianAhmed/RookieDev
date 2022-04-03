package com.nahian.github.io.rookiedev.services.impl;

import com.nahian.github.io.rookiedev.models.Book;
import com.nahian.github.io.rookiedev.repositorys.BookRepository;
import com.nahian.github.io.rookiedev.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
