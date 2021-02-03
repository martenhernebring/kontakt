package se.mns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a basic ContactBook class which adds, removes and searches a contact.
 *  
 * @author naoyairikura
 *
 */
public class ContactBook {
	
	private List<Contact> contacts;
	
	public ContactBook() {
		contacts = new ArrayList<>();
	}
	
	/**
	 * Returns the list
	 * @return List<Contact> 
	 */
	public List<Contact> getContacts() {
		return Collections.unmodifiableList(contacts);
	}
	
	/**
	 * Adds a contact to the list.
	 * @param contact This is the contact which is added
	 */
	public void add(Contact contact) {
		contacts.add(contact);
	}
	
	/**
	 * Removes a contact from the list.
	 * Throws an exception if the name cannot be found. 
	 * @param name This is the name of the contact which is removed
	 */
	public void remove(String name) {
		for(int i = 0; i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
			} else {
				throw new IllegalArgumentException();
			}	
		}
	}
	
	/**
	 * Searches if the list contains a contact.
	 * @param name This is the name of the contact which is searched
	 * @return
	 */
	public boolean contains(String name) {
		for(int i = 0; i<contacts.size();i++) {
			if(contacts.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
}
