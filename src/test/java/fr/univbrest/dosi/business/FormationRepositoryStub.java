package fr.univbrest.dosi.business;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

public class FormationRepositoryStub implements FormationRepository {
	
	private List<Formation> donnees;
	
	FormationRepositoryStub() {
		this.donnees = Lists.newArrayList();
	}

	FormationRepositoryStub(List<Formation> setUpData) {
		this.donnees = Lists.newArrayList(setUpData);
	}

	@Override
	public <S extends Formation> S save(S entity) {
		this.donnees.add(entity);
		
		return entity;
	}

	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<Formation> findAll() {
		return this.donnees;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(Formation entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Formation> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Formation findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Formation findByCodeFormation(String codeFormation) {
		return this.donnees.stream().filter(formation -> formation.getCodeFormation().equals(codeFormation)).findFirst().orElse(null);
	}

}
