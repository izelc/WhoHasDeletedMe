package com.izel.whohasdeletedme.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.izel.whohasdeletedme.QuitterDetector;
import com.izel.whohasdeletedme.UserAndHisFollowers;

public class UserInteraction {

	public UserInteraction() {
	}

	public void workDetector() {
		QuitterDetector quitterDetector = new QuitterDetector();
		while (1 == 1) {

			HashMap<String, ArrayList<String>> usersAndTheirQuitters = quitterDetector
					.findQuittersOfAllUsers();
			alertUsers(usersAndTheirQuitters);
			
			try {
				Thread.sleep(10000); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		}
	}

	public void registerNewUser(String userName) {
		UserAndHisFollowers.addNewUser(userName);
	}

	public void clickonad(String ad) {
		Advertisement.clickOn(ad);
	}
	
	
	private void alertUsers(HashMap<String, ArrayList<String>> usersAndTheirQuitters) {
		for (Entry<String, ArrayList<String>> entry : usersAndTheirQuitters.entrySet()) {
			System.out.println("Hey "+entry.getKey()+", we got news for you!"+entry.getValue()+"is not your follower anymore :(");
		}
	}
}
