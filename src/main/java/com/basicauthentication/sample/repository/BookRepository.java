package com.basicauthentication.sample.repository;

import com.basicauthentication.sample.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String username);
}
