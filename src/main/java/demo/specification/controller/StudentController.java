package demo.specification.controller;

import demo.specification.dto.StudentDto;
import demo.specification.service.StudentService;
import demo.specification.service.dto.searchcriteria.StudentForSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    @Transactional(readOnly = true)
    public List<StudentDto> findAll(StudentForSearchCriteria searchCriteria) {
        return studentService.findAll(searchCriteria);
    }
}
