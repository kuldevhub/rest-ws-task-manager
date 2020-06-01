package com.restws.com.restws.ui.model.vo.taskmanager;

public class ProjectVO {

	private int projectID;
	private String projectName;
	private String dateOfStart;
	public ProjectVO(int projectID, String projectName, String dateOfStart, int teamSize) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
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
