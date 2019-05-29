package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import pojo.UserVO;
import dao.DbConnection;
import dao.LoginHandler;
import dao.RegistrationHandler;

public class SecurityManager {
	DbConnection database = null;
	Connection connection = null;

	public SecurityManager() throws Exception {
		this.database = new DbConnection();
		this.connection = database.getConnection();
	}

	public ArrayList<UserVO> getAllUsersList(String username) throws Exception {
		ArrayList<UserVO> userList = null;
		try {
			LoginHandler loginHandler = new LoginHandler();
			userList = loginHandler.getAllUsers(connection, username);
			System.out.print("SM" + userList);
		} catch (Exception e) {
			// System.out.println(userList);
			throw e;
		}
		return userList;
	}

	public ArrayList<String> getUser() throws Exception {

		ArrayList<String> userList = null;
		try {
			LoginHandler loginHandler = new LoginHandler();
			userList = loginHandler.getUsers(connection);
		} catch (Exception e) {
			// System.out.println(userList);
			throw e;
		}
		return userList;
	}

	public int getUserCount() throws Exception {
		int status = 0;
		try {
			RegistrationHandler registrationHandler = new RegistrationHandler();
			status = registrationHandler.getUserCount(connection);
		} catch (Exception e) {

		}
		return status;
	}

	public String registerUser(HashMap<String, String> dictionary) throws Exception {
		String statusMessage = null;
		try {
			RegistrationHandler registrationHandler = new RegistrationHandler();
			statusMessage = registrationHandler.regiserUserAccount(connection,dictionary);
		} catch (Exception e) {

		}
		return statusMessage;
	}

}