package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.bean.SubjectBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.StudentModel;
import in.co.rays.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {
		// testPk();
		// testAdd();
		// testupdate();
		// testByPk();
		// testByName();
		// testsearch();
		testlist();

	}

	private static void testPk() throws DatabaseException {
		SubjectModel model = new SubjectModel();

		int i = model.nextPK();
		System.out.println("nextPk:" + i);

	}

	public static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();
		bean.setId(9004);
		bean.setSubjectName("ITI");
		bean.setCourseId(233);
		bean.setCourseName("fff");
		bean.setDescription("fgushshdj");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.add(bean);

	}

	public static void testupdate() throws Exception {

		SubjectBean bean = new SubjectBean();
		bean.setId(9003);
		bean.setSubjectName("maths");
		bean.setCourseId(55);
		bean.setCourseName("KCA");
		bean.setDescription("MCA is a Gradutation Course");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.update(bean);
	}

	public static void testByPk() throws Exception {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.FindByPK(4001);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("Id not found");
		}

	}

	public static void testByName() throws Exception {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByName("maths");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("name not found");
		}

	}

	public static void testdelete() throws Exception {

		SubjectModel model = new SubjectModel();
		// model.Delete(9003);
	}

	public static void testsearch() throws Exception {

		SubjectBean bean = new SubjectBean();

		SubjectModel model = new SubjectModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (SubjectBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}

	public static void testlist() throws Exception {
		SubjectBean bean = new SubjectBean();

		List list = new ArrayList();

		SubjectModel model = new SubjectModel();

		// list = model.list(1, 2);

		list = model.list(); // ye pura data lane ke liye
//
//		if (list.size() == 0) {
//			System.out.println("Test list fail");
//		} else {
//			System.out.println("test List pass");
//		}

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
}
