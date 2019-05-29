package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
import pojo.UserVO;
 
public class LoginHandler {
 
public ArrayList<UserVO> getAllUsers(Connection connection, String name) throws Exception {
ArrayList<UserVO> userList = new ArrayList<UserVO>();
try {
PreparedStatement ps = connection.prepareStatement("select * from user where username=?");
ps.setString(1, name);    

ResultSet rs = ps.executeQuery();
while (rs.next()) {
UserVO uservo = new UserVO();
uservo.setUsername(rs.getString("username"));
uservo.setPassword(rs.getString("password"));
uservo.setMail(rs.getString("mail"));
System.out.println(rs.getString("username"));
System.out.println(rs.getString("password"));
System.out.println("LoginHandler:" + rs.getString("username"));
System.out.println("LoginHandler:" + rs.getString("password"));

userList.add(uservo);
}
return userList;
} catch (Exception e) 
{
	System.out.println(e);
throw e;
}

}
public ArrayList<String> getUsers(Connection connection) throws Exception {
ArrayList<String> userList = new ArrayList<String>();
try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection.prepareStatement("select * from user");

// ps.setString(1,uname);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
//UserVO uservo = new UserVO();
//uservo.setUsername(rs.getString("username"));
	System.out.println(rs.getString("username"));
userList.add(rs.getString("username"));
}
return userList;
} catch (Exception e) 
{
	System.out.println(e);
throw e;
}

}
 
}