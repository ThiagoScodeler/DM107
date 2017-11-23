package com.trabalho.logistica.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationUserDAO {

	public boolean authenticatation(Connection conn, String usuario, String senha) throws SQLException{
		
		String sql = "select * from usuario where usuario = ? and senha = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, usuario);
		pstm.setString(2, senha);
		ResultSet rs = pstm.executeQuery();
		return rs.next();
	}
}