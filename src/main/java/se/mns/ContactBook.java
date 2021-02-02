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
	
	
	public void remove(String name) {
		for(int i = 0; i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
			} else {
				throw new IllegalArgumentException();
			}	
		}
	}
	
	public boolean contains(String name) {
		for(int i = 0; i<contacts.size();i++) {
			if(contacts.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
}
