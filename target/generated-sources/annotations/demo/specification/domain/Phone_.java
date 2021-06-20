package demo.specification.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Phone.class)
public abstract class Phone_ {

	public static volatile SingularAttribute<Phone, String> countryPrefix;
	public static volatile SingularAttribute<Phone, String> phoneNumber;
	public static volatile SingularAttribute<Phone, String> sign;
	public static volatile SingularAttribute<Phone, ContactPerson> contactPerson;
	public static volatile SingularAttribute<Phone, Long> id;

	public static final String COUNTRY_PREFIX = "countryPrefix";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String SIGN = "sign";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String ID = "id";

}

