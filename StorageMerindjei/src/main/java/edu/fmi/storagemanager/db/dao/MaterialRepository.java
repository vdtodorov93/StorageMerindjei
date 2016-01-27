package edu.fmi.storagemanager.db.dao;

import org.springframework.data.repository.CrudRepository;

import edu.fmi.storagemanager.db.model.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {
	Material findByName(String name);
}