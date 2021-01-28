package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestName {

	Name name;
	
	@Test
	public void testString() {
		name = new Name("Naoya");
		assertTrue(name.getName() instanceof String);
	}
	
	@Test
	public void testNoNumbersAllowed() {
		name = new Name("Na0ya");
		
	}
	
	@Test
	public void testGetNameWithSpaces() {
		name = new Name(" Naoya ");
		assertEquals("Naoya", name.getName());
		
	}
}
