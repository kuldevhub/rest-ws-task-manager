package com.restws.ui.controller.taskmanger;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.ui.model.taskmanager.ClientLocation;
import com.restws.com.restws.ui.util.ProjectUtils;

@CrossOrigin("http://localhost:4200")
//@CrossOrigin
@RestController
@RequestMapping("api/clientlocations")
public class ClientLocationController {

	@GetMapping
	public List<ClientLocation> getClentLocations(){
		
		return ProjectUtils.getClentLocations();
	}

}
