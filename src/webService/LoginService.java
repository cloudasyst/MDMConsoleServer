package webService;

import java.io.PrintStream;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import model.SecurityManager;
import pojo.UserVO;

@Path("/WebService")
public class LoginService {
	@POST
	@Path("/logins")
	@Consumes({ "application/x-www-form-urlencoded" })
	public String login(@FormParam("username") String username, @FormParam("password") String password) {
		return getAllUsersList(username, password);
	}

	@POST
	@Path("/login")
	@Consumes({ "application/x-www-form-urlencoded" })
	public String getAllUsersList(@FormParam("username") String username, @FormParam("password") String password) {

		try {
			ArrayList<UserVO> userList = null;
			SecurityManager securityManager = new SecurityManager();
			userList = securityManager.getAllUsersList(username);
			for (UserVO userVO : userList) {
				if ((userVO.getUsername().equals(username)) && (userVO.getPassword().equals(password))) {
					return "Logged in User:" + username;
				}
			}
		} catch (Exception localException) {
		}
		return "You are not a Valid User";
	}

	@GET
	@Path("/RegCount")
	@Consumes({ "application/json;charset=UTF-8" })
	public String getUserNames() throws JSONException {
		ArrayList<String> userList = null;
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		String message = "nothing";

		try {
			SecurityManager securityManager = new SecurityManager();
			userList = securityManager.getUser();

			for (String userVO : userList) {
				JSONObject item = new JSONObject();
				item.put("name", userVO);
				array.put(item);
			}

		} catch (Exception localException) {

		}
		json.put("userDetails", array);
		message = json.toString();
		message = array.toString();
		return message;
	}

}
