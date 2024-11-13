package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

	@Test
	void testGetFirstName() {
		Person person = new Person();
		person.setFirstName("John");
		assertEquals("John", person.getFirstName());
	}

	@Test
	void testSetFirstName() {
		Person person = new Person();
		person.setFirstName("Alice");
		assertEquals("Alice", person.getFirstName());
	}

	@Test
	void testGetLastName() {
		Person person = new Person();
		person.setLastName("Doe");
		assertEquals("Doe", person.getLastName());
	}

	@Test
	void testSetLastName() {
		Person person = new Person();
		person.setLastName("Smith");
		assertEquals("Smith", person.getLastName());
	}

}
