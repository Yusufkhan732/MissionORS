package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.Exception.ApplicationException;
import in.co.rays.Exception.DatabaseException;
import in.co.rays.Exception.DuplicateRecordException;
import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.util.JDBCDataSource;

public class CollegeModel {

	/**
	 * Find next PK of College
	 *
	 * @throws DatabaseException
	 * 
	 */
	public Integer nextPk() throws DatabaseException {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID)FROM ST_COLLEGE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Exception: Exception getting pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	/**
	 * Add a College
	 *
	 * @param bean
	 * @throws ApplicationException
	 * @throws DatabaseException
	 *
	 */
	public long add(CollegeBean bean) throws ApplicationException {

		Connection conn = null;
		int pk = 0;

//		CollegeBean duplicateCollegeName = findByName(bean.getName());
//
//		if (duplicateCollegeName != null) {
//			throw new DuplicateRecordException("Exception:College Name alrady exsit");

		// }
		try {
			conn = JDBCDataSource.getConnection();

			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_college values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDatetime());
			pstmt.setTimestamp(10, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Data add");

		} catch (Exception e) {

			try {
				conn.rollback();
			} catch (Exception e2) {

				e2.printStackTrace();

				throw new ApplicationException("Exception: Add Rollback Exception" + e2.getMessage());

			}
			throw new ApplicationException("Exception: Exception  in add college");

		} finally {

			JDBCDataSource.closeConnection(conn);
		}

		return pk;

	}

	/**
	 * Delete a College
	 *
	 * @param bean
	 * @throws ApplicationException
	 * @throws DatabaseException
	 */

	public void delete(long id) throws ApplicationException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM  ST_COLLEGE WHERE ID = ?");

			pstmt.setLong(1, id);

			int i = pstmt.executeUpdate();

			pstmt.close();

			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();

			} catch (Exception e1) {

				throw new ApplicationException("Exception: delete rollback exeption" + e1.getMessage());
			}

			throw new ApplicationException("Exception: Exception  in delete college id");

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
	}

	/**
	 * Find User by College
	 *
	 * @param login : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */
	public CollegeBean findByName(String name) throws DatabaseException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COLLEGE WHERE NAME = ?");

		Connection conn = null;
		CollegeBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new CollegeBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDatetime(rs.getTimestamp(9));
				bean.setModifiedDatetime(rs.getTimestamp(10));

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new DatabaseException("Exception: Exception in getting college by name");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;

	}

	/**
	 * Find User by College
	 *
	 * @param pk : get parameter
	 * @return bean
	 * @throws ApplicationException
	 */

	public CollegeBean findByPk(long id) throws DatabaseException, ApplicationException {
		Connection conn = null;
		CollegeBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM  ST_COLLEGE WHERE ID = ?");

			pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CollegeBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDatetime(rs.getTimestamp(9));
				bean.setModifiedDatetime(rs.getTimestamp(10));
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new ApplicationException("Exception: Exception in college findbypk");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;

	}

	/**
	 * Update a College
	 *
	 * @param bean
	 * @throws DatabaseException
	 * @throws DuplicateRecordException
	 */
	public void update(CollegeBean bean) throws ApplicationException, DatabaseException {

		Connection conn = null;

		CollegeBean existBean = findByName(bean.getName());
		// Check if updated College already exist
		if (existBean != null && existBean.getId() != bean.getId()) {

			throw new ApplicationException("College is already exist");
		}
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE st_college SET NAME=?,ADDRESS=?,STATE=?,CITY=?,PHONE_NO=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setString(3, bean.getState());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			pstmt.setLong(10, bean.getId());
			pstmt.executeUpdate();
			conn.commit();

			pstmt.close();
		} catch (Exception e) {

			e.printStackTrace();

			throw new ApplicationException("Exception : rollback exeption" + e.getMessage());

			// throw new ApplicationException(" Exception updating college");

		} finally {

			JDBCDataSource.closeConnection(conn);
		}

	}

	/**
	 * Search College
	 *
	 * @param bean : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(CollegeBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/**
	 * Search College with pagination
	 *
	 * @return list : List of College
	 * @param bean     : Search Parameters
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 * @throws ApplicationException
	 *
	 * @throws DatabaseException
	 */
	public List search(CollegeBean bean, int pageNo, int pageSize) throws ApplicationException {

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_COLLEGE WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getState() != null && bean.getState().length() > 0) {
				sql.append(" and state like '" + bean.getState() + "%'");
			}
			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" and address like '" + bean.getAddress() + "%'");
			}
			if (bean.getCity() != null && bean.getCity().length() > 0) {
				sql.append(" and city like '" + bean.getCity() + "%'");
			}
			if (bean.getPhoneNo() != null && bean.getPhoneNo().length() > 0) {
				sql.append(" and phone like '" + bean.getPhoneNo() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		ArrayList list = new ArrayList();

		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new CollegeBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDatetime(rs.getTimestamp(9));
				bean.setModifiedDatetime(rs.getTimestamp(10));
				list.add(bean);

			}
		} catch (Exception e) {
			e.printStackTrace();

			throw new ApplicationException("Exception: search college list");

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

	/**
	 * Get List of College
	 *
	 * @return list : List of College
	 * @throws DatabaseException
	 */

	public List list() throws ApplicationException {
		return list(0, 0);
	}

	/**
	 * Get List of College with pagination
	 *
	 * @return list : List of College
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 * @throws ApplicationException
	 * @throws DatabaseException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {

		ArrayList list = new ArrayList();

		StringBuffer sql = new StringBuffer("SELECT * FROM st_college");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " ," + pageSize);

		}
		Connection conn = null;
		CollegeBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new CollegeBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDatetime(rs.getTimestamp(9));
				bean.setModifiedDatetime(rs.getTimestamp(10));
				list.add(bean);
			}

			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

			throw new ApplicationException("Exception :Exception in getting list of user");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}

}