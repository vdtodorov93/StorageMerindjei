package edu.fmi.storagemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fmi.storagemanager.db.model.Asd;
import edu.fmi.storagemanager.mediator.AsdMediator;

@Controller
public class HomeController {
	
	@Autowired
	AsdMediator asdMediator;
	
	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	public String sayHello(Model model) {
		Asd asd = asdMediator.addAsdWithName("ASDASD");
		System.out.println(asd.getName());
		return "hello.jsp";
	}
}
