package com.restws.ui.controller.taskmanger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.ui.model.taskmanager.Project;

@RestController
@RequestMapping("api/projects")
public class ProjectsController {
	@GetMapping
	public List<Project> getProject(){
		
		List<Project> list = new ArrayList<>();
		Date startDate = new Date();
		
		for(int i=1;i<=5;i++) 
			list.add(new Project(i,"projectName"+i,startDate,i+5));
		return list;
		
	}
}
