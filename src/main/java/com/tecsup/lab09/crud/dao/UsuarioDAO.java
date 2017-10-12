package com.tecsup.lab09.crud.dao;

import java.util.ArrayList;

import com.tecsup.lab09.crud.bean.Usuario;


public interface UsuarioDAO{
	
	/**
	 * 
	 * @return
	 */
	ArrayList<Usuario> findAll();

	/**
	 * 
	 * @param cod
	 */
	Usuario findById(int cod);
		
	/**
	 * 
	 * @param pNombre
	 * @param pCorreo
	 * @param pPass
	 */
	int create(String pNombre, String pCorreo, String pPass);

	/**
	 * 
	 * @param cod
	 */
	void delete(int cod);

	/**
	 * 
	 * @param cod
	 * @param pNombre
	 * @param pCorreo
	 * @param pPass
	 */
	void update(int cod, String pNombre, String pCorreo, String pPass);

}
