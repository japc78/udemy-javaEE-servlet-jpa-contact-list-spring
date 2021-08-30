package com.japcdev.contactbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.japcdev.contactbook.model.Contact;
import com.japcdev.contactbook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public boolean newContact(Contact contact) {
		if(contactRepository.getContactEmail(contact.getEmail()) == null) {
			contactRepository.addContact(contact);
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getContactList() {
		return contactRepository.getContactList();
	}

	@Override
	public boolean deleteContact(int id) {
		if(contactRepository.getContactId(id) != null) {
			contactRepository.deleteContact(id);
			return true;
		}
		return false;
	}
}
