package ru.maltseva.libraryproject.service;

import ru.maltseva.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByName(String name);

    AuthorDto getAuthorByNameV2(String name);

    AuthorDto getAuthorByNameV3(String name);
}
