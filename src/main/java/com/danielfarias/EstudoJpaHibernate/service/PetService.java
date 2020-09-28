package com.danielfarias.EstudoJpaHibernate.service;

import java.util.List;
import java.util.Optional;

import com.danielfarias.EstudoJpaHibernate.model.Pet;

public interface PetService {
	
	Optional<Pet> getById(Long id);
	
	List<Pet> getAll();
	
	Pet save(Pet pet);

}
