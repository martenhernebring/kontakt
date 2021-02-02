package se.mns;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestContactBook {

	private ContactBook contactBook;
	private Contact contact;

	public TestContactBook() {
		contactBook =  new ContactBook();
		contact = new Contact("TestName", "Test@email", "0987654321");
		contactBook.add(contact);
	}
	
	@Test
	public void testGetContacts() {
		assertEquals("TestName", contactBook.getContacts().get(0).getName());
	}
 
	@Test
	public void testAdd() {
		Contact contact = new Contact("Naoya", "naoya@email.com", "0123456789");
		contactBook.add(contact);
		assertEquals("Naoya", contactBook.getContacts().get(1).getName());
		
	}

	@Test
	public void testRemove() {
		contactBook.remove("TestName");
		assertTrue(contactBook.getContacts().size() == 0);
	}
	
	@Test
	public void testRemoveThrowsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			contactBook.remove("NonExistingName");
		});
	}
	
	//testar om contains() fungerar
	@Test
	public void testContainsTrue() {
		assertTrue(contactBook.contains("TestName"));
	}
	
	@Test
	public void testContainsFalse() {
		assertFalse(contactBook.contains("NonExistingName"));
	}
	
	
}
