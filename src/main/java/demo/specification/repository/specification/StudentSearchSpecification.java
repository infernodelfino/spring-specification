package demo.specification.repository.specification;

import demo.specification.domain.Book;
import demo.specification.domain.Book_;
import demo.specification.domain.Student;
import demo.specification.domain.Student_;
import demo.specification.service.dto.searchcriteria.StudentForSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class StudentSearchSpecification {
    public static Specification<Student> getSearchSpecs(StudentForSearchCriteria searchCriteria) {

        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            ListJoin<Student, Book> joinBook = root.join(Student_.books);

            predicateList.add(
                    criteriaBuilder.like(
                            root.get(Student_.name), "%" + searchCriteria.getStudentName().toLowerCase() + "%"
                    )
            );

            predicateList.add(
                    criteriaBuilder.like(
                            joinBook.get(Book_.name), "%" + searchCriteria.getBookName().toLowerCase() + "%"
                    )
            );

            criteriaQuery.distinct(true);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };

    }
}
