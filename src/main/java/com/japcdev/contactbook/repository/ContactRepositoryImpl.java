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
		String sql = "INSERT INTO contacts (name, email, phoneNumber) VALUE(?,?,?)";
		template.update(sql, 
				contact.getName(), 
				contact.getEmail(), 
				contact.getPhoneNumber());		
	}

	@Override
	public Contact getContactEmail(String email) {
		String sql="SELECT * FROM contacts WHERE email = ?";
		List<Contact> contacts= template.query(sql, 
			  (resultSet, row)-> new Contact(
					  resultSet.getInt("idContacto"),
					  resultSet.getString("nombre"),
					  resultSet.getString("email"),
					  resultSet.getInt("telefono")),
			  email);
		return contacts.size() > 0 ? contacts.get(0) : null;
	}

	@Override
	public Contact getContactId(int id) {
		String sql="SELECT * FROM contacts WHERE id = ?";
		List<Contact> contacts= template.query(sql, 
			  (resultSet, row)-> new Contact(
					  resultSet.getInt("idContacto"),
					  resultSet.getString("nombre"),
					  resultSet.getString("email"),
					  resultSet.getInt("telefono")),
			  id);
		return contacts.size() >0 ? contacts.get(0) : null;
	}

	@Override
	public void deleteContact(int id) {
		String sql = "DELETE FROM contacts WHERE id = ?";
		template.update(sql, id);
	}

	@Override
	public List<Contact> getContactList() {
		String sql = "SELECT * FROM contacts";

		return template.query(sql, (resultSet, row)->new Contact(
				resultSet.getInt("id"),
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getInt("phoneNumber")
				));		 
	}

}
