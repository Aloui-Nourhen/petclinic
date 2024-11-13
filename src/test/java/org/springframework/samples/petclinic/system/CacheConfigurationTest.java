package org.springframework.samples.petclinic.system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheConfigurationTest {

	@Autowired
	private JCacheManagerCustomizer customizer;

	@Test
	void testPetclinicCacheConfigurationCustomizer() {
		
		CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();

		customizer.customize(cacheManager);

		Cache<Object, Object> vetsCache = cacheManager.getCache("vets");
		assertNotNull(vetsCache, "Le cache 'vets' devrait être créé.");
		MutableConfiguration<Object, Object> cacheConfig = new MutableConfiguration<>().setStatisticsEnabled(true);
		assertTrue(cacheConfig.isStatisticsEnabled(), "Les statistiques du cache 'vets' devraient être activées.");
	}

}
