package edu.fmi.storagemanager.mediator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.controller.api.model.DeliveryDto;
import edu.fmi.storagemanager.controller.api.model.DeliveryEntityDto;
import edu.fmi.storagemanager.controller.api.model.VendorDto;
import edu.fmi.storagemanager.db.dao.DeliveryRepository;
import edu.fmi.storagemanager.db.model.Delivery;
import edu.fmi.storagemanager.db.model.DeliveryEntity;
import edu.fmi.storagemanager.db.model.Vendor;

@Service
public class DeliveryMediator {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private DeliveryEntityMediator deliveryEntityMediator;
	
	@Autowired
	private VendorMediator vendorMediator;
	
	public Delivery addDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}
	
	public Iterable<Delivery> findAllDeliveries() {
		return deliveryRepository.findAll();
	}

	public Iterable<Delivery> getDeliveriesFromVendor(String vendor) {
		return deliveryRepository.findByVendor(vendor);
	}
	
	public Delivery mapFromDto(DeliveryDto dto) {
		Delivery result = new Delivery();
		result.setDeliveryDate(dto.getDeliveryDate());
		result.setVendor(vendorMediator.findByName(dto.getVendor()));
		for(DeliveryEntityDto dtoEntity: dto.getDeliveryEntities()) {
			result.addDeliveryEntity(deliveryEntityMediator.mapFromDto(dtoEntity));
		}
		
		return result;		
	}
	
	public DeliveryDto mapToDto(Delivery delivery) {
		DeliveryDto dto = new DeliveryDto();
		dto.setDeliveryDate(delivery.getDeliveryDate());
		dto.setVendor(delivery.getVendor().getName());
		List<DeliveryEntityDto> entityDtos = new ArrayList<>();
		for(DeliveryEntity deliveryEntity: delivery.getDeliveryEntities()) {
			entityDtos.add(deliveryEntityMediator.mapToDto(deliveryEntity));
		}
		dto.setDeliveryEntities(entityDtos);
		
		return dto;		
	}
	
	public List<DeliveryDto> mapListFromModel(List<Delivery> source) {
		List<DeliveryDto> result = new ArrayList<>();
		for(Delivery d: source) {
			result.add(mapToDto(d));
		}
		
		return result;
	}
	
	
}