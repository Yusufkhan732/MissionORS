package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {
		// testsearch();
		// testPk();
		// testAdd();
		// testupdate();
		// testdelete();
		// testByPk();
		// testByEmail();
		testlist();

	}

	public static void testPk() throws DatabaseException {
		StudentModel model = new StudentModel();

		int i = model.nextPK();
		System.out.println("next:" + i);

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentBean bean = new StudentBean();
		bean.setFirstName("Nusad");
		bean.setLastName("khan");
		bean.setDob(sdf.parse("2000-11-11 00:00:00"));
		bean.setGender("male");
		bean.setMobileNo("9988787689");
		bean.setEmail("nuasd@gmail.com");
		// bean.setCollegeName("Rays");
		bean.setCollegeId(4);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.add(bean);

	}

	public static void testupdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentBean bean = new StudentBean();

		bean.setId(131);
		bean.setFirstName("Neha");
		bean.setLastName("rathor");
		bean.setDob(sdf.parse("2002-11-11"));
		bean.setGender("female");
		bean.setMobileNo("9988787689");
		bean.setEmail("neha@gmail.com");
		bean.setCollegeName("Rays");
		bean.setCollegeId(10);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.Update(bean);

	}

	public static void testByPk() throws Exception {

		StudentModel model = new StudentModel();
		StudentBean bean = model.findByPK(110);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("Id not found");
		}

	}

	public static void testByEmail() throws Exception {

		StudentModel model = new StudentModel();
		StudentBean bean = model.findByEmailId("ishita@gmail.com");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("name not found");
		}

	}

	public static void testdelete() throws Exception {

		StudentBean bean = new StudentBean();
		bean.setId(132);
		StudentModel model = new StudentModel();
		model.delete(bean);
	}

	public static void testsearch() throws Exception {

		StudentBean be = new StudentBean();

		// be.setFirstName("Stuti");
		be.setId(130);

		StudentModel model = new StudentModel();

		List list = model.search(be);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			be = (StudentBean) it.next();
			System.out.print(be.getId());
			System.out.print("\t" + be.getFirstName());
			System.out.print("\t" + be.getLastName());
			System.out.print("\t" + be.getDob());
			System.out.print("\t" + be.getGender());
			System.out.print("\t" + be.getMobileNo());
			System.out.print("\t" + be.getEmail());
			System.out.print("\t" + be.getCollegeId());
			System.out.print("\t" + be.getCollegeName());
			System.out.print("\t" + be.getCreatedBy());
			System.out.print("\t" + be.getModifiedBy());
			System.out.print("\t" + be.getCreatedDatetime());
			System.out.println("\t" + be.getModifiedDatetime());

		}
	}

	public static void testlist() throws Exception {

		StudentBean be = new StudentBean();

		List list = new ArrayList();

		StudentModel model = new StudentModel();

		list = model.list(1, 20);

		// list = model.list();

		if (list.size() == 0) {
			System.out.println("test list fail");
		} else {
			System.out.println("test list pass");
		}

		Iterator it = list.iterator();

		while (it.hasNext()) {
			be = (StudentBean) it.next();
			System.out.print(be.getId());
			System.out.print("\t" + be.getFirstName());
			System.out.print("\t" + be.getLastName());
			System.out.print("\t" + be.getDob());
			System.out.print("\t" + be.getGender());
			System.out.print("\t" + be.getMobileNo());
			System.out.print("\t" + be.getEmail());
			System.out.print("\t" + be.getCollegeId());
			System.out.print("\t" + be.getCollegeName());
			System.out.print("\t" + be.getCreatedBy());
			System.out.print("\t" + be.getModifiedBy());
			System.out.print("\t" + be.getCreatedDatetime());
			System.out.println("\t" + be.getModifiedDatetime());

		}
	}
}
