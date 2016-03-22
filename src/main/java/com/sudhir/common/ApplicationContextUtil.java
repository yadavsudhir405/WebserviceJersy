package com.sudhir.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private ApplicationContextUtil(){
		throw new AssertionError("Objact can not be instantiated");
	}
	public static ApplicationContext ctx=new ClassPathXmlApplicationContext(
			new String[] { "classpath*:/META-INF/spring-application-context.xml" });
}
