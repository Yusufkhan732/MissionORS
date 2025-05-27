package in.co.rays.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MarksheetCtl", urlPatterns = { "/ctl/MarksheetCtl" })
public class MarksheetCtl extends BaseCtl {

	@Override
	protected String getView() {
		return null;
	}

}
