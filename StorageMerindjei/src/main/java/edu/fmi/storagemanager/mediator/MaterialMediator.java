package edu.fmi.storagemanager.mediator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.db.dao.MaterialRepository;
import edu.fmi.storagemanager.db.model.Material;

@Service
public class MaterialMediator {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public Material addMaterial(Material material) {
		return materialRepository.save(material);
	}
	
	public Material addMaterial(String name) {
		return materialRepository.save(new Material(name));
	}
	
	public Material findByName(String name) {
		return materialRepository.findByName(name);
	}
	
	public Iterable<Material> findAllMaterials() {
		return materialRepository.findAll();
	}
	
	public void addQuantity(Material material, BigDecimal quantity) {
		material = materialRepository.findByName(material.getName());
		material.setQuantity(material.getQuantity().add(quantity));
		materialRepository.save(material);
	}
}
