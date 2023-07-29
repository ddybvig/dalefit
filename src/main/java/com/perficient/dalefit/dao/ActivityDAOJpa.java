package com.perficient.dalefit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.perficient.dalefit.entity.Activity;

public interface ActivityDAOJpa extends CrudRepository<Activity, Long> {
	List<Activity> findAll();
}
