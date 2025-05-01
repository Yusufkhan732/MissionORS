package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public Integer nextPk() {

		int pk = 0;
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				pk = rs.getInt(1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return pk + 1;
	}

	public void add(MarksheetBean bean) throws Exception {

		Connection conn = null;
		try {
			int pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, bean.getId());
			pstmt.setString(2, bean.getRollNo());
			pstmt.setLong(3, bean.getStudentId());
			pstmt.setString(4, bean.getName());
			pstmt.setInt(5, bean.getPhysics());
			pstmt.setInt(6, bean.getChemistry());
			pstmt.setInt(7, bean.getMaths());
			pstmt.setString(8, bean.getCreatedBy());
			pstmt.setString(9, bean.getModifiedBy());
			pstmt.setTimestamp(10, bean.getCreatedDatetime());
			pstmt.setTimestamp(11, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			conn.commit();
			JDBCDataSource.closeConnection(conn);
			System.out.println("Data inserted" + i);
		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}

	public void update(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			int pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update st_marksheet set roll_no =?,student_id =?,name =?,physics=?,chemistry=?,maths=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime =? where id = ?");

			pstmt.setString(1, bean.getRollNo());
			pstmt.setLong(2, bean.getStudentId());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setInt(6, bean.getMaths());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());
			pstmt.setLong(11, bean.getId());
			int i = pstmt.executeUpdate();
			conn.commit();
			JDBCDataSource.closeConnection(conn);
			System.out.println("Data updated" + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}

	public void delete(long id) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");
			pstmt.setLong(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);
			System.out.println("Data deleted" + i);

		} catch (Exception e) {
			JDBCDataSource.trnRollback(conn);
		}
	}

	public MarksheetBean findByName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where name = ?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		if(rs.next()) {
			bean = new MarksheetBean();
			pstmt.setLong(1, bean.getId());
			pstmt.setString(2, bean.getRollNo());
			pstmt.setLong(3, bean.getStudentId());
			pstmt.setString(4, bean.getName());
			pstmt.setInt(5, bean.getPhysics());
			pstmt.setInt(6, bean.getChemistry());
			pstmt.setInt(7, bean.getMaths());
			pstmt.setString(8, bean.getCreatedBy());
			pstmt.setString(9, bean.getModifiedBy());
			pstmt.setTimestamp(10, bean.getCreatedDatetime());
			pstmt.setTimestamp(11, bean.getModifiedDatetime());

		}
		JDBCDataSource.trnRollback(conn);
		return bean;
	}
}
