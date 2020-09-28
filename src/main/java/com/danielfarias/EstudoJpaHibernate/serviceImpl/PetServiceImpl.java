package com.danielfarias.EstudoJpaHibernate.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielfarias.EstudoJpaHibernate.model.Pet;
import com.danielfarias.EstudoJpaHibernate.repository.PetRepository;
import com.danielfarias.EstudoJpaHibernate.service.PetService;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetRepository petRepository;

	@Override
	public Optional<Pet> getById(Long id) {
		return petRepository.findById(id);
	}

	@Override
	public List<Pet> getAll() {
		return petRepository.findAll();
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

}
