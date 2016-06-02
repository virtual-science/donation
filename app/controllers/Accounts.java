package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Accounts extends Controller {
	public static void signup() {
		render();
	}

	public static void register(User user) {
		user.save();
		login();
	}

	public static void login() {
		render();
	}

	public static void logout() {
		session.clear();
		Welcome.index();
	}

	public static void authenticate(String email, String password) 
	{
		Logger.info("Attempting to authenticate with " + email + ":" + password);
	
		User user = User.findByEmail(email);
		if((user != null) && (user.checkPassword(password) == true))
		{
			Logger.info("Successfully authentication of " + user.firstName);
			session.put("logged_in_userid", user.id);
	     	DonationController.index();
		}
		else
		{
		Logger.info("Authentication failed");
		login();
		}
		
	}

	public static User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

		
		
