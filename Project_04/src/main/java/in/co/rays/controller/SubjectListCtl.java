package in.co.rays.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.Exception.ApplicationException;
import in.co.rays.Exception.DatabaseException;
import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CourseBean;
import in.co.rays.bean.SubjectBean;
import in.co.rays.model.CourseModel;
import in.co.rays.model.SubjectModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "SubjectListCtl", urlPatterns = "/ctl/SubjectListCtl")
public class SubjectListCtl extends BaseCtl {

	@SuppressWarnings("unchecked")
	@Override
	protected void preload(HttpServletRequest request) {
		SubjectModel subjectModel = new SubjectModel();
		CourseModel courseModel = new CourseModel();

		try {
			List<SubjectBean> subjectList = subjectModel.list(0, 0);
			request.setAttribute("SubjectList", subjectList);

			List<CourseBean> courseList = courseModel.list(0, 0);
			request.setAttribute("CourseList", courseList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		SubjectBean bean = new SubjectBean();
		bean.setId(DataUtility.getLong(request.getParameter("subjectId")));
		bean.setCourseId(DataUtility.getLong(request.getParameter("courseId")));
		populateDTO(bean, request);
		return bean;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("insdie get method subject ctl");
		List list = null;
		List next = null;

		int pageNo = 1;

		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		SubjectBean bean = (SubjectBean) populateBean(request);

		@SuppressWarnings("unused")
		String op = DataUtility.getString(request.getParameter("operation"));

		SubjectModel model = new SubjectModel();
		try {

			list = model.search(bean, pageNo, pageSize);

			next = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("nextlist", next.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ServletUtility.setList(list, request);
		if (list == null || list.size() == 0) {
			ServletUtility.setErrorMessage("No record found ", request);
		}
		request.setAttribute("nextListSize", next.size());
		ServletUtility.setList(list, request);
		//Collections.sort(list);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list = null;
		List next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		SubjectBean bean = (SubjectBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));
		SubjectModel model = new SubjectModel();

		// get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}
			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.SUBJECT_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					SubjectBean deletebean = new SubjectBean();
					for (String id : ids) {
						deletebean.setId(DataUtility.getInt(id));
						model.Delete(deletebean);
						ServletUtility.setSuccessMessage("Data is deleted successfully", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select at least one record", request);
				}
			} else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.SUBJECT_LIST_CTL, request, response);
				return;
			} else if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
				return;
			}

			list = model.search(bean, pageNo, pageSize);
			Collections.sort(list);
			ServletUtility.setBean(bean, request);
			next = model.search(bean, pageNo + 1, pageSize);
			ServletUtility.setList(list, request);
			if (!OP_DELETE.equalsIgnoreCase(op)) {
				if (list == null || list.size() == 0) {
					ServletUtility.setErrorMessage("No record found ", request);
				}
			}
			// ServletUtility.setList(list, request);
			// ServletUtility.setBean(bean, request);
			request.setAttribute("nextListSize", next.size());
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {

			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		return ORSView.SUBJECT_LIST_VIEW;
	}

}
