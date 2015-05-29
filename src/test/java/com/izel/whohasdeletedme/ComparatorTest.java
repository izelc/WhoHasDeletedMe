package com.izel.whohasdeletedme;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.izel.whohasdeletedme.main.UserInteraction;

public class ComparatorTest {

	QuitterDetector quitterDetector = new QuitterDetector();
	UserInteraction ui = new UserInteraction();

	@Test
	public void testName() throws Exception {

		while (1 == 1) {
			ArrayList<String> list = quitterDetector
					.findQuittersForAUser("239984780");

			if (!list.isEmpty())
				System.out.println(list);
		}
	}

	@Test
	public void convertToUserName() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		list.add("201595333");
		list.add("626252091");
		System.out.println(quitterDetector.convertToUserName(list));
		;
	}

	
	private void alertUsers(HashMap<String, ArrayList<String>> usersAndTheirQuitters) {
		for (Entry<String, ArrayList<String>> entry : usersAndTheirQuitters.entrySet()) {
			System.out.println("Hey "+entry.getKey()+", we got news for you!"+entry.getValue()+"is not your follower anymore :(");
		}
	}
	@Test
	public void testName1() throws Exception {
        ui.registerNewUser("mogpo");
        ui.registerNewUser("moc");
        ui.registerNewUser("mogpoe");
        ui.registerNewUser("mon");
        
        HashMap<String, List<String>> map = UserAndHisFollowers.getMap();
        
    	while (1 == 1) {
    		
			HashMap<String, ArrayList<String>> list = quitterDetector
					.findQuittersOfAllUsers();
			alertUsers(list);
			try {
    		    Thread.sleep(10000);                 //1000 milliseconds is one second.
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
		
		}
    	
    	
    	
        
        
        
	}
}
