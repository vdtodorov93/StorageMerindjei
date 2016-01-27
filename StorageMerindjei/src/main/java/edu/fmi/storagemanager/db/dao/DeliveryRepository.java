package edu.fmi.storagemanager.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.fmi.storagemanager.db.model.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery, Long>{
	@Query("SELECT d FROM Delivery d WHERE d.vendor.name = :vendorName")
	List<Delivery> findByVendor(@Param("vendorName") String vendorName);
}