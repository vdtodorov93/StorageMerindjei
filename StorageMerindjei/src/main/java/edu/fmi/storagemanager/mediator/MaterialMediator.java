package edu.fmi.storagemanager.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.db.dao.MaterialRepository;
import edu.fmi.storagemanager.db.dao.UsedMaterialRepository;
import edu.fmi.storagemanager.db.model.Material;

@Service
public class MaterialMediator {
	
	@Autowired
	private DeliveryEntityMediator deliveryEntityMediator;
	
	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private UsedMaterialRepository usedMaterialRepository;
	
	public int currentQuantityOfMaterial(String material) {
		return deliveryEntityMediator.getTotalAmountOfDeliveredMaterialByName(material) - usedMaterialRepository.usedAmountByName(material);
	}
	
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
}
