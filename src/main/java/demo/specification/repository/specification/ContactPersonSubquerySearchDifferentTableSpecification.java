package demo.specification.repository.specification;

import demo.specification.domain.*;
import demo.specification.service.dto.searchcriteria.ContactPersonForSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;

public class ContactPersonSubquerySearchDifferentTableSpecification {
    public static Specification<ContactPerson> getSearchSpecs(ContactPersonForSearchCriteria searchCriteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            // SELECT *
            // FROM ContactPerson c
            // WHERE c.id NOT IN (SELECT p.contactPersonId FROM Phone p)
            // AND c.id NOT IN (SELECT c.contactPersonId FROM Company c)
            List<Predicate> predicateList = new ArrayList<>();

            // subquery WHERE c.id NOT IN (SELECT p.contactPersonId FROM Phone p)
            Subquery<Long> subqueryPhone = criteriaQuery.subquery(Long.class);
            Root<Phone> phoneRoot = subqueryPhone.from(Phone.class);
            subqueryPhone
                    .select(phoneRoot.get(Phone_.CONTACT_PERSON).get(ContactPerson_.ID));

            // subquery AND c.id NOT IN (SELECT c.contactPersonId FROM Company c
            Subquery<Long> subqueryCompany = criteriaQuery.subquery(Long.class);
            Root<Company> companyRoot = subqueryCompany.from(Company.class);
            subqueryCompany
                    .select(companyRoot.get(Company_.CONTACT_PERSON).get(Company_.ID));

            predicateList.add(criteriaBuilder.in(root.get(ContactPerson_.id)).value(subqueryPhone).not());
            predicateList.add(criteriaBuilder.in(root.get(ContactPerson_.id)).value(subqueryCompany).not());

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
