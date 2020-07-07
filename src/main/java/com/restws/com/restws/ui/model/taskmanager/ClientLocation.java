package com.restws.com.restws.ui.model.taskmanager;

public class ClientLocation {

	private int clientLocationId;
	private String clientLocationName;
	public int getClientLocationId() {
		return clientLocationId;
	}
	public String getClientLocationName() {
		return clientLocationName;
	}
	public ClientLocation(int clientLocationId, String clientLocationName) {
		super();
		this.clientLocationId = clientLocationId;
		this.clientLocationName = clientLocationName;
	}
	
}
