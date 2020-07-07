package com.restws.ui.controller.taskmanger;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.ui.model.taskmanager.Project;
import com.restws.com.restws.ui.model.vo.taskmanager.ProjectVO;
import com.restws.com.restws.ui.util.ProjectUtils;
@CrossOrigin("http://localhost:4200")
//@CrossOrigin
@RestController
@RequestMapping("api/projects")
public class ProjectsController {
//	List<Project> list = new ArrayList<>();
//	Map<Integer,Project> cacheProjects = new HashMap<>();
	
	@GetMapping
	public List<ProjectVO> getProject() throws InterruptedException{
//		Date startDate = new Date();
//		if(cacheProjects.isEmpty()) {
//			for(int i=1;i<=5;i++) {
//				cacheProjects.put(i, new Project(i,"projectName"+i,startDate,i+5));
//			}
//		}
//		List<Project> list = cacheProjects.values().stream()
//				.collect(Collectors.toList());
		Thread.sleep(1000);
		List<ProjectVO> list = ProjectUtils.getProjects();
		return list;
		
	}
	
	@PostMapping
	public ProjectVO createProject(@RequestBody ProjectVO project) throws ParseException {
		ProjectVO proj = ProjectUtils.createProject(project);
//		String date = project.getDateOfStart();
//		SimpleDateFormat dtFrmt = new SimpleDateFormat("yyyy-MM-dd");
//		Date dt = dtFrmt.parse(date);
//		Project p= new Project(project.getProjectID(), project.getProjectName(),dt , project.getTeamSize());
//		list.add(p);
//		cacheProjects.put(project.getProjectID(), p);
		return proj;
	}
	
	@PutMapping
	public ProjectVO updateProject(@RequestBody ProjectVO project) throws ParseException {
//		Project proj = cacheProjects.get(project.getProjectID());
//		if(proj !=null) {
//			String date = project.getDateOfStart();
//			SimpleDateFormat dtFrmt = new SimpleDateFormat("yyyy-MM-dd");
//			Date dt = dtFrmt.parse(date);
//			
//			proj.setProjectName(project.getProjectName());
//			proj.setDateOfStart(dt);
//			proj.setTeamSize(project.getTeamSize());
//			proj.setActive(project.isActive());
//			proj.setStatus(project.getStatus());
//			proj.setClientLocationId(project.getClientLocationId());
//			return proj;
//		}else {
//			return null;
//		}
		return ProjectUtils.updateProject(project);
	}
	@DeleteMapping("{id}")
	public int deleteProject(@PathVariable("id") int projectID) {
		Project proj = ProjectUtils.cacheProjects.get(projectID);
		if(proj !=null) {
			ProjectUtils.cacheProjects.remove(projectID);
			
		}else {
			return -1;
		}
		return projectID;
		
	}
	
	@GetMapping("{searchBy}/{searchText}")
	public List<Project> search(@PathVariable("searchBy") String searchBy, @PathVariable("searchText") String text) throws ParseException{
		List<Project> list = new ArrayList<>();
		
		Map<Integer,Project> projCache = ProjectUtils.cacheProjects;
		
		if(searchBy.equalsIgnoreCase("ProjectID")) {
			Project p = projCache.get(Integer.valueOf(text));
			list.add(p);
			return list;
		}else if(searchBy.equalsIgnoreCase("ProjectName")) {
			List<Project> listCache = projCache.values().stream().filter(item -> item.getProjectName().contains(text))
					.collect(Collectors.toList());
			return listCache;
		}else if(searchBy.equalsIgnoreCase("DateOfStart")) {
			String date = text;
			SimpleDateFormat dtFrmt = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = dtFrmt.parse(date);
			List<Project> listCache = projCache.values().stream().filter(item -> item.getDateOfStart().equals(dt))
					.collect(Collectors.toList());
			return listCache;
		}else if(searchBy.equalsIgnoreCase("TeamSize")) {
			List<Project> listCache = projCache.values().stream().filter(item -> item.getTeamSize() == Integer.parseInt(text))
					.collect(Collectors.toList());
			return listCache;
		}
		return list;

	}
	
	@GetMapping("{ProjectID}")
	public ProjectVO search(@PathVariable("ProjectID") String projectId) throws ParseException{
		Map<Integer, Project> projCache = ProjectUtils.cacheProjects;
		Project proj = projCache.get(Integer.parseInt(projectId));
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = f.format(proj.getDateOfStart());
		return new ProjectVO(proj.getProjectID(), proj.getProjectName(), strDate, proj.isActive(), proj.getStatus(),
				proj.getClientLocationId(), proj.getClientLocation(), proj.getTeamSize());

	}
	
}
