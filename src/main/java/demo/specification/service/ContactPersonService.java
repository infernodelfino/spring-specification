package demo.specification.service;

import demo.specification.domain.ContactPerson;
import demo.specification.dto.ContactPersonDto;
import demo.specification.repository.ContactPersonRepository;
import demo.specification.repository.specification.ContactPersonSearchSpecification;
import demo.specification.service.dto.searchcriteria.ContactPersonForSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;

    public List<ContactPersonDto> findAll(ContactPersonForSearchCriteria searchCriteria) {
        List<ContactPerson> contactPersonList = contactPersonRepository.findAll(ContactPersonSearchSpecification.getSearchSpecs(searchCriteria));

        List<ContactPersonDto> result = new ArrayList<>();
        ContactPersonDto dto = null;
        for (ContactPerson e: contactPersonList) {
            dto = new ContactPersonDto();
            dto.setName(e.getName());
            dto.setBirthOfDate(e.getBirthOfDate());
            dto.setPhoneNumber(e.getPhones().stream().map(p -> p.getSign() + p.getCountryPrefix() + p.getPhoneNumber()).collect(Collectors.toSet()));
            dto.setShortName(e.getCompany().getShortName());
            dto.setStreet(e.getCompany().getAddress().getStreet());
            result.add(dto);
        }

        return result;
    }
}
