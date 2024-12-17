package com.basicauthentication.sample.service;

import com.basicauthentication.sample.dto.BookDto;
import com.basicauthentication.sample.entity.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
    BookDto findById(Long id);
    BookDto create(BookDto bookDto);
    BookDto update(Long id, Book book);
    void delete(Long id);
}
