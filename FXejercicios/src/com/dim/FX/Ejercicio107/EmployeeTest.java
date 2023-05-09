package com.dim.FX.Ejercicio107;

import java.beans.PropertyChangeEvent;
public class EmployeeTest {
public static void main(String[] args) {
	final Employee emp1 = new Employee("John Jacobs", 2000.0);
	// Cálculo de impuestos
	//computeTax(emp1.getSalary());
	// Añadir el listener de cambio de propiedad a empl
	emp1.addPropertyChangeListener(
				EmployeeTest::handlePropertyChange);
	// Change the salary
	emp1.setSalary(3000.00);
	emp1.setSalary(3000.00); // No change notification is sent.
	emp1.setSalary(6000.00);
	emp1.setSalary(8888.00);
	emp1.setSalary(8888.00);
	}
	public static void handlePropertyChange(PropertyChangeEvent e) {
		String propertyName = e.getPropertyName();
		if ("salary".equals(propertyName)) {
			System.out.print("El salario ha cambiado. ");
			System.out.print("Valor anterior:" + e.getOldValue());
			System.out.println(", Nuevo valor:" +
			e.getNewValue());
			computeTax((Double)e.getNewValue());
		}
	}
	public static void computeTax(double salary) {
		final double TAX_PERCENT = 20.0;
		double tax = salary * TAX_PERCENT/100.0;
		System.out.println("El impuesto correspondiente al nuevo salario de " + salary + " es:" + tax);
	}
}