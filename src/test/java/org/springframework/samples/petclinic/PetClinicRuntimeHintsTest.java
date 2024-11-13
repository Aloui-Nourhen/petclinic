package org.springframework.samples.petclinic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

class PetClinicRuntimeHintsTest {

	private static PetClinicRuntimeHints runtimeHints;

	private static RuntimeHints hints;

	private static ClassLoader classLoader;

	@BeforeAll
	static void setUpBeforeClass() {

		runtimeHints = new PetClinicRuntimeHints();
		hints = new RuntimeHints();
		classLoader = PetClinicRuntimeHints.class.getClassLoader();
	}

	@Test
	void testRegisterHints() {

		runtimeHints.registerHints(hints, classLoader);
		assertNotNull(hints, "RuntimeHints ne devrait pas être nul.");

	}

}
