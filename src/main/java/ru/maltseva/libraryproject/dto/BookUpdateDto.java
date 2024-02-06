package ru.maltseva.libraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maltseva.libraryproject.model.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookUpdateDto {
    private Long id;
    @NotBlank(message = "Необходимо указать название книги")
    private String name;
    @NotBlank(message = "Необходимо указать жанр")
    private Genre genre;
}
