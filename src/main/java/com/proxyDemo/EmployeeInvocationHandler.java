package com.proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeInvocationHandler implements InvocationHandler {

	private IEmployee employee;

	public EmployeeInvocationHandler(IEmployee employee) {
		this.employee = employee;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// Pre-processing Logics

		// Invocation Logic

		Object result = method.invoke(employee, args);

		// Post-processing Logics

		return result;
	}

}
