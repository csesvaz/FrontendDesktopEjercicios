package com.dim.FX.Ejercicio106;

import java.io.Serializable;

public class Persona implements Serializable  {
 private static final long serialVersionUID = 1L;
private String nombre;
 private int edad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	 
 
}