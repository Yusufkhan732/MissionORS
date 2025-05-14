package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.FacultyBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.FacultyModel;

public class TestFacultyModel {

	public static void main(String[] args) throws Exception {

		 testsearch();
		// testAdd();
//		 testUpdate();
		// testfindByCollegeId();
		// testdelete();
		// testfindByPk();
		// testfindByName();
		//testlist();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FacultyBean bean = new FacultyBean();
		bean.setId(1);
		bean.setFirstName("Yusuf");
		bean.setLastName("Khan");
		bean.setDob(sdf.parse("2002-02-8"));
		bean.setGender("M");
		bean.setMobileNo("9199909089");
		bean.setEmail("yusuf@gmail.com");
		bean.setCollegeId(104);
		bean.setCollegeName("RNT University");
		bean.setCourseId(206);
		bean.setCourseName("Java");
		bean.setSubjectId(307);
		bean.setSubjectName("Core_java");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FacultyBean bean = new FacultyBean();
		bean.setId(20);
		bean.setFirstName("Nikita");
		bean.setLastName("Meena");
		bean.setDob(sdf.parse("2002-02-08"));
		bean.setGender("female");
		bean.setMobileNo("8899909089");
		bean.setEmail("neha@gmail.com");
		bean.setCollegeId(1);
		bean.setCollegeName("ABC College");
		bean.setCourseId(789);
		bean.setCourseName("Biology");
		bean.setSubjectId(980);
		bean.setSubjectName("Genetics");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.update(bean);
	}

	public static void testdelete() throws Exception {
		FacultyBean bean = new FacultyBean();
		bean.setId(2);

	}

	public static void testfindByPk() throws Exception {

		FacultyModel model = new FacultyModel();

		FacultyBean bean = model.findByPK(700001);

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	public static void testfindByCollegeId() throws Exception {

		FacultyModel model = new FacultyModel();

		FacultyBean bean = model.findByCollegeId(1);

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	public static void testfindByName() throws Exception {

		FacultyModel model = new FacultyModel();

		FacultyBean bean = model.findByEmailId("");

		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	public static void testsearch() throws Exception {

		List list = new ArrayList();
		FacultyBean bean = new FacultyBean();

		bean.setFirstName("Amit");

		FacultyModel model = new FacultyModel();

		//list = model.search(bean);
		list = model.search(bean, 1, 20);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	public static void testlist() throws Exception {

		FacultyBean bean = new FacultyBean();

		List list = new ArrayList();

		FacultyModel model = new FacultyModel();

		list = model.list(1, 10);
		// list = model.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}
}
