package pojo;

public class UserVO 
{

private String username;
private String password;
private String mail;
private int active;
private int id;

public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

public String getMail() {
return mail;
}
public void setMail(String mail)
{
this.mail = mail;
}

public int getActiveStatus() {
return active;
}
public void setActiveStatus(int active) {
this.active = active;
}

public int getID() {
return id;
}
public void setID(int id) {
this.id = id;
}

}