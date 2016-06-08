/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsdr.europeanaqa.api.abbreviation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class EdmDataProviderManagerTest {

	public EdmDataProviderManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSize() {
		EdmDataProviderManager manager = new EdmDataProviderManager();

		assertEquals(3940, manager.getData().keySet().size());
	}

	@Test
	public void testGetData() {
		EdmDataProviderManager manager = new EdmDataProviderManager();

		assertTrue(manager.getData().containsKey("Preiser Records; Austria"));
		assertEquals(264, (int) manager.getData().get("Preiser Records; Austria"));

		assertTrue(manager.getData().containsKey("Pipeline Music"));
		assertEquals(1001, (int) manager.getData().get("Pipeline Music"));
		
		assertTrue(manager.getData().containsKey("Österreichische Nationalbibliothek - Austrian National Library"));
		assertEquals(2, (int) manager.getData().get("Österreichische Nationalbibliothek - Austrian National Library"));
	}

	@Test
	public void testGetDatasets() {
		EdmDataProviderManager manager = new EdmDataProviderManager();
		assertEquals(264, (int) manager.getDataProviders().get("Preiser Records; Austria"));
		assertEquals(1001, (int) manager.getDataProviders().get("Pipeline Music"));
		assertEquals(2, (int) manager.getDataProviders().get("Österreichische Nationalbibliothek - Austrian National Library"));
	}

	@Test
	public void testLookup() {
		EdmDataProviderManager manager = new EdmDataProviderManager();

		assertEquals(264, (int) manager.lookup("Preiser Records; Austria"));
		assertEquals(1001, (int) manager.lookup("Pipeline Music"));
		assertEquals(2, (int) manager.lookup("Österreichische Nationalbibliothek - Austrian National Library"));
	}
}
