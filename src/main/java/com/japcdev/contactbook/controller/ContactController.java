package com.japcdev.contactbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.japcdev.contactbook.model.Contact;
import com.japcdev.contactbook.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	ContactService contactService;
	
	@PostMapping("add")
	public String newContact( 
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("phoneNumber") int phoneNumber) {
		
		Contact contact = new Contact(name, email, phoneNumber);
		
		if (!contactService.newContact(contact)) {
			return "repeat";
		}

		return "index";
	}
	
	
	@GetMapping("getList")
	public String getContactList(HttpServletRequest request) {
		request.setAttribute("contacts", contactService.getContactList());
		
		return "contact-list";
	}
	
	@GetMapping(value="delete")
	public String deleteContact(@RequestParam("id") int id) {
		if(!contactService.deleteContact(id)) {
			return "no-exists";
		}
		return "forward:/getList";	
	}
}
