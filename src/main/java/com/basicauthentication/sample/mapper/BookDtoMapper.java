package com.basicauthentication.sample.mapper;

import com.basicauthentication.sample.dto.BookDto;
import com.basicauthentication.sample.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {

    public BookDto convertToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }

    public Book convertDtoToEntity(BookDto bookDto){
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());

        return book;
    }
}
