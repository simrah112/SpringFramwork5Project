package com.firstspringwebapp.FirstSpringWebApp.repositories;

import com.firstspringwebapp.FirstSpringWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
