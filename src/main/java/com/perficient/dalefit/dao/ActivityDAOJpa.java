package com.perficient.dalefit.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.perficient.dalefit.entity.Activity;

//any reason to use CrudRepository vs. JpaRepository? Are they equivalent? Pros/cons of each?

public interface ActivityDAOJpa extends CrudRepository<Activity, Long> {
	List<Activity> findAll();
	List<Activity> findAllOrderByDate(LocalDate date);
	List<Activity> findByOrderByDateDesc();
}
