package com.ty.hospita_app.duo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospita_app.entity.Person;

public class PersonDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner scanner=new Scanner(System.in);
	public Person savePerson(Person person) {
		System.out.println("Enter name");
		String name=scanner.next();
		System.out.println("Enter blood group");
		String bloodGroup=scanner.next();
		System.out.println("Enter accompany name");
		String accompanyName=scanner.next();
		System.out.println("Enter accompany relation");
		String accompanyRelation=scanner.next();
		System.out.println("Enter number of visits");
		int noOfisits=scanner.nextInt();
		person=new Person(name, bloodGroup, accompanyName, accompanyRelation, noOfisits,null);
		//System.out.println(person.getEncounters());
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
		
		
	}
	public Person findPerson(int id) {
		return entityManager.find(Person.class,id);
	}

}
