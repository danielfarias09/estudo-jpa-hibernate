package com.danielfarias.EstudoJpaHibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfarias.EstudoJpaHibernate.model.Pet;
import com.danielfarias.EstudoJpaHibernate.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping
	public ResponseEntity<List<Pet>> getAll(){
		List<Pet> pets = petService.getAll();
		return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		return petService.getById(id)
				.map(estabelecimento -> ResponseEntity.ok().body(estabelecimento))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pet> salvar(@RequestBody Pet pet){
		pet = petService.save(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}

}
