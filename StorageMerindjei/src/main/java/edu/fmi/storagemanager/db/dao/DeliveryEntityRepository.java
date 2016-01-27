package edu.fmi.storagemanager.db.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.fmi.storagemanager.db.model.DeliveryEntity;

public interface DeliveryEntityRepository extends CrudRepository<DeliveryEntity, Long> {
	
	@Query("SELECT SUM(de.quantity) FROM DeliveryEntity de WHERE de.material.name = :materialName")
	int getTotalAmountOfDeliveredMaterialByName(@Param("materialName") String materialName);
}