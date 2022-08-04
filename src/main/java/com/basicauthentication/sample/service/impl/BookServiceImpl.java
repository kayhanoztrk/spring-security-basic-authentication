package com.basicauthentication.sample.service.impl;

import com.basicauthentication.sample.dto.BookDto;
import com.basicauthentication.sample.entity.Book;
import com.basicauthentication.sample.exception.BookNotFoundException;
import com.basicauthentication.sample.mapper.BookDtoMapper;
import com.basicauthentication.sample.repository.BookRepository;
import com.basicauthentication.sample.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookDtoMapper bookDtoMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           BookDtoMapper bookDtoMapper){
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream().map((b -> bookDtoMapper.convertToDto(b)))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(Long id) {
        Book book =  bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id + " book not found!"));

        return bookDtoMapper.convertToDto(book);
    }

    @Override
    public BookDto create(Book book) {
        Book savedBook =  bookRepository.save(book);
        return bookDtoMapper.convertToDto(book);
    }

    @Override
    public BookDto update(Long id, Book book) {
        Book willSaveBook =  bookRepository.findById(id)
                .orElseThrow(() ->new BookNotFoundException(id + " book not found!"));
        willSaveBook.setName(book.getName());
        willSaveBook.setPrice(book.getPrice());

        Book savedBook =  bookRepository.save(willSaveBook);
        return bookDtoMapper.convertToDto(savedBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
