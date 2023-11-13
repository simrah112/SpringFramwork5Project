package com.firstspringwebapp.FirstSpringWebApp.repositories;

import com.firstspringwebapp.FirstSpringWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
