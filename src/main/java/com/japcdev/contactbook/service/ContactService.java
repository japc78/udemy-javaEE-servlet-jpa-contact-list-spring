package com.japcdev.contactbook.service;

import java.util.List;

import com.japcdev.contactbook.model.Contact;

public interface ContactService {
	boolean newContact(Contact contact);
	List<Contact> getContactList();
	boolean deleteContact(int id);
}
