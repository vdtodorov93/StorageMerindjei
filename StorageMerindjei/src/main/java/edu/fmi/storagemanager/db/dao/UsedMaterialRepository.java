package edu.fmi.storagemanager.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.fmi.storagemanager.db.model.UsedMaterial;

public interface UsedMaterialRepository extends CrudRepository<UsedMaterial, Long> {
	@Query("SELECT um FROM UsedMaterial um where um.material.name = :name")
	List<UsedMaterial> findByMaterialName(@Param("name") String name);
	
	@Query("SELECT SUM(um.quantity) FROM UsedMaterial um where um.material.name = :name")
	int usedAmountByName(@Param("name") String name);
}
