package ru.maltseva.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltseva.libraryproject.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
