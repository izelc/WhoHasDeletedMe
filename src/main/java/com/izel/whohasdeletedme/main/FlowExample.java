package com.izel.whohasdeletedme.main;

public class FlowExample {

	public static void main(String[] args) {

		
		AdminInteraction admin=new AdminInteraction();
		admin.addNewAdvertise("uhu");
		System.out.println("advertisement click count:"+admin.seeAdvertiseClicks("uhu"));
		
		UserInteraction userInteraction = new UserInteraction();
		userInteraction.registerNewUser("JA_22_");
		userInteraction.clickonad("uhu");
		System.out.println("advertisement click count:"+admin.seeAdvertiseClicks("uhu"));
		
		userInteraction.workDetector();
	}

}
