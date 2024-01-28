package ru.maltseva.libraryproject.service;

import ru.maltseva.libraryproject.dto.BookCreateDto;
import ru.maltseva.libraryproject.dto.BookDto;
import ru.maltseva.libraryproject.dto.BookUpdateDto;

import java.util.List;

public interface BookService {
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);
    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    void deleteBook(Long id);

    List<BookDto> getAllBooks();
}
