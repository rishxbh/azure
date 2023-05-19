package com.azure.assignment.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azure.assignment.data.PersonRepo;
import com.azure.assignment.model.Person;


@RestController
public class Controller {
	
	@Autowired
	private PersonRepo repo;
	
	@GetMapping("/get")
	public ResponseEntity<List<Person>> get() {
		List<Person> list = (List<Person>) repo.findAll();
		return ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> add(@RequestBody Person person) {
		repo.save(person);
		return ResponseEntity.of(Optional.of("saved"));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> del(@PathVariable("id") int id) {
		repo.deleteById(id);
		return ResponseEntity.of(Optional.of("deleted"));
	}
	
}
