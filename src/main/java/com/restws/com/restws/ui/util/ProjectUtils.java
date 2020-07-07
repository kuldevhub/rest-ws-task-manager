package com.restws.com.restws.ui.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.restws.com.restws.ui.model.taskmanager.ClientLocation;
import com.restws.com.restws.ui.model.taskmanager.Project;
import com.restws.com.restws.ui.model.vo.taskmanager.ProjectVO;

public final class ProjectUtils {
	static Map<Integer, ClientLocation> clientLocationMap = new HashMap<>();
	public static Map<Integer,Project> cacheProjects = new HashMap<>();
	static String[] locations = {"Boston","New York","Maryland","Virginia","DC"};
	static String[] status = {"Support","In Force","Support","In Force","Support"};
	public static void setUpProjectsLocationData() {
		for(int c=1;c<=5;c++) {
			clientLocationMap.put(c, new ClientLocation(c,locations[c-1]));
		}
		Date startDate = new Date();
		if(cacheProjects.isEmpty()) {
			for(int i=1;i<=5;i++) {
				cacheProjects.put(i, new Project(i,"projectName"+i,startDate,i+5, true, status[i-1],i,clientLocationMap.get(i)));
			}
		}

	}
	
	public static List<ProjectVO> getProjects() {
//		List<Project> list = cacheProjects.values().stream()
//				.collect(Collectors.toList());

		List<ProjectVO> list = new ArrayList<>();
		for(Project proj: cacheProjects.values()) {
			
			Format f = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = f.format(proj.getDateOfStart());
			list.add(new ProjectVO(proj.getProjectID(),proj.getProjectName(),strDate,proj.isActive(),proj.getStatus(),
					proj.getClientLocationId(), proj.getClientLocation(), proj.getTeamSize()));
		}
		return list;
	}
	
	public static List<ClientLocation> getClentLocations() {
		List<ClientLocation> list = clientLocationMap.values().stream()
				.collect(Collectors.toList());
		return list;
	}
	
	public static ProjectVO createProject(ProjectVO project) throws ParseException {
		String date = project.getDateOfStart();
		SimpleDateFormat dtFrmt = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = dtFrmt.parse(date);
		Project proj = new Project(project.getProjectID(), project.getProjectName(),dt , project.getTeamSize(),
				project.isActive(), project.getStatus(), project.getClientLocationId(), clientLocationMap.get(project.getClientLocationId()));
				cacheProjects.put(project.getProjectID(), proj);
		project.setClientLocation(clientLocationMap.get(project.getClientLocationId()));
		return project;
	}
	
	public static ProjectVO updateProject(ProjectVO project) throws ParseException {
		Project proj = cacheProjects.get(project.getProjectID());
		if(proj !=null) {
			String date = project.getDateOfStart();
			SimpleDateFormat dtFrmt = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = dtFrmt.parse(date);
			
			proj.setProjectName(project.getProjectName());
			proj.setDateOfStart(dt);
			proj.setTeamSize(project.getTeamSize());
			proj.setActive(project.isActive());
			proj.setStatus(project.getStatus());
			proj.setClientLocationId(project.getClientLocationId());
			return project;
		}else {
			return null;
		}
	}
}
