package eu.haobao.junit.aspectj;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author David Zhang
 */
public class JUnitLifeCycleTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.clearProperty("JUnit_After");
		System.clearProperty("JUnit_AfterClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.clearProperty("JUnit_After");
		System.clearProperty("JUnit_AfterClass");
	}

	@Test
	public void run() {
		JUnitCore junitCore = new JUnitCore();
		Result result = junitCore.run(TestDummy.class);
		List<Failure>failures = result.getFailures();
		if(!(failures == null || failures.isEmpty())) {
			for(Failure f : failures) {
				System.out.println(f.getMessage());
			}
		}
		Assert.assertEquals(2, result.getRunCount());
		Assert.assertEquals(0, result.getIgnoreCount());
		Assert.assertEquals(0, result.getFailureCount());
		Assert.assertEquals("After was not executed", "true", System.getProperty("JUnit_After"));
		Assert.assertEquals("AfterClass was not executed", "true", System.getProperty("JUnit_AfterClass"));
	}

}
