package com.restws.com.restws.ui.model.taskmanager;

import java.util.Date;

public class Project {

	public Project(int projectID, String projectName, Date dateOfStart, int teamSize, boolean active, String status,
			int clientLocationId, ClientLocation clientLocation) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
		this.teamSize = teamSize;
		this.active = active;
		this.status = status;
		this.clientLocationId = clientLocationId;
		this.clientLocation = clientLocation;
	}
	private int projectID;
	private String projectName;
	private Date dateOfStart;
	private int teamSize;
	private boolean active;
	private String status;
	private int clientLocationId;
	private ClientLocation clientLocation;
	
	
	public ClientLocation getClientLocation() {
		return clientLocation;
	}
	public void setClientLocation(ClientLocation clientLocation) {
		this.clientLocation = clientLocation;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getClientLocationId() {
		return clientLocationId;
	}
	public void setClientLocationId(int clientLocationId) {
		this.clientLocationId = clientLocationId;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	

}
