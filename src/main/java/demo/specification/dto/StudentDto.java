package demo.specification.dto;

import demo.specification.domain.Book;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private List<Book> books;
}
