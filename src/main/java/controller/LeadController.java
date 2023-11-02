package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;


@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;//we write this because with *component that *Autowired will work  
	
	@Autowired
	private LeadService leadService;
	
	//update
	@RequestMapping("/viewLeadPage") 
	public String viewCreateLeadPage() {
		return "create_lead";
		
	}
	
	//save to database
	@RequestMapping (value = "/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		          
		emailService.sendSimpleMail(l.getEmail(),"Text", "Test Email"); //where to send the mail
		model.addAttribute("msg", "Lead is saved");
		return "create_lead";
	}
	
	//seeing the data in a form table in web
	@RequestMapping("/listall")           
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	//Delete
	@RequestMapping("/deleteLead")
	public String deleteLead(@RequestParam("id") long id, ModelMap model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
	//Update
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id") long id, ModelMap model ) {
		Lead lead = leadService.getById(id);
		model.addAttribute("lead", lead);
		return"update_lead";
	}
	@RequestMapping(value = "/updateOneLead" , method = RequestMethod.POST)
	public String updateOneLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	
	}
}
