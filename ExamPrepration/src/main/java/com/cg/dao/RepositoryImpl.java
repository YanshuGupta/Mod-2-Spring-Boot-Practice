package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.beans.Person;

@Repository
public class RepositoryImpl implements IRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.cg.dao.IRepository#search(int)
	 */
	@Override
	public Person search(int id) {
		return entityManager.find(Person.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.cg.dao.IRepository#createNewPerson(com.cg.beans.Person)
	 */
	@Override
	@Transactional
	public Person createNewPerson(Person person) {
		if(search(person.getId()) == null) {
			entityManager.persist(person);
			return search(person.getId());
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cg.dao.IRepository#searchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> searchAll(){
		Query query = entityManager.createQuery("Select p from Person p");
		return query.getResultList();
	}
	
}
