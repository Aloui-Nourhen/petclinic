package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NamedEntityTest {

	@Test
	void testGetName() {
		NamedEntity entity = new NamedEntity();
		entity.setName("Test Name");
		assertEquals("Test Name", entity.getName());
	}

	@Test
	void testSetName() {
		NamedEntity entity = new NamedEntity();
		entity.setName("Another Name");
		assertEquals("Another Name", entity.getName());
	}

	@Test
	void testToString() {
		NamedEntity entity = new NamedEntity();
		entity.setName("Sample Name");
		String expected = "NamedEntity{name='Sample Name'}"; // Adjust this format to
																// match your toString()
																// method
		assertEquals(expected, entity.toString());
	}

}
