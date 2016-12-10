package eu.haobao.junit.aspectj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author David Zhang
 */
@RunWith(AspectJUnit4Runner.class)
public class TestDummy {
	private static final boolean DEBUG = false;
	private static boolean beforeClass;
	private boolean before;

	public TestDummy() {
		if(DEBUG) System.out.println(getClass().getSimpleName() + " : New Instance!");
	}

	@BeforeClass
	public static void beforeClass() {
		beforeClass = true;
		if(DEBUG) System.out.println(TestDummy.class.getSimpleName() + " : Before class was executed!");
	}

	@AfterClass
	public static void afterClass() {
		System.setProperty("JUnit_AfterClass", "true");
		if(DEBUG) System.out.println(TestDummy.class.getSimpleName() + " : After class was executed!");
	}

	@Before
	public void before() {
		before = true;
		if(DEBUG) System.out.println(getClass().getSimpleName() + " : Before was executed!");
	}

	@After
	public void after() {
		System.setProperty("JUnit_After", "true");
		if(DEBUG) System.out.println(getClass().getSimpleName() + " : After was executed!");
	}

	@Test
	public void methodOne() {
		if(DEBUG) System.out.println(getClass().getSimpleName() + " : Test method 1 was executed!");
		Assert.assertTrue("beforeClass was not executed", beforeClass);
		Assert.assertTrue("before was not executed", before);
	}

	@Test
	public void methodTwo() {
		if(DEBUG) System.out.println(getClass().getSimpleName() + " : Test method 2 was executed!");
		Assert.assertTrue("beforeClass was not executed", beforeClass);
		Assert.assertTrue("before was not executed", before);
	}
}
