package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {
		// testcollege();
		// testAdd();
		// testupdate();
		// testdelete();
		// testfindByPk();
		// testfindByName();
		testsearch();
	}

	public static void testcollege() {

		CollegeModel model = new CollegeModel();

		int i = model.nextPk();
		System.out.println("NextPk:" + i);

	}

	public static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setId(3);
		bean.setName("Rays");
		bean.setAddress("Madhumilan");
		bean.setState("MadhyaPradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("8899778995");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.add(bean);

	}

	public static void testupdate() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(3);
		bean.setName("Rays Technologies");
		bean.setAddress("Madhumilan");
		bean.setState("MadhyaPradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("8899778995");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);

	}

	public static void testdelete() throws Exception {
		CollegeModel model = new CollegeModel();
		model.delete(4);

	}

	public static void testfindByPk() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByPk(2);

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
		CollegeBean bean = model.findByName("ABC College");

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
		CollegeBean bean = new CollegeBean();

		CollegeModel model = new CollegeModel();

		List list = model.search(bean);

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
			System.out.println(bean.getModifiedDatetime());

		}
	}
}
