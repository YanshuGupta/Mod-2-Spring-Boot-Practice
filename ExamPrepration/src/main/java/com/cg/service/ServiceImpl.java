package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Person;
import com.cg.dao.IRepository;
import com.cg.exception.EmptyRecordException;
import com.cg.exception.IdAlreadyExists;
import com.cg.exception.IdNotFoundException;

@Service
public class ServiceImpl implements IService {

	@Autowired
	IRepository repo;
	
	/* (non-Javadoc)
	 * @see com.cg.service.IService#search(int)
	 */
	@Override
	public Person search(int id) throws IdNotFoundException {
		Person person = repo.search(id);
		if(person==null) {
			throw new IdNotFoundException("ID not found");
		}
		return person;
	}
	
	/* (non-Javadoc)
	 * @see com.cg.service.IService#searchAll()
	 */
	@Override
	public List<Person> searchAll() throws EmptyRecordException {
		List<Person> persons = repo.searchAll();
		if(persons == null) {
			throw new EmptyRecordException("There is no record in database");
		}
		return persons;
	}
	
	/* (non-Javadoc)
	 * @see com.cg.service.IService#createNewPerson(com.cg.beans.Person)
	 */
	@Override
	public Person createNewPerson(Person person) throws IdAlreadyExists {
		Person result = repo.createNewPerson(person);
		if(result == null) {
			throw new IdAlreadyExists("Id already exists with this key");
		}
		return result;
	}
}
