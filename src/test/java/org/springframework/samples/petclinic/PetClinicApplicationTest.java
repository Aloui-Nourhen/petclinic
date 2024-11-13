package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = { PetClinicApplication.class, PetClinicApplicationTest.TestCacheConfig.class })
class PetClinicApplicationTest {

	@Configuration
	static class TestCacheConfig {

		@Bean
		public CacheManager cacheManager() {
			return new ConcurrentMapCacheManager("default");
		}

	}

	@Test
	void testMain() {
		PetClinicApplication.main(new String[] {});
	}

}
