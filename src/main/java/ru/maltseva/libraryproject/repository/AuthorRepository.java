package ru.maltseva.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltseva.libraryproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
