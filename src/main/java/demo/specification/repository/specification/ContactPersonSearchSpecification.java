package demo.specification.repository.specification;

import demo.specification.domain.*;
import demo.specification.service.dto.searchcriteria.ContactPersonForSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.SetJoin;
import java.util.ArrayList;
import java.util.List;

public class ContactPersonSearchSpecification {
    public static Specification<ContactPerson> getSearchSpecs(ContactPersonForSearchCriteria searchCriteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            // for ContactPerson.name
            predicateList.add(
                    criteriaBuilder.like(
                            root.get(ContactPerson_.name), "%" + searchCriteria.getName() + "%"
                    )
            );

            // Join Phone and add predicate
            SetJoin<ContactPerson, Phone> joinPhone = root.join(ContactPerson_.phones);
            predicateList.add(
                    criteriaBuilder.like(
                            criteriaBuilder.concat(
                                    criteriaBuilder.concat(
                                            joinPhone.get(Phone_.sign), joinPhone.get(Phone_.countryPrefix)), joinPhone.get(Phone_.phoneNumber)
                            ), "%" + searchCriteria.getPhoneNumber() + "%"
                    )
            );

            // join Company, get company short name
            Join<ContactPerson, Company> joinCompany = root.join(ContactPerson_.company);
            predicateList.add(
                    criteriaBuilder.like(
                            joinCompany.get(Company_.shortName), "%" + searchCriteria.getShortName() + "%"
                    )
            );

            // join company, join address
            Join<Company, Address> joinAddress = root.join(ContactPerson_.company).join(Company_.address);
            predicateList.add(
                    criteriaBuilder.like(
                            joinAddress.get(Address_.street), "%" + searchCriteria.getStreet() + "%"
                    )
            );

            criteriaQuery.distinct(true);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
//
    }
}
