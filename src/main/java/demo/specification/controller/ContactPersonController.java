package demo.specification.controller;

import demo.specification.domain.ContactPerson;
import demo.specification.dto.ContactPersonDto;
import demo.specification.service.ContactPersonService;
import demo.specification.service.dto.searchcriteria.ContactPersonForSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ContactPersonController {
    private final ContactPersonService contactPersonService;

    @GetMapping("/contact-persons")
    @Transactional(readOnly = true)
    public List<ContactPersonDto> findAll(ContactPersonForSearchCriteria searchCriteria) {
        return contactPersonService.findAll(searchCriteria);
    }

    @GetMapping("/contact-persons-sub")
    @Transactional(readOnly = true)
    public List<ContactPersonDto> findAllSub(ContactPersonForSearchCriteria searchCriteria) {
        return contactPersonService.findAllSubquery(searchCriteria);
    }
}
