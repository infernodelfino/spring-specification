package demo.specification.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile ListAttribute<Book, Student> student;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, Long> id;

	public static final String STUDENT = "student";
	public static final String NAME = "name";
	public static final String ID = "id";

}

