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
            // SELECT DISTINCT *
            // FROM ContactPerson cp
            // JOIN Phone p ON cp.id = p.contactPersonId
            // JOIN Company c ON cp.companyId = c.id
            // JOIN Address a ON c.id = a.companyId
            // WHERE cp.name LIKE '%searchCriteria.name%'
            // AND concat(concat(p.sign, p.countryPrefix), p.phoneNumber) LIKE '%searchCriteria.phoneNumber%'
            // AND c.shortName LIKE '%searchCriteria.shortName%'
            // AND a.street LIKE '%searchCriteria.street%'
            List<Predicate> predicateList = new ArrayList<>();

            // for ContactPerson.name
            // WHERE cp.name LIKE '%searchCriteria.name%'
            predicateList.add(
                    criteriaBuilder.like(
                            root.get(ContactPerson_.name), "%" + searchCriteria.getName() + "%"
                    )
            );

            // Join Phone and add predicate
            // AND concat(concat(p.sign, p.countryPrefix), p.phoneNumber) LIKE '%searchCriteria.phoneNumber%'
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
            // AND c.shortName LIKE '%searchCriteria.shortName%'
            Join<ContactPerson, Company> joinCompany = root.join(ContactPerson_.company);
            predicateList.add(
                    criteriaBuilder.like(
                            joinCompany.get(Company_.shortName), "%" + searchCriteria.getShortName() + "%"
                    )
            );

            // join company, join address
            // AND a.street LIKE '%searchCriteria.street%'
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
