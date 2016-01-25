package edu.fmi.storagemanager.db.dao;

import org.springframework.data.repository.CrudRepository;

import edu.fmi.storagemanager.db.model.Asd;

public interface AsdRepository extends CrudRepository<Asd, Long>{
	
}