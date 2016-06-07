package controllers;

import play.Logger;
import play.mvc.Controller;

public class DonationController extends Controller {

    public static void index() {
    	Logger.info("got to controller");
        render();
    }

}
