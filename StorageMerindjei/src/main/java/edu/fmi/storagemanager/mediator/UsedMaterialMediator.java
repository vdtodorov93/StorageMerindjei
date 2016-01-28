package edu.fmi.storagemanager.mediator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.fmi.storagemanager.ConstraintViolationException;
import edu.fmi.storagemanager.db.dao.MaterialRepository;
import edu.fmi.storagemanager.db.dao.UsedMaterialRepository;
import edu.fmi.storagemanager.db.model.Material;
import edu.fmi.storagemanager.db.model.UsedMaterial;

@Service
public class UsedMaterialMediator {

	@Autowired
	private UsedMaterialRepository usedMaterialRepository;

	@Autowired
	private MaterialRepository materialRepository;

	@Transactional
	public void useMaterial(Material material, BigDecimal quantity) {
		material = materialRepository.findByName(material.getName());
		BigDecimal currentQuantity = material.getQuantity();
		if (currentQuantity.compareTo(quantity) < 0) {
			throw new ConstraintViolationException(String.format("Not enough " + material.getName() + " requested "
					+ quantity + " , current amount: " + currentQuantity));
		}

		UsedMaterial usedMaterial = new UsedMaterial();
		usedMaterial.setMaterial(material);
		usedMaterial.setQuantity(quantity);
		usedMaterialRepository.save(usedMaterial);

		material.setQuantity(currentQuantity.subtract(quantity));
		materialRepository.save(material);
	}
}
