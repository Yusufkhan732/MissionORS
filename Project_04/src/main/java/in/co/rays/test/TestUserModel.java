package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		// nextPK();
		// testsearch();
		// testAdd();
		// testUpdate();
		// testdelete();
		// testfindBypk();
		// testfindByLogin();
		// testauthenticate();
	}

	public static void nextPK() throws DatabaseException {

		UserModel model = new UserModel();
		int pk = model.nextPk();
		System.out.println("nextPK" + pk);
	}

	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();

		bean.setFirstName("yusuf");
		bean.setLastName("rathor");
		bean.setLogin("yusuf@gmail.com");
		bean.setPassword("yusuf123");
		bean.setDob(sdf.parse("2000-07-07"));
		bean.setMobileNo("9897798789");
		bean.setRoleId(44444);
		bean.setGender("male");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		UserModel model = new UserModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		bean.setId(5312);
		bean.setFirstName("Akash");
		bean.setLastName("mevada");
		bean.setLogin("akash@example.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2000-07-07"));
		bean.setMobileNo("9897798789");
		bean.setRoleId(44444);
		bean.setGender("male");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		UserModel model = new UserModel();
		model.update(bean);

	}

	public static void testdelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		model.delete(bean);
	}

	public static void testfindBypk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = model.findBypk(5312);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	public static void testfindByLogin() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByLogin("amit.sharma@example.com");

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	public static void testauthenticate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.authenticate("aastik@gmail.com", "Aastik@123");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	public static void testsearch() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		List list = model.search(bean, 1, 2);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
}
