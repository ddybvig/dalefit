package com.perficient.dalefit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.perficient.dalefit.entity.Activity;

@Repository
public class ActivityDAOJdbcTemplate implements ActivityDAO {
	
	final String ACTIVITY_FIND_ALL = "select * from activity";

    @Autowired
    JdbcTemplate jdbc;

    public static final class ActivityMapper implements RowMapper<Activity> {

        @Override
        public Activity mapRow(ResultSet rs, int index) throws SQLException {
            Activity a = new Activity();
            //commenting all setters for now this will just be a stub
            //a.setId(rs.getLong("id"));
            //a.setTitle(rs.getString("title"));
            //a.setDescription(rs.getString("description"));
            return a;
        }
    }
	
	@Override
	public Activity[] findAll() {
		List<Activity> foundList = jdbc.query(ACTIVITY_FIND_ALL, new ActivityMapper());
		return foundList.toArray(new Activity[foundList.size()]);
	}

}
