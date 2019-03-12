package com.cg.service;

import java.util.List;

import com.cg.beans.Person;
import com.cg.exception.EmptyRecordException;
import com.cg.exception.IdAlreadyExists;
import com.cg.exception.IdNotFoundException;

public interface IService {

	Person search(int id) throws IdNotFoundException;

	List<Person> searchAll() throws EmptyRecordException;

	Person createNewPerson(Person person) throws IdAlreadyExists;

}