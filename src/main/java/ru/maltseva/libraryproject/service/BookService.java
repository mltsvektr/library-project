package ru.maltseva.libraryproject.service;

import ru.maltseva.libraryproject.dto.BookCreateDto;
import ru.maltseva.libraryproject.dto.BookDto;
import ru.maltseva.libraryproject.dto.BookUpdateDto;

public interface BookService {
    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    void deleteBook(Long id);
}
