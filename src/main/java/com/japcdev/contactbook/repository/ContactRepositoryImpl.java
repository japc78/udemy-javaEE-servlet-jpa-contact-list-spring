package com.japcdev.contactbook.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.japcdev.contactbook.model.Contact;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
	}

	@Override
	public Contact getContactEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> getContactList() {
		// TODO Auto-generated method stub
		return null;
	}

}
