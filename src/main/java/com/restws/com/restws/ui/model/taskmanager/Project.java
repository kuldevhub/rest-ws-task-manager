package com.restws.com.restws.ui.model.taskmanager;

import java.util.Date;

public class Project {
	public Project(int projectID, String projectName, Date dateOfStart, int teamSize) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
		this.teamSize = teamSize;
	}
	private int projectID;
	private String projectName;
	private Date dateOfStart;
	private int teamSize;
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
