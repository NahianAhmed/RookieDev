package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
