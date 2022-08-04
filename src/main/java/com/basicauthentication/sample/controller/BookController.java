package com.basicauthentication.sample.controller;

import com.basicauthentication.sample.dto.BookDto;
import com.basicauthentication.sample.entity.Book;
import com.basicauthentication.sample.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> bookList = bookService.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable("id") Long id) {
        BookDto book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> create(@Valid @RequestBody Book book) {
        BookDto savedBook = bookService.create(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> create(@PathVariable("id") Long id,
                                       @Valid @RequestBody Book book) {
        BookDto savedBook = bookService.update(id, book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(id + " book is deleted!");
    }
}
