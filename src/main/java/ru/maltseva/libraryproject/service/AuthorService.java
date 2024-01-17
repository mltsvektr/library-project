package ru.maltseva.libraryproject.service;

import ru.maltseva.libraryproject.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

}
