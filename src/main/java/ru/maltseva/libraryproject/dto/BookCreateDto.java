package ru.maltseva.libraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maltseva.libraryproject.model.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookCreateDto {
    @Size(max = 15)
    @NotBlank(message = "Необходимо указать название книги")
    private String name;
    @NotBlank(message = "Необходимо указать жанр")
    private Genre genre;
}
