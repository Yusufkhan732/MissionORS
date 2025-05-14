package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.co.rays.bean.TimeTableBean;
import in.co.rays.util.JDBCDataSource;

public class TimeTableModel {
	public int nextPK() {

		int pk = 0;

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from st_timetable");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public void add(TimeTableBean bean) throws Exception {

		Connection conn = null;

		int pk = nextPK();

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("insert into st_timetable values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getSemester());
			pstmt.setString(3, bean.getDescription());
			pstmt.setDate(4, new java.sql.Date(bean.getExamDate().getTime()));
			pstmt.setString(5, bean.getExamTime());
			pstmt.setLong(6, bean.getCourseId());
			pstmt.setString(7, bean.getCourseName());
			pstmt.setLong(8, bean.getSubjectId());
			pstmt.setString(9, bean.getSubjectName());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data inserted => " + i);
		} catch (SQLException e) {
			JDBCDataSource.trnRollback(conn);
		}
	}

	public TimeTableBean findbyPK(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_timetable where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		TimeTableBean bean = null;

		while (rs.next()) {
			bean = new TimeTableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public void update(TimeTableBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_timetable set semester=?, description=?, exam_date=?, exam_time=?, course_id=?, course_name=?, subject_id=?, subject_name=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id=? ");

			pstmt.setString(1, bean.getSemester());
			pstmt.setString(2, bean.getDescription());
			pstmt.setDate(3, new java.sql.Date(bean.getExamDate().getTime()));
			pstmt.setString(4, bean.getExamTime());
			pstmt.setLong(5, bean.getCourseId());
			pstmt.setString(6, bean.getCourseName());
			pstmt.setLong(7, bean.getSubjectId());
			pstmt.setString(8, bean.getSubjectName());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("data updated => " + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}

	public List search(TimeTableBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_timetable where 1=1");

		if (bean != null) {

			if (bean.getSubjectName() != null && bean.getSubjectName().length() > 0) {
				sql.append(" and subject_name like '" + bean.getSubjectName() + "%'");
			}
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new TimeTableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));

			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

	public TimeTableBean findByCourseID(int courseid) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_timetable where course_id = ?");

		pstmt.setLong(1, courseid);

		ResultSet rs = pstmt.executeQuery();

		TimeTableBean bean = null;

		while (rs.next()) {
			bean = new TimeTableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public void delete(long id) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_timetable where id = ?");
			pstmt.setLong(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();

			JDBCDataSource.closeConnection(conn);
			System.out.println("data deleted => " + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}
}