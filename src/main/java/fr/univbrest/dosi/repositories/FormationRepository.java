package fr.univbrest.dosi.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Formation;

public interface FormationRepository extends CrudRepository<Formation, Long> {

	Formation findByCodeFormation(String codeFormation);

}
