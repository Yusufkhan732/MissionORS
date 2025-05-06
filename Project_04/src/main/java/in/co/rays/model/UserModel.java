package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

import in.co.rays.Exception.ApplicationException;
import in.co.rays.Exception.DatabaseException;
import in.co.rays.Exception.DuplicateRecordException;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws DatabaseException {

		int pk = 0;

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(Id) from st_user");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				pk = rs.getInt(1);

			}

		} catch (Exception e) {

			throw new DatabaseException("Exception : Exception in getting PK " + e);
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {
		Connection conn = null;

		int pk = 0;

		UserBean existBean = findByLogin(bean.getLogin());
		if (existBean != null) {
			throw new DuplicateRecordException("login already sxist");

		}
		try {
			pk = nextPk();

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getConfirmpassword());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(8, bean.getMobileNo());
			pstmt.setLong(9, bean.getRoleId());
			pstmt.setString(10, bean.getGender());
			pstmt.setString(11, bean.getCreatedBy());
			pstmt.setString(12, bean.getModifiedBy());
			pstmt.setTimestamp(13, bean.getCreatedDatetime());
			pstmt.setTimestamp(14, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("Data insertd:" + i);

		} catch (Exception e) {
			try {
				conn.rollback();

			} catch (Exception ex) {

				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}

			throw new ApplicationException("Exception : Exception in add User " + e);

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
	}

	public void update(UserBean bean) throws Exception {
		Connection conn = null;

		UserBean existBean = findByLogin(bean.getLogin());

		if (existBean != null && bean.getId() != existBean.getId()) {
			throw new DuplicateRecordException("login already exist..!!");
		}

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set first_name = ?,last_name = ?,login = ?,password = ?,confirm_password = ?,dob = ?,mobile_no = ?,role_id = ?,gender = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setString(5, bean.getConfirmpassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.setLong(14, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("Data updated:" + i);

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {

				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User " + e);

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
	}

	public void delete(long id) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

			pstmt.setLong(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			JDBCDataSource.closeConnection(conn);

			System.out.println("Data deleted" + i);

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}

			throw new ApplicationException("Exception : Exception in delete User " + e);
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
	}

	public UserBean findBypk(long id) throws Exception {

		Connection conn = null;
		UserBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");
			pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();

				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setConfirmpassword(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setRoleId(rs.getLong(8));
				bean.setGender(rs.getString(10));
				bean.setCreatedBy(rs.getString(11));
				bean.setModifiedBy(rs.getString(12));
				bean.setCreatedDatetime(rs.getTimestamp(13));
				bean.setModifiedDatetime(rs.getTimestamp(14));
			}
		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in getting User by PK");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	public UserBean findByLogin(String login) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setRoleId(rs.getLong(8));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
		}

		JDBCDataSource.closeConnection(conn);
		return bean;

	}

	public UserBean authenticate(String login, String password) throws ApplicationException {

		Connection conn = null;
		UserBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ? and password = ?");

			pstmt.setString(1, login);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setConfirmpassword(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
				bean.setGender(rs.getString(10));
				bean.setCreatedBy(rs.getString(12));
				bean.setModifiedBy(rs.getString(12));
				bean.setCreatedDatetime(rs.getTimestamp(13));
				bean.setModifiedDatetime(rs.getTimestamp(14));
			}
		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in get roles " + e);
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	public List search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append("and first_name'" + bean.getFirstName() + "%'");

				System.out.println("sql==>" + sql.toString());
			}
		}
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setConfirmpassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setMobileNo(rs.getString(8));
			bean.setRoleId(rs.getLong(9));
			bean.setGender(rs.getString(10));
			bean.setCreatedBy(rs.getString(11));
			bean.setModifiedBy(rs.getString(12));
			bean.setCreatedDatetime(rs.getTimestamp(13));
			bean.setModifiedDatetime(rs.getTimestamp(14));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}
}
