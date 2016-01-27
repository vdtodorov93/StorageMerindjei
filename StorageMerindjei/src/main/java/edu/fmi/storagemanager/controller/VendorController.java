package edu.fmi.storagemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fmi.storagemanager.db.model.Vendor;
import edu.fmi.storagemanager.mediator.VendorMediator;
import edu.fmi.storagemanager.util.CommonUtil;


@RestController
public class VendorController {

	@Autowired
	private VendorMediator vendorMediator;

	@RequestMapping(value = "/api/vendors", method = RequestMethod.GET)
	public List<Vendor> getVendors() {
		List<Vendor> vendors = CommonUtil.iterableToList(vendorMediator.findAllVendors());
		return vendors;
	}

	@RequestMapping(value = "/api/vendors/{name}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendor(@PathVariable String name) {
		Vendor vendor = vendorMediator.findByName(name);
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/vendors", method = RequestMethod.POST)
	public Vendor createVendor(@RequestBody Vendor vendor) {
		System.out.println(vendor);
		vendor = vendorMediator.addVendor(vendor);
		return vendor;
	}
}