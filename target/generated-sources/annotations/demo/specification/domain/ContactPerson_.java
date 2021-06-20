package demo.specification.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContactPerson.class)
public abstract class ContactPerson_ {

	public static volatile SingularAttribute<ContactPerson, LocalDate> birthOfDate;
	public static volatile SingularAttribute<ContactPerson, String> name;
	public static volatile SetAttribute<ContactPerson, Phone> phones;
	public static volatile SingularAttribute<ContactPerson, Company> company;
	public static volatile SingularAttribute<ContactPerson, Long> id;

	public static final String BIRTH_OF_DATE = "birthOfDate";
	public static final String NAME = "name";
	public static final String PHONES = "phones";
	public static final String COMPANY = "company";
	public static final String ID = "id";

}

