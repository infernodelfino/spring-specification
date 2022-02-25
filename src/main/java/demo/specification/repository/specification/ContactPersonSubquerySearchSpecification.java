package demo.specification.repository.specification;

import demo.specification.domain.ContactPerson;
import demo.specification.domain.ContactPerson_;
import demo.specification.service.dto.searchcriteria.ContactPersonForSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;

public class ContactPersonSubquerySearchSpecification {
    public static Specification<ContactPerson> getSearchSpecs(ContactPersonForSearchCriteria searchCriteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            // SELECT * FROM ContactPerson c WHERE c.id NOT IN (SELECT cp.id FROM ContactPerson cp WHERE cp.id = :id)
            List<Predicate> predicateList = new ArrayList<>();

            Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
            Root<ContactPerson> subRoot = subquery.from(ContactPerson.class);

            subquery
                    .select(subRoot.get(ContactPerson_.id))
                    .where(criteriaBuilder.equal(subRoot.get(ContactPerson_.id), searchCriteria.getId()));

            predicateList.add(criteriaBuilder.in(root.get(ContactPerson_.id)).value(subquery).not());

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
