package ru.maltseva.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maltseva.libraryproject.dto.AuthorForGenreDto;
import ru.maltseva.libraryproject.dto.BookForGenreDto;
import ru.maltseva.libraryproject.dto.GenreDto;
import ru.maltseva.libraryproject.model.Genre;
import ru.maltseva.libraryproject.repository.GenreRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }

    private GenreDto convertToDto(Genre genre) {
        List<BookForGenreDto> bookForGenreDtoList = genre.getBooks()
                .stream()
                .map(book -> BookForGenreDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .authors(book.getAuthors().stream()
                                .map(author -> AuthorForGenreDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build()
                                ).toList())
                        .build()
                ).toList();
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookForGenreDtoList)
                .build();
    }
}
