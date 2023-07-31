package com.perficient.dalefit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.dalefit.dao.SportDAO;
import com.perficient.dalefit.entity.Sport;

@RestController
public class SportController {
	
	@Autowired
	SportDAO sportDao;

	@PostMapping("sport/save")
	public ResponseEntity<Void> addSport(@RequestBody Sport sport) {
		sportDao.save(sport);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("sports")
	public ResponseEntity<List<Sport>> getAllSports() {
		return new ResponseEntity<List<Sport>>(sportDao.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("delete-sport/{sportId}")
	public void deleteSport(@PathVariable Long sportId) {
		sportDao.deleteById(sportId);
	}
	
}