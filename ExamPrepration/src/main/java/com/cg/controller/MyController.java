package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Person;
import com.cg.exception.EmptyRecordException;
import com.cg.exception.IdAlreadyExists;
import com.cg.exception.IdNotFoundException;
import com.cg.service.IService;

@RestController
public class MyController {

	@Autowired
	IService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/createNewPerson")
	public Person createNewPerson(@Valid @RequestBody Person person) throws IdAlreadyExists {
		return service.createNewPerson(person);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/search/{id}")
	public Person search(@PathVariable int id) throws IdNotFoundException {
		return service.search(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/searchAll")
	public List<Person> searchAll() throws EmptyRecordException {
		return service.searchAll();
	}
}
