package edu.fmi.storagemanager.db.dao;

import org.springframework.data.repository.CrudRepository;

import edu.fmi.storagemanager.db.model.DeliveryEntity;

public interface DeliveryEntityRepository extends CrudRepository<DeliveryEntity, Long> {

}