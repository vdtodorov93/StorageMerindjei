package edu.fmi.storagemanager.mediator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.ConstraintViolationException;
import edu.fmi.storagemanager.db.dao.UsedMaterialRepository;
import edu.fmi.storagemanager.db.model.Material;
import edu.fmi.storagemanager.db.model.UsedMaterial;

@Service
public class UsedMaterialMediator {

	@Autowired
	private UsedMaterialRepository usedMaterialRepository;

	@Autowired
	private MaterialMediator materialMediator;

	public void useMaterial(Material material, BigDecimal quantity) {
		int currentAmount = materialMediator.currentQuantityOfMaterial(material.getName());
		if (BigDecimal.valueOf(currentAmount).compareTo(quantity) < 0) {
			throw new ConstraintViolationException(String.format("Not enough {0}. requested {1}, current amount: {2}",
					material.getName(), quantity, currentAmount));
		}
		UsedMaterial usedMaterial = new UsedMaterial();
		usedMaterial.setMaterial(material);
		usedMaterial.setQuantity(quantity);
		usedMaterialRepository.save(usedMaterial);
	}
}
