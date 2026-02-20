package com.Service;

import com.Entity.School;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Service {
	private static EntityManagerFactory factory= Persistence.createEntityManagerFactory("akshansh");
	private static EntityManager manager= factory.createEntityManager();
	
	public void save(School school) {
		manager.getTransaction().begin();
		manager.persist(school);
		manager.getTransaction().commit();
		System.out.println("School saved successfully!");
	}
	
	public <T> T find(Class<T> cls, int id) {
		return manager.find(cls, id);
	}
	
	public void update(School school) {
		manager.getTransaction().begin();
		manager.merge(school);
		manager.getTransaction().commit();
		System.out.println("School Updated successfully!");
		
	}
	
	public void remove(School school) {
		manager.getTransaction().begin();
		manager.remove(school);
		manager.getTransaction().commit();
		System.out.println("School Removed successfully!");
	}
}
	
