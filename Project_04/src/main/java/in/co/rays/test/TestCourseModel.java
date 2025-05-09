package in.co.rays.test;

import java.beans.beancontext.BeanContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {

		// testNextPk();
		// testFindByPK();
		// testadd();
		//testUpdate();
		// testSearch();
		// testFindByName();
		// testDelete();

	}

	private static void testNextPk() throws DatabaseException {

		CourseModel model = new CourseModel();

		int i = model.nextPK();

		System.out.println("nexPk is: " + i);
	}

	private static void testFindByPK() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = model.FindByPK(44);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testadd() throws Exception {

		CourseBean bean = new CourseBean();
		bean.setId(56);
		bean.setName("DCA");
		bean.setDuration("2 year");
		bean.setDescription("DCA in Computer Science");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(56);
		bean.setName("CAA");
		bean.setDuration("2 year ");
		bean.setDescription("Charted Account");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.update(bean);
	}

	private static void testSearch() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CourseBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testFindByName() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = model.findByName("B.Tech");

		while (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.print("\t" + bean.getModifiedDatetime());
		}
	}

	private static void testDelete() throws Exception {

		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();
		//model.Delete(bean.getId());
	}

}
