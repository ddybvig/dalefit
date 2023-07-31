package com.perficient.dalefit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.perficient.dalefit.entity.Sport;

public interface SportDAO extends CrudRepository<Sport, Long>{
	List<Sport> findAll();
}
