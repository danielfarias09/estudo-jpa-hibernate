package com.danielfarias.EstudoJpaHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielfarias.EstudoJpaHibernate.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
