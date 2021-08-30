package com.japcdev.contactbook.repository;

import java.util.List;

import com.japcdev.contactbook.model.Contact;

public interface ContactRepository {
	void addContact(Contact contact);
	Contact getContactEmail(String email);
	Contact getContactId (int id);
	void deleteContact (int id);
	List<Contact> getContactList();
}
