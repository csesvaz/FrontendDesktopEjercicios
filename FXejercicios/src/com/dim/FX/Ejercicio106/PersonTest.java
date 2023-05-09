package com.dim.FX.Ejercicio106;

import java.time.LocalDate;

import javafx.beans.property.ReadOnlyProperty;

public class PersonTest {

	public static void printDetails(ReadOnlyProperty<?> p) {
	    String name = p.getName();
	    Object value = p.getValue();
	    Object bean = p.getBean();

	    String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
	    String propClassName = p.getClass().getSimpleName();

	    System.out.print(propClassName);
	    System.out.print("[Name:" + name);
	    System.out.print(", Bean Class:" + beanClassName);
	    System.out.println(", Value:" + value + "]");
	}

	
	public static void main(String[] args) {

	    Person p = new Person();

	    System.out.println("--- valores iniciales --- ");

	    printDetails(p.idProperty());
	    printDetails(p.nombreProperty());
	    printDetails(p.fechaProperty());

	    System.out.println("--- nuevos valores --- ");

	 
	    p.setFecha(LocalDate.now());

	    printDetails(p.idProperty());
	    printDetails(p.nombreProperty());
	    printDetails(p.fechaProperty());
	}

	
	
}