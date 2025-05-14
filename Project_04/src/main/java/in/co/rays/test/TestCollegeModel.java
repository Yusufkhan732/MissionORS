package in.co.rays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {
		// testNextPk();
		// testAdd();
		// testupdate();
		// testdelete();
		// testfindByPk();
		// testfindByName();
		// testsearch();
		testlist();
	}

	public static void testNextPk() throws Exception {

		CollegeModel model = new CollegeModel();

		int i = model.nextPk();

		System.out.println("nextpk" + i);

	}

	public static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setName(" University");
		bean.setAddress("dya road");
		bean.setState("dhyaPradesh");
		bean.setCity("hopal");
		bean.setPhoneNo("9199778995");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.add(bean);

	}

	public static void testupdate() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(12);
		bean.setName("kl");
		bean.setAddress("Madhumilan");
		bean.setState("MadhyaPradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("999778995");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);

	}

	public static void testdelete() throws Exception {
		CollegeModel model = new CollegeModel();
		model.delete(13);

	}

	public static void testfindByPk() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByPk(9);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());

		} else {
			System.out.println("Id not found");
		}
	}

	public static void testfindByName() throws Exception {

		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByName("MIT");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		} else {
			System.out.println("name not found");
		}
	}

	public static void testsearch() throws Exception {
		CollegeBean be = new CollegeBean();

		// be.setCity("Indore");

		be.setName("Vikram");

		CollegeModel model = new CollegeModel();

		List list = model.search(be);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			be = (CollegeBean) it.next();
			System.out.print(be.getId());
			System.out.print("\t" + be.getName());
			System.out.print("\t" + be.getAddress());
			System.out.print("\t" + be.getState());
			System.out.print("\t" + be.getCity());
			System.out.print("\t" + be.getPhoneNo());
			System.out.print("\t" + be.getCreatedBy());
			System.out.print("\t" + be.getModifiedBy());
			System.out.print("\t" + be.getCreatedDatetime());
			System.out.println("\t" + be.getModifiedDatetime());

		}
	}

	public static void testlist() throws Exception {
		CollegeBean bean = new CollegeBean();

		List list = new ArrayList();

		CollegeModel model = new CollegeModel();

		//list = model.list(1, 2);
		
		list = model.list(); // ye pura data lane ke liye
//
//		if (list.size() == 0) {
//			System.out.println("Test list fail");
//		} else {
//			System.out.println("test List pass");
//		}

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}
}
