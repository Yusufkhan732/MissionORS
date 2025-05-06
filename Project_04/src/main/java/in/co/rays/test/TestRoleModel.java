package in.co.rays.test;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

		// testnextPk();
		// testAdd();
		// testUpdate();
		// testdelete();
		//testfindBypk();
		// testfindByName();
		// testsearch();
	}

	public static void testnextPk() {

		RoleModel model = new RoleModel();

		int i = model.nextPk();
		System.out.println("NextPk is:" + i);

	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();

		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setId(4);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();
		model.Update(bean);

	}

	public static void testdelete() throws Exception {

		RoleModel model = new RoleModel();
		model.delete(4);

	}

	public static void testfindBypk() throws Exception {

		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		bean = model.findBypk(1);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("id not found");
		}
	}

	public static void testfindByName() throws Exception {

		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		bean = model.findByName("kiosk");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("name not found");
		}
	}

	public static void testsearch() throws Exception {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();

		bean.setModifiedBy("root");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (RoleBean) it.next();
//			System.out.print(bean.getId());
//			System.out.print("\t" + bean.getName());
//			System.out.print("\t" + bean.getDescription());
//			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
//			System.out.print("\t" + bean.getCreatedDatetime());
//			System.out.println("\t" + bean.getModifiedDatetime());
//
		}
	}
}