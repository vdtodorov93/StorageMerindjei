package edu.fmi.storagemanager.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fmi.storagemanager.db.model.Material;
import edu.fmi.storagemanager.mediator.MaterialMediator;
import edu.fmi.storagemanager.util.CommonUtil;

@RestController
public class MaterialController {

	@Autowired
	private MaterialMediator materialMediator;

	@RequestMapping(value = "/api/materials", method = RequestMethod.GET)
	public List<Material> getMaterials() {
		List<Material> materials = CommonUtil.iterableToList(materialMediator.findAllMaterials());
		return materials;
	}

	@RequestMapping(value = "/api/materials/{name}", method = RequestMethod.GET)
	public ResponseEntity<Material> getMaterial(@PathVariable String name) {
		Material material = materialMediator.findByName(name);
		return new ResponseEntity<Material>(material, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/materials", method = RequestMethod.POST)
	public Material createMaterial(@RequestBody Material material) {
		System.out.println(material);
		material = materialMediator.addMaterial(material);
		return material;
	}
}