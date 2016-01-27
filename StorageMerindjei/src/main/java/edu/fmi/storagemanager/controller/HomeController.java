package edu.fmi.storagemanager.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fmi.storagemanager.db.dao.DeliveryEntityRepository;
import edu.fmi.storagemanager.db.dao.DeliveryRepository;
import edu.fmi.storagemanager.db.dao.MaterialRepository;
import edu.fmi.storagemanager.db.dao.UsedMaterialRepository;
import edu.fmi.storagemanager.db.dao.VendorRepository;
import edu.fmi.storagemanager.db.model.Delivery;
import edu.fmi.storagemanager.db.model.DeliveryEntity;
import edu.fmi.storagemanager.db.model.Material;
import edu.fmi.storagemanager.db.model.UsedMaterial;
import edu.fmi.storagemanager.db.model.Vendor;

@Controller
public class HomeController {

	@Autowired
	MaterialRepository materialRepository;

	@Autowired
	DeliveryRepository deliveryRepository;

	@Autowired
	DeliveryEntityRepository deliveryEntityRepository;

	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	UsedMaterialRepository usedMaterialRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String returnIndex(Model model) {
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		List<UsedMaterial> um = usedMaterialRepository.findByMaterialName("Prezervativi");
		System.out.println("INDEX");
		Material material = materialRepository.findByName("Prezervativi");
		Vendor durex = vendorRepository.findByName("Durex");

		//Material material = materialRepository.save(new Material("Prezervativi"));
		//Vendor durex = vendorRepository.save(new Vendor("Durex"));

		DeliveryEntity d1 = new DeliveryEntity();
		d1.setColor("black");
		d1.setMaterial(material);
		d1.setMaterialForm("roler");
		d1.setPrice(BigDecimal.valueOf(3.34));

		DeliveryEntity d2 = new DeliveryEntity();
		d2.setColor("red");
		d2.setMaterial(material);
		d2.setMaterialForm("asd");
		d2.setPrice(BigDecimal.valueOf(2.22));
		d2.setSize(BigDecimal.TEN);
		d2.setSizeMetric("santa");

		Delivery newDelivery = new Delivery();
		newDelivery.setVendor(durex);
		newDelivery.addDeliveryEntity(d1);
		newDelivery.addDeliveryEntity(d2);
		deliveryRepository.save(newDelivery);
		// newDelivery = deliveryRepository.save(newDelivery);
		//
		// DeliveryEntity entity = new DeliveryEntity();
		// entity.setDelivery(newDelivery);
		//
		// entity.setMaterial(material);
		// entity.setPrice(BigDecimal.TEN);
		// deliveryEntityRepository.save(entity);
		// a.setName("Prezervativi");
		// materialRepository.save(a);
		return "index";
	}
}
