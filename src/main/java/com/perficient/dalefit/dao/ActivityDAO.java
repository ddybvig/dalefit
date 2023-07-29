package com.perficient.dalefit.dao;

import java.sql.SQLException;

import com.perficient.dalefit.entity.Activity;

public interface ActivityDAO {

	public Activity[] findAll() throws SQLException;
}
