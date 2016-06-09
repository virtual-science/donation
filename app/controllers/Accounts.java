package controllers;
import javax.persistence.Entity;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Accounts extends Controller {
	public static void signup() {
		render();
	}

	public static void register (User user)
	{
		Logger.info(user.firstName + " " + user.lastName + " " + user.email + " " + user.password);
		
		user.save();
		Welcome.index();
	}

	public static void login() {
		render();
	}

	public static void logout() {
		session.clear();
		Welcome.index();
	}

	public static void authenticate(String email, String password) {
		Logger.info("Attempting to authenticate with " + email + ":" + password);

		User user = User.findByEmail(email);
		if ((user != null) && (user.checkPassword(password) == true)) {
			Logger.info("Successfully authentication of " + user.firstName);
			session.put("logged_in_userid", user.id);
			DonationController.index();
		} else {
			Logger.info("Authentication failed");
			login();
		}

	}

	public static User getCurrentUser() {
		String userId = session.get("logged_in_userid");
	    if (userId == null)
	    {
	      return null;
	    }
	    User logged_in_user = User.findById(Long.parseLong(userId));
	    Logger.info("In Accounts controller: Logged in user is " + logged_in_user.firstName);
	    return logged_in_user;
	}

}
