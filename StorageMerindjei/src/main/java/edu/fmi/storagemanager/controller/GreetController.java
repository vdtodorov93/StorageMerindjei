package edu.fmi.storagemanager.controller;

import edu.fmi.storagemanager.db.model.Asd;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GreetController {

    @RequestMapping("/greet")
    public List<Asd> getGreets() {
        List<Asd> events = new ArrayList<Asd>();
        Asd event1 = new Asd("asd");
        
        events.add(event1);
        
        Asd event2 = new Asd("sdsdsds");
        
        events.add(event2);
        
        return events;
    }
    
}