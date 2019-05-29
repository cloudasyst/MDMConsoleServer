package webService;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import dao.DbConnection;
import model.SecurityManager;

@Path("/RegService")
public class RegistrationService {
	SecurityManager securityManager = null;

	public RegistrationService() throws Exception {
		this.securityManager = new SecurityManager();
	}

	@GET
	@Path("/regCount")
	@Produces({ "application/json;charset=UTF-8" })
	public String getRegistrationCount() throws JSONException {
		int usercount = 0;
		String message = null;
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();

		try {
			usercount = securityManager.getUserCount();
			json.put("count", usercount);
			array.put(json);
		}

		catch (Exception localException) {

		}
		message = json.toString();
		return message;
	}

	@POST
	@Path("/registerAdminAccount")
	@Consumes({ "application/json;charset=UTF-8" })
	public String registerAdminAccount(@FormParam(value = "username") String username, @FormParam(value = "password") String password,
			@FormParam(value = "fullname") String fullname, @FormParam(value = "mail") String mail) throws JSONException

	{
		String message = null;
		HashMap<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("username", username);
		dictionary.put("fullname", fullname);
		dictionary.put("password", password);
		dictionary.put("mail", mail);
		dictionary.put("active", String.valueOf(1));
		System.out.println(dictionary);
		JSONObject json = new JSONObject();
		try {
			message = securityManager.registerUser(dictionary);
			json.put("status", message);
		} catch (Exception localException) {
		}
		message = json.toString();
		return message;
	}

	@GET
	@Path("/getAdminAccounts")
	@Produces({ "application/json;charset=UTF-8" })
	public String getAdminAccounts() throws JSONException {
		
		System.out.println("nothing");
		
		return "NO USERS";

	}
}
