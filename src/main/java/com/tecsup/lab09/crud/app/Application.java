package com.tecsup.lab09.crud.app;

import com.tecsup.lab09.crud.bean.Usuario;
import com.tecsup.lab09.crud.dao.UsuarioDAO;
import com.tecsup.lab09.crud.dao.UsuarioDAOImpl;


public class Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO dao = new UsuarioDAOImpl();
		
		int id = -1;
		
		id = dao.create("Roque", "roque363@gmail.com","12345");
		
		Usuario emp = dao.findById(id);
		
		System.out.println("Create .. " + emp);

		/*
		dao.update(id, "Juan2", "Alberto2", (double) 1505);
		
		emp = dao.findById(id);
		
		System.out.println("Update .. " + emp);
				
		dao.delete(id);

		emp = dao.findById(id);

		System.out.println("Delete .. " + emp);	
		*/	
		
		for (Usuario item : dao.findAll()) {
			
			System.out.println(item);
			 
		};
		
	}

}
