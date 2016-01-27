package edu.fmi.storagemanager.mediator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.controller.api.model.VendorDto;
import edu.fmi.storagemanager.db.dao.VendorRepository;
import edu.fmi.storagemanager.db.model.Vendor;

@Service
public class VendorMediator {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	public Vendor addVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	public Vendor addVendor(String name, String phoneNumber, String address, String bankAccount) {
		Vendor vendor = new Vendor();
		vendor.setAddress(address);
		vendor.setBankAccount(bankAccount);
		vendor.setName(name);
		vendor.setPhoneNumber(phoneNumber);
		return vendorRepository.save(vendor);
	}
	
	public Iterable<Vendor> findAllVendors() {
		return vendorRepository.findAll();
	}
	
	public Vendor findByName(String name) {
		return vendorRepository.findByName(name);
	}
	
	public Vendor mapFromDto(VendorDto dto) {
		Vendor result = new Vendor();
		result.setAddress(dto.getAddress());
		result.setBankAccount(dto.getBankAccount());
		result.setName(dto.getName());
		result.setPhoneNumber(dto.getPhoneNumber());
		
		return result;
	}
	
	public VendorDto mapToDto(Vendor vendor) {
		VendorDto dto = new VendorDto();
		dto.setAddress(vendor.getAddress());
		dto.setBankAccount(vendor.getBankAccount());
		dto.setName(vendor.getName());
		dto.setPhoneNumber(vendor.getPhoneNumber());
		
		return dto;
	}
	
	public List<VendorDto> mapListFromModel(List<Vendor> source) {
		List<VendorDto> result = new ArrayList<>();
		for(Vendor v: source) {
			result.add(mapToDto(v));
		}
		return result;
	}

}
