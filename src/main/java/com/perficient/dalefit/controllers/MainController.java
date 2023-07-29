package com.perficient.dalefit.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.dalefit.dao.ActivityDAOJdbc;
import com.perficient.dalefit.dao.ActivityDAOJdbcTemplate;
import com.perficient.dalefit.dao.ActivityDAOJpa;
import com.perficient.dalefit.entity.Activity;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class MainController {
	
	@Autowired
	ActivityDAOJdbcTemplate db;
	
	@Autowired
	ActivityDAOJdbc pure;
	
	@Autowired
	ActivityDAOJpa jpa;
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/")
	public ResponseEntity<List<Activity>> home() {
		return new ResponseEntity<List<Activity>>(jpa.findAll(), HttpStatus.OK);
	}
	
	//non-jpa DAO implementations
	
	@GetMapping("template")
	public String helloJdbcTemplate() {
		//return db.findAll().toString();
		return "jdbc template impl stub";
	}
	
	@GetMapping("pure")
	public String helloPureJdbc() throws SQLException {
		//return "added JPA dependencies " + pure.findAll().toString();
		return "pure jdbc impl stub";
	}
	

	
}
