package edu.fmi.storagemanager.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnIndex(Model model) {
        return "index";
    }    
    
    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public String returnDeliveries(Model model) {
        return "deliveries";
    }
    
    @RequestMapping(value = "/materials", method = RequestMethod.GET)
    public String returnMaterials(Model model) {
        return "materials";
    }
    
    @RequestMapping(value = "/vendors", method = RequestMethod.GET)
    public String returnVendors(Model model) {
        return "vendors";
    }
    
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String returnChart(Model model) {
        return "chart";
    }
}
