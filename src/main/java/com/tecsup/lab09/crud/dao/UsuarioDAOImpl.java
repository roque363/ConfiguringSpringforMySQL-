package com.tecsup.lab09.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tecsup.lab09.crud.bean.Usuario;
import com.tecsup.lab09.crud.db.ConnectionDB;


public class UsuarioDAOImpl implements UsuarioDAO{
	
	/* (non-Javadoc)
	 * @see com.tecsup.lab08.crud.dao.EmployeeDAO2#getEmployees()
	 */
	
	public ArrayList<Usuario> findAll() {

		System.out.println("getUsuarios()");

		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "Select cod, nombre, correo, pass from usuarios order by cod";
		ArrayList<Usuario> records = new ArrayList<Usuario>();
		
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				Usuario emp = new Usuario();
				emp.setCod(rs.getInt(1));
				emp.setNombre(rs.getString(2));
				emp.setCorreo(rs.getString(3));
				emp.setPass(rs.getString(4));
				records.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return records;
	}

	/**
	 * 
	 * @param id
	 */
	public Usuario findById(int cod) {

		System.out.println("getUsuario()"+cod);

		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "Select cod, nombre, correo, pass from usuarios where cod = ?";
		Usuario emp = new Usuario();
		try {
			pst = con.prepareStatement(stm);
			pst.setInt(1, cod);
			pst.execute();
			rs = pst.getResultSet();
			if (rs.next()) {
				emp.setCod(rs.getInt(1));
				emp.setNombre(rs.getString(2));
				emp.setCorreo(rs.getString(3));
				emp.setPass(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return emp;
	}
	
	/* (non-Javadoc)
	 * @see com.tecsup.lab09.crud.dao.UsuarioDAO#createUsuario(java.lang.String, java.lang.String, java.lang.String)
	 */
	public int  create(String pNombre, String pCorreo, String pPass) {

		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		int idGenerator = -1;
		
		//String stm = "SELECT USUARIOS2_SEQ.NEXTVAL FROM DUAL";
		String stm = "SELECT MAX(cod) FROM usuarios";
		
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			if (rs.next())  idGenerator = rs.getInt(1)+1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		String stm2 = "INSERT INTO usuarios (nombre, correo, pass)  VALUES (?,?,?)";
		try {
			pst = con.prepareStatement(stm2);
			pst.setString(1, pNombre);
			pst.setString(2, pCorreo);
			pst.setString(3, pPass);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return idGenerator;
	}

	/* (non-Javadoc)
	 * @see com.tecsup.lab08.crud.dao.EmployeeDAO2#deleteEmployee(int)
	 */
	public void delete(int cod) {

		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "DELETE FROM usuarios WHERE cod =? ";
		try {
			pst = con.prepareStatement(stm);
			pst.setInt(1, cod);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.tecsup.lab08.crud.dao.EmployeeDAO2#updateEmployee(int, java.lang.String, java.lang.String, java.lang.Double)
	 */
	public void update(int cod, String pNombre, String pCorreo, String pPass) {

		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "UPDATE usuarios SET nombre=?, correo=?, pass=? WHERE cod = ?";
		try {
			pst = con.prepareStatement(stm);
			pst.setString(1, pNombre);
			pst.setString(2, pCorreo);
			pst.setString(3, pPass);
			pst.setInt(5, cod);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
