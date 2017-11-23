package com.trabalho.logistica.api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.StringTokenizer;

public class AuthenticationService {

	public boolean authenticate(String authCredentials) {
		if (null == authCredentials)
			return false;
		
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String usuario = tokenizer.nextToken();
		final String senha = tokenizer.nextToken();
		
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		try {
		AuthenticationUserDAO authenticationUserDAO = new AuthenticationUserDAO();
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();
		
		//boolean authenticationStatus = "admin".equals(usuario) && "admin".equals(senha);
		boolean authenticationStatus = authenticationUserDAO.authenticatation(conn, usuario, senha);
		return authenticationStatus;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}