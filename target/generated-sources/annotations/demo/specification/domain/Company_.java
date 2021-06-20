package demo.specification.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, Address> address;
	public static volatile SingularAttribute<Company, String> fullName;
	public static volatile SingularAttribute<Company, ContactPerson> contactPerson;
	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, String> shortName;

	public static final String ADDRESS = "address";
	public static final String FULL_NAME = "fullName";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";

}

