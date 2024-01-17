package ru.maltseva.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltseva.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
 