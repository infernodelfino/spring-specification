package demo.specification.service.dto.searchcriteria;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StudentForSearchCriteria implements Serializable {
    private String studentName;
    private String bookName;
}
