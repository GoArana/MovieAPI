package com.example.demo;



public class Pelicula {

	public Pelicula() {
		// TODO Auto-generated constructor stub
	}
	private String nombre;
    private int año;
    private Genero genero;
    
    public Pelicula(String nombre, int año, Genero genero) {
    	this.nombre=nombre;
    	this.año=año;
    	this.genero=genero;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", año=" + año + ", genero=" + genero + "]";
	}


}
