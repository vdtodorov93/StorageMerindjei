package edu.fmi.storagemanager.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fmi.storagemanager.controller.api.model.DeliveryDto;
import edu.fmi.storagemanager.db.model.Delivery;
import edu.fmi.storagemanager.mediator.DeliveryMediator;
import edu.fmi.storagemanager.util.CommonUtil;


@RestController
public class DeliveryController {

	@Autowired
	private DeliveryMediator deliveryMediator;

	@RequestMapping(value = "/api/deliveries", method = RequestMethod.GET)
	public List<DeliveryDto> getDeliveries() {
		List<Delivery> deliveries = CommonUtil.iterableToList(deliveryMediator.findAllDeliveries());
		return deliveryMediator.mapListFromModel(deliveries);
	}

	@RequestMapping(value = "/api/deliveries/{vendor}", method = RequestMethod.GET)
	public List<DeliveryDto> findDeliveriesFromVendor(@PathVariable String vendor) {
		List<Delivery> deliveries = CommonUtil.iterableToList(deliveryMediator.getDeliveriesFromVendor(vendor));
		return deliveryMediator.mapListFromModel(deliveries);
	}

	@RequestMapping(value = "/api/deliveries", method = RequestMethod.POST)
	public DeliveryDto createDelivery(@RequestBody DeliveryDto deliveryDto) {
		System.out.println(deliveryDto);
		Delivery delivery = deliveryMediator.mapFromDto(deliveryDto);
		delivery = deliveryMediator.addDelivery(delivery);
		return deliveryMediator.mapToDto(delivery);
	}
}