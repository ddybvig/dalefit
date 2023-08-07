package com.perficient.dalefit.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.dalefit.dao.ActivityDAOJpa;
import com.perficient.dalefit.entity.Activity;

@RestController
public class ActivityController {
	
	@Autowired
	ActivityDAOJpa jpa;

	@PostMapping("activity/save")
	public ResponseEntity<Void> addActivity(@RequestBody Activity activity) {
		jpa.save(activity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("activity/{activityId}")
	public Optional<Activity> getActivity(@PathVariable Long activityId) {
		return jpa.findById(activityId);
	}

	@DeleteMapping("delete-activity/{activityId}")
	public void deleteActivity(@PathVariable Long activityId) {
		jpa.deleteById(activityId);
	}
	
	@DeleteMapping("delete-all-activities")
	public void deleteAllActivities() {
		jpa.deleteAll();
	}
}
