package com.nareshit.derivedmethods.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.Person;

@Repository
public interface PersonDao  extends CrudRepository<Person, Integer>{


	//Start  of Derived Methods Section

	public List<Person> findByLastName(String lastName);



	// And KeyWord
	// If we want to retrieve the data using more than one column then we can use
	// And Keyword.
	// JPQL -> select * from person where firstName=?1 and lastName=?2
	public Person findByFirstNameAndLastName(String firstName, String lastName);


	// OR KeyWord
	// If we want to retrieve the data using more than one column then we can use
	// OR Keyword.
	// JPQL -> Select * from person where firstName=?1 or lastName=?2
	public List<Person> findByFirstNameOrLastName(String firstName, String lastName);


	// OrderBy
	// This will does sorting based on columnName
	// selet * from person where lastName=?1 order by creationDate desc;
	//findBy
	//LastName
	//OrderBy
	//CreatedDate
	//Desc
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);


	// LessThanEqual
	// It will filter the data only one column
	// It applies <= operator in the JPQL and SQL Query
	//JPQL -> Select * from person where age<=?1
	public List<Person> findByAgeLessThanEqual(Integer age);



	// LikeSerach
	// We need to manually append % symbol before calling this api
	// select * from person where firstName like '%?%'
	public List<Person> findByFirstNameLike(String firstName);


	//JPQL -> Select * from person where last_name=?1 and age<=?2
	//findBy
	//LastName -> ColumnName1
	//And -> keyword1
	//Age -> ColumnName2
	//LessThanEqual -> Keyword2
	//select * from person where lastname=?1 and age <=?2
	//select * from person where lastname='ramu'
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int Age);



	//JPQL -> Select * from person where createdate<=?1 and createddate>=?2
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);

	//End of of Derived Methods Section

	//Start of Named Query Section





	public List<Object> givefewcolumns(String lastName);




	//End of Named Query Section

	//Pagination Section

//Pagable Object is Optional in every method.

	List<Person> findByLastName(String lastName, Pageable pageable);
	//seelct * fromo person where lastName=?
	//and rownum>=paable.halfset and rownum<=pageable.paesize

}
