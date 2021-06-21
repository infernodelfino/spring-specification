package demo.specification.repository;

import demo.specification.domain.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    @Override
    @EntityGraph(attributePaths = {"books"})
    List<Student> findAll(Specification<Student> specification);
}
