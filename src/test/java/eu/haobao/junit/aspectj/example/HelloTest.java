package eu.haobao.junit.aspectj.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import eu.haobao.junit.aspectj.AspectJConfig;
import eu.haobao.junit.aspectj.AspectJUnit4Runner;

/**
 * @author David Zhang
 */
@AspectJConfig(classpathAdditions = "src/test/hello-resources")
@RunWith(AspectJUnit4Runner.class)
public class HelloTest {

	@Test
	public void getLiveGreeting() {
		String expected = "Hello DAVID!";
		HelloService helloService = new HelloService();
		String greeting = helloService.sayHello("David");
		Assert.assertEquals("UpperCaseAspect must convert name to upper case.", expected, greeting);
	}

}
