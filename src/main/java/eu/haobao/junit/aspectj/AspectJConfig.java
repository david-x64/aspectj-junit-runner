package eu.haobao.junit.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation on your test class to configure AspectJ.
 * 
 * For example you can control which aop.xml files are found on the classpath.
 * 
 * If you do not use this annotation please make sure you have a
 * {@code META-INF/aop.xml} on the classpath.
 * 
 * @author David Zhang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface AspectJConfig {

	/**
	 * Use this to append additional classpath entries.
	 * This is especially useful if you want your tests to use different
	 * aop.xml files each.
	 * If your aop.xml file is located for example in
	 * {@code /home/joe/test/META-INF/aop.xml} then add {@code /home/joe/test}
	 * as classpathAddition.
	 * Depending on your project setup this might also work with relative
	 * parts.
	 */
	String[] classpathAdditions() default "";
}
