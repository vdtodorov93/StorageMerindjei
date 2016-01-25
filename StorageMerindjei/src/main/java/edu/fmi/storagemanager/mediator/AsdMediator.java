package edu.fmi.storagemanager.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fmi.storagemanager.db.dao.AsdRepository;
import edu.fmi.storagemanager.db.model.Asd;

@Service
public class AsdMediator {
	@Autowired
	private AsdRepository asdRepository;
	
	public Asd addAsdWithName(String name) {
		Asd asd = new Asd(name);
		asd = asdRepository.save(asd);
		return asd;
	}
}
