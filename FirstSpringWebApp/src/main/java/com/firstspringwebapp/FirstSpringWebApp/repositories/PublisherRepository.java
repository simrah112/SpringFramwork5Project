package com.firstspringwebapp.FirstSpringWebApp.repositories;

import com.firstspringwebapp.FirstSpringWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
