package demo.specification.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class ContactPersonDto {
    private String name;
    private LocalDate birthOfDate;
    private Set<String> phoneNumber;
    private String shortName;
    private String street;
}
