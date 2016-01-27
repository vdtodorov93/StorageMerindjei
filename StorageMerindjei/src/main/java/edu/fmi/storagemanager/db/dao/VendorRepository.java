package edu.fmi.storagemanager.db.dao;

import org.springframework.data.repository.CrudRepository;

import edu.fmi.storagemanager.db.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
	Vendor findByName(String name);
}