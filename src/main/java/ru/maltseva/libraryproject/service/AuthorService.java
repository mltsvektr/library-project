package ru.maltseva.libraryproject.service;

import ru.maltseva.libraryproject.dto.AuthorCreateDto;
import ru.maltseva.libraryproject.dto.AuthorDto;
import ru.maltseva.libraryproject.dto.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByName(String name);

    AuthorDto getAuthorByNameV2(String name);

    AuthorDto getAuthorByNameV3(String name);
    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto);
    void deleteAuthor(Long id);
    List<AuthorDto> getAllAuthors();
}
