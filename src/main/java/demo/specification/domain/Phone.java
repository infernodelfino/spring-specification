package demo.specification.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sign;
    private String countryPrefix;
    private String phoneNumber;

    @ManyToOne
    private ContactPerson contactPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Phone)) {
            return false;
        }
        return id != null && id.equals(((Phone) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + getId() +
                ", sign='" + getSign() + "'" +
                ", countryPrefix='" + getCountryPrefix() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                "}";
    }
}
