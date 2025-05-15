package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "LoginCtl", urlPatterns = { "/LoginCtl" })
public class LoginCtl extends BaseCtl {

	public static final String OP_SIGN_IN = "SignIn";

	public static final String OP_SIGN_UP = "SignUp";

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean isValid = true;

		String op = DataUtility.getString(request.getParameter("operation"));

		if (OP_SIGN_UP.equalsIgnoreCase(op) || OP_LOG_OUT.equalsIgnoreCase(op)) {

			isValid = true;
			return isValid;
		}

		if (DataValidator.isNull(request.getParameter("login"))) {

			System.out.println("login is required");
			request.setAttribute("login", "login is required");

			return isValid = false;
		}
		System.out.println("password:" + request.getParameter("password"));
		if (DataValidator.isNull(request.getParameter("password"))) {

			System.out.println("password is required");
			request.setAttribute("password", "password is required");

			return isValid = false;
		}
		return isValid;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		HttpSession session = request.getSession();

		if (OP_LOG_OUT.equalsIgnoreCase(op) || op != null) {

			session.invalidate();

			ServletUtility.setSuccessMessage("User logout successfull", request);
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		RoleModel model2 = new RoleModel();
		RoleBean bean2 = new RoleBean();

		bean = (UserBean) populateBean(request);

		HttpSession session = request.getSession();

		if (OP_SIGN_IN.equalsIgnoreCase(op)) {

			try {

				bean = model.authenticate(bean.getLogin(), bean.getPassword());

				if (bean != null) {

					session.setAttribute("user", bean);

					bean2 = model2.findBypk(bean.getRoleId());

					session.setAttribute("role", bean2.getName());

					ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);

				} else {

					ServletUtility.setErrorMessage("invalid login or password", request);

					ServletUtility.forward(getView(), request, response);
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		if (OP_SIGN_UP.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);

		}
		System.out.println("loginCtl post methofd");
	}

	@Override
	protected String getView() {

		return ORSView.LOGIN_VIEW;
	}

}
