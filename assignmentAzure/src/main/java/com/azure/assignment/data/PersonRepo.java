package com.azure.assignment.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azure.assignment.model.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {
}
