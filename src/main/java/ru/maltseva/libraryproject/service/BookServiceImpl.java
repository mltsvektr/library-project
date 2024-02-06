package ru.maltseva.libraryproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.maltseva.libraryproject.dto.BookCreateDto;
import ru.maltseva.libraryproject.dto.BookDto;
import ru.maltseva.libraryproject.dto.BookUpdateDto;
import ru.maltseva.libraryproject.model.Book;
import ru.maltseva.libraryproject.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDto getByNameV1(String name) {
        log.info("Try to find book by name {}", name);
        Optional<Book> book = bookRepository.findBookByName(name);
        if (book.isPresent()) {
            BookDto bookDto = convertEntityToDto(book.get());
            log.info("Book: {}", bookDto.toString());
            return bookDto;
        } else {
            log.error("Book with name {} not found", name);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public BookDto getByNameV2(String name) {
        log.info("Try to find book by name {}", name);
        Optional<Book> book = bookRepository.findBookByName(name);
        if (book.isPresent()) {
            BookDto bookDto = convertEntityToDto(book.get());
            log.info("Book: {}", bookDto.toString());
            return bookDto;
        } else {
            log.error("Book with name {} not found", name);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public BookDto getByNameV3(String name) {
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });
        log.info("Try to find book by name {}", name);
        Optional<Book> book = bookRepository.findBookByName(name);
        if (book.isPresent()) {
            BookDto bookDto = convertEntityToDto(book.get());
            log.info("Book: {}", bookDto.toString());
            return bookDto;
        } else {
            log.error("Book with name {} not found", name);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Book book = bookRepository.save(convertDtoToEntity(bookCreateDto));
        BookDto bookDto = convertEntityToDto(book);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        log.info("Try to find book by id {}", bookUpdateDto.getId());
        Optional<Book> book = bookRepository.findById(bookUpdateDto.getId());
        if (book.isPresent()) {
            book.get().setName(bookUpdateDto.getName());
            book.get().setGenre(bookUpdateDto.getGenre());
            Book savedBook = bookRepository.save(book.get());
            BookDto bookDto = convertEntityToDto(savedBook);
            log.info("Book: {}", bookDto.toString());
            return bookDto;
        } else {
            log.error("Book with id {} is not found", bookUpdateDto.getId());
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public void deleteBook(Long id) {
        log.info("Try to find Book by id {}", id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            log.info("Book with id {} is deleted", id);
        } else {
            log.error("Book with id {} is not found", id);
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private BookDto convertEntityToDto(Book book) {
        BookDto bookDto = BookDto.builder()
                .name(book.getName())
                .genre(book.getGenre().getName())
                .id(book.getId())
                .build();
        return bookDto;
    }

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        return Book.builder()
                .name(bookCreateDto.getName())
                .genre(bookCreateDto.getGenre())
                .build();
    }
}