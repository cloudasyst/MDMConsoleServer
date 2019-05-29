package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationHandler {

	public RegistrationHandler()
	{
		
	}
	
	
	public int getUserCount(Connection connection) throws Exception
	{
		int numberOfRows =0;
		try {
			PreparedStatement ps = connection.prepareStatement("select count(*) from registration");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
		     numberOfRows = rs.getInt(1);
		     System.out.println(numberOfRows);
			}
			return  numberOfRows;
		} catch (Exception e) 
		{
		System.out.println(e);
		throw e;
	}

	}

	public String regiserUserAccount(Connection connection,HashMap<String, String> dictionary) throws Exception
	{
		String status = null;
		try {
			String query = "insert into registration (username,fullname, password, mail, active)"
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			  int activeStatus = Integer.parseInt(dictionary.get("active"));
		      preparedStmt.setString(1, dictionary.get("username"));
		      preparedStmt.setString (2, dictionary.get("fullname"));
		      preparedStmt.setString (3, dictionary.get("password"));
		      preparedStmt.setString (4, dictionary.get("mail"));
		      preparedStmt.setInt (5, activeStatus);
		     int result=  preparedStmt.executeUpdate();
		     if(result==0){
		    	 status = "failure";
		     }
		     else{
		    	 status = "success";
		     }
		     System.out.println("insert "+ result);
			return  status;
		} catch (Exception e) 
		{
		System.out.println(e);
		throw e;
		}

	}

}
