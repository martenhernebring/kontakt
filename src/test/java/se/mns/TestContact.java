package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestContact {

	Contact contact= new Contact("Naoya", "naoya@testemail.com", "07342567");
	
	

	@Test
	public void testEqualsName() {
		assertEquals("Naoya", contact.getName());

	}

	@Test
	public void testSetName() {
		contact.setName(" Suzana ");
		assertEquals("Suzana", contact.getName());
	}


	@Test
	public void testGetEmail() {
		assertEquals("naoya@testemail.com", contact.getEmail());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("07342567", contact.getPhoneNumber());
	}

	@Test
	public void testSetEmail() {
		contact.setEmail("suzana@hotmail.se");
		assertEquals("suzana@hotmail.se", contact.getEmail());

	}

	@Test
	public void testSetPhoneNumber() {
		contact.setPhoneNumber("09356487");
		assertEquals("09356487", contact.getPhoneNumber());


	}	

	
}
