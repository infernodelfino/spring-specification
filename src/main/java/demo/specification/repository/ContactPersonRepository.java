package demo.specification.repository;

import demo.specification.domain.ContactPerson;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long>, JpaSpecificationExecutor<ContactPerson> {

    @Override
    @EntityGraph(attributePaths = {"phones", "company.address"})
    List<ContactPerson> findAll(Specification<ContactPerson> specification);
}
