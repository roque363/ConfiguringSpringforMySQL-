package com.tecsup.lab09.crud.bean;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cod;
	private String nombre;
	private String correo;
	private String pass;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(int cod, String nombre, String correo, String pass) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.correo = correo;
		this.pass = pass;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuarios [cod=" + cod + ", nombre=" + nombre + ", correo=" + correo + ", pass=" + pass + "]";
	}

}
