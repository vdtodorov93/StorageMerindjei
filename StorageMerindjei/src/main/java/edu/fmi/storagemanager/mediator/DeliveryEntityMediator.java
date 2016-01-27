package edu.fmi.storagemanager.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.controller.api.model.DeliveryEntityDto;
import edu.fmi.storagemanager.db.dao.DeliveryEntityRepository;
import edu.fmi.storagemanager.db.dao.MaterialRepository;
import edu.fmi.storagemanager.db.model.DeliveryEntity;

@Service
public class DeliveryEntityMediator {
	
	@Autowired
	private DeliveryEntityRepository deliveryEntityRepository;

	@Autowired
	private MaterialRepository materialRepository;
	
	public int getTotalAmountOfDeliveredMaterialByName(String materialName) {
		return deliveryEntityRepository.getTotalAmountOfDeliveredMaterialByName(materialName);
	}
	
	public DeliveryEntity mapFromDto(DeliveryEntityDto dto) {
		DeliveryEntity result = new DeliveryEntity();
		result.setColor(dto.getColor());
		result.setMaterialForm(dto.getMaterialForm());
		result.setPrice(dto.getPrice());
		result.setSize(dto.getSize());
		result.setSizeMetric(dto.getSizeMetric());
		result.setType(dto.getType());
		result.setMaterial(materialRepository.findByName(dto.getMaterial()));
		result.setQuantity(dto.getQuantity());
		return result;
	}
	
	public DeliveryEntityDto mapToDto(DeliveryEntity model) {
		DeliveryEntityDto dto = new DeliveryEntityDto();
		dto.setColor(model.getColor());
		dto.setMaterialForm(model.getMaterialForm());
		dto.setPrice(model.getPrice());
		dto.setSize(model.getSize());
		dto.setSizeMetric(model.getSizeMetric());
		dto.setType(model.getType());
		dto.setMaterial(model.getMaterial().getName());
		dto.setQuantity(model.getQuantity());
		return dto;
	}
}
