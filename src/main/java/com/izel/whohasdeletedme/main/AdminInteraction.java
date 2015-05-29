package com.izel.whohasdeletedme.main;

public class AdminInteraction {

	public void addNewAdvertise(String advertise) {
		Advertisement.addAdvertise(advertise);

	}

	public Integer seeAdvertiseClicks(String advertise) {
		return Advertisement.getClickCount(advertise);
	}
}
