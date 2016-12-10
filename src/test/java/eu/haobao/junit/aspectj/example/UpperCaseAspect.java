package eu.haobao.junit.aspectj.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author David Zhang
 */
@Aspect
public class UpperCaseAspect {

	@Pointcut("call(String sayHello(String)) && args(name) && target(callee)")
	public void sayHello(String name, HelloService callee) {}

	@Around("sayHello(name, callee)")
	public String upper(ProceedingJoinPoint joinPoint, HelloService callee, String name) throws Throwable {
		Object[] args = new Object[3];
		args[0] = joinPoint.getThis();
		args[1] = callee;
		args[2] = name.toUpperCase();
		String result = (String)joinPoint.proceed(args);
		return result;
	}
}
