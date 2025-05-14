package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.util.DataValidator;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "LoginCtl", urlPatterns = { "/LoginCtl" })
public class LoginCtl extends BaseCtl {

	public static final String OP_SIGN_IN = "SignIn";

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean isValid = true;

		System.out.println("Email:" + request.getParameter("login"));
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected String getView() {
		return ORSView.LOGIN_VIEW;
	}

}
