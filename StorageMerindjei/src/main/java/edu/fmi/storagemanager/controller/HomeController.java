package edu.fmi.storagemanager.controller;

import edu.fmi.storagemanager.db.model.Asd;
import edu.fmi.storagemanager.mediator.AsdMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	AsdMediator asdMediator;
	   
    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String returnIndex(Model model) {
        //Asd asd = asdMediator.addAsdWithName("ASDASD");
        //System.out.println(asd.getName());
        model.addAttribute("asd", "asdasd");
        return "index";
    }
}
