package se.mns;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
	
	private List<Contact> contacts;
	
	public ContactBook() {
		contacts = new ArrayList<>();
	}
	
	public void add(Contact contact) {
		contacts.add(contact);
	}
	
	public void remove(Contact contact) {
		contacts.remove(contact);
	}
	
	//It is okay that this only responds "Found" and "Not found"?
	public boolean contains(Contact contact) {
		for(int i = 0; i<contacts.size();i++) {
			if(contacts.get(i).equals(contact)) {
				return true;
			}
		}
		return false;
	}
	
	/* ToDo
	public void edit(Contact c) {
		if(!findContact(c)) {
			throw new IllegalArgumentException("The contact is not found.");
		}
		
		c.setName();
		c.setTelephoneNumber();
		c.setEmail();
		
	}*/

	
}
