/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class ModelTest {
	private Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public void testGetMessage() { Assert.assertEquals("",
	 * this.model.getHelloWorld().getMessage()); }
	 */

}
