
package com.proxyDemo;

import java.lang.reflect.Proxy;

public class ITEmployee implements IEmployee {

	private Integer id;
	private Double salary;

	public Integer getId() {
		return id;
	}

	
	public Double getSalary() {
		return salary;
	}

	private void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public void salHike(Double hike) {
		setSalary(hike + getSalary());
	}

	@Override
	public void payCut(Double cut) {
		setSalary(cut - getSalary());
	}

	private ITEmployee(Integer id, Double salary) {
		this.id = id;
		this.salary = salary;
	}

	public static IEmployee getItEmployee(Integer id, Double salary) {

		ITEmployee itEmployee = new ITEmployee(id, salary);
		EmployeeInvocationHandler employeeInvocationHandler = new EmployeeInvocationHandler(itEmployee);
		IEmployee newProxyInstance = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(),
				new Class[] { IEmployee.class }, employeeInvocationHandler);
		return newProxyInstance;

	}
}
