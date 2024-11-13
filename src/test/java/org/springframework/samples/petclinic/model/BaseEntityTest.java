package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

	@Test
	void testGetId() {
		BaseEntity entity = new BaseEntity();
		entity.setId(1);
		assertEquals(1, entity.getId());
	}

	@Test
	void testSetId() {
		BaseEntity entity = new BaseEntity();
		entity.setId(5);
		assertEquals(5, entity.getId());
	}

	@Test
	void testIsNew() {
		BaseEntity entity = new BaseEntity();
		assertTrue(entity.isNew());
		entity.setId(1);
		assertFalse(entity.isNew());
	}

}
