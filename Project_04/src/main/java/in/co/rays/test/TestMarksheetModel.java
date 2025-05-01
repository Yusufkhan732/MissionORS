package in.co.rays.test;

import java.security.spec.MGF1ParameterSpec;
import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		testfindByName();

	}

	public static void testmarksheet() {

		MarksheetModel model = new MarksheetModel();

		int i = model.nextPk();
		System.out.println("NextPk:" + i);

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(1);
		bean.setRollNo("R104");
		bean.setStudentId(101);
		bean.setName("Alice");
		bean.setPhysics(89);
		bean.setChemistry(80);
		bean.setMaths(67);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(1);
		bean.setRollNo("R104");
		bean.setStudentId(101);
		bean.setName("Rohit");
		bean.setPhysics(90);
		bean.setChemistry(70);
		bean.setMaths(67);
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(4);

	}

	public static void testfindByName() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByName("Nikita");
		while (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.println("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}
}
