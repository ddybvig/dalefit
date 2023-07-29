package com.perficient.dalefit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.perficient.dalefit.entity.Activity;

@Repository
public class ActivityDAOJdbc implements ActivityDAO {
	
	//final String ACTIVITY_FIND_ALL = "select * from activity";

	@Override
	public Activity[] findAll() throws SQLException {
		
		List<Activity> foundList = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/activityTracker","root","rootroot");
		String selectStatement = "select * from activity";
		stmt = con.prepareStatement(selectStatement);
		resultSet = stmt.executeQuery();
		while (resultSet.next()) {
			Activity a = new Activity();
			//commenting all setters this will be a stub now
			//a.setId(resultSet.getLong("id"));
			//a.setTitle(resultSet.getString("title"));
			//a.setDescription(resultSet.getString("description"));
			foundList.add(a);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return foundList.toArray(new Activity[foundList.size()]);
	}

}
