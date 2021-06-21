package demo.specification.service;

import demo.specification.domain.Student;
import demo.specification.dto.StudentDto;
import demo.specification.repository.StudentRepository;
import demo.specification.repository.specification.StudentSearchSpecification;
import demo.specification.service.dto.searchcriteria.StudentForSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentDto> findAll(StudentForSearchCriteria searchCriteria) {
        List<StudentDto> result = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll(StudentSearchSpecification.getSearchSpecs(searchCriteria));
        StudentDto dto = null;
        for (Student s: studentList) {
            dto = new StudentDto();
            dto.setName(s.getName());
            dto.setId(s.getId());
            dto.setBooks(s.getBooks());
            result.add(dto);
        }

        return result;
    }
}
