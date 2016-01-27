package edu.fmi.storagemanager.db.dao;

import org.springframework.data.repository.CrudRepository;

import edu.fmi.storagemanager.db.model.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery, Long>{
	
}