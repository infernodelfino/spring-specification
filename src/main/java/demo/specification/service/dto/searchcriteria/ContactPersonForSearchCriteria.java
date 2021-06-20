package demo.specification.service.dto.searchcriteria;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ContactPersonForSearchCriteria implements Serializable {
    private String name;
    private LocalDate birthOfDate;
    private String phoneNumber;
    private String shortName;
    private String street;
}
