package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class FacultyModel {

	
	public Integer nextPk() {

		int pk = 0;
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_faculty");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				pk = rs.getInt(1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return pk + 1;
	}
}
