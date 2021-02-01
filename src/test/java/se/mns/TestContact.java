package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestContact {

	Contact contact= new Contact("Naoya", "naoya@testemail.com", "07342567");
	
	@Test
	public void testString() {
		
		assertTrue(contact.getName() instanceof String);
	}
	
	@Test
	public void testEqualsName() {
		assertEquals("Naoya", contact.getName());
		
	}
	
	@Test
	public void testEqualsNameWithSpaces() {
		contact.setName(" Naoya " );
		assertEquals("Naoya", contact.getName());
		
	}
}
