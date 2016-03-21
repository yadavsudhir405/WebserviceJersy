package com.sudhir.webservices.jersy;

import org.springframework.stereotype.Component;

import com.sudhir.model.TestModel;

@Component
public class Hello {
	public TestModel getMessage() {
		return new TestModel("Sudhir",25);
	}
}
