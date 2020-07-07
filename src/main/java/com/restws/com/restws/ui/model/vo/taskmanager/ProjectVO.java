package com.restws.com.restws.ui.model.vo.taskmanager;

import com.restws.com.restws.ui.model.taskmanager.ClientLocation;

public class ProjectVO {

	private int projectID;
	private String projectName;
	private String dateOfStart;
	private boolean active;
	private String status;
	private int clientLocationId;
	private ClientLocation clientLocation;
	
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
	public ClientLocation getClientLocation() {
		return clientLocation;
	}
	public void setClientLocation(ClientLocation clientLocation) {
		this.clientLocation = clientLocation;
	}

	public ProjectVO(int projectID, String projectName, String dateOfStart, boolean active, String status,
			int clientLocationId, ClientLocation clientLocation, int teamSize) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
		this.active = active;
		this.status = status;
		this.clientLocationId = clientLocationId;
		this.clientLocation = clientLocation;
		this.teamSize = teamSize;
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
	public String getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(String dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	private int teamSize;
	
	
}
