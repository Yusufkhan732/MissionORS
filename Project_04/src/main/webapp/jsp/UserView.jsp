<%@page import="in.co.rays.controller.UserCtl"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List l = (List) request.getAttribute("list");
	%>

	<jsp:useBean id="bean" class="in.co.rays.bean.UserBean" scope="request"></jsp:useBean>

	<%@ include file="Header.jsp"%>
	<form action="<%=ORSView.USER_CTL%>" method="post">
		<center>
			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1 align="center">Update User</h1>
			<%
				} else {
			%>
			<h1 align="center">Add User</h1>
			<%
				}
			%>
			<span style="color: green"><%=ServletUtility.getSuccessMessage(request)%></span>
			<input type="hidden" name="id"
				value="<%=DataUtility.getStringData(String.valueOf(bean.getId()))%>">
			<table>
				<tr>
					<th>First Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="firstName"
						placeholder="Enter First Name" size="26"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>">
						<font color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font>
					</td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Last Name <span style="color: red">*</span> :
					</th>
					<td><input type="text" name="lastName"
						placeholder="Enter last Name" size="26"
						value="<%=DataUtility.getStringData(bean.getLastName())%>">
						<font color="red"><%=ServletUtility.getErrorMessage("lastName", request)%></font>
					</td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>LoginId <span style="color: red">*</span> :
					</th>
					<td><input type="text" name="login"
						placeholder="Enter valid Email-Id" size="26"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"> <font
						color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Gender <span style="color: red">*</span> :
					</th>
					<td>
						<%
							HashMap map = new HashMap();

							map.put("Male", "Male");
							map.put("Female", "Female");
							map.put("Other", "Other");

							String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%> <%=htmlList%> <font color="red"><%=ServletUtility.getErrorMessage("gender", request)%></font>
					</td>
				</tr>

				<tr>
					<th align="left">Role <span style="color: red">*</span> :
					</th>
					<td><%=HTMLUtility.getList("roleId", String.valueOf(bean.getRoleId()), l)%></td>
					<td style="position: fixed"><font style="position: fixed"
						color="red"> <%=ServletUtility.getErrorMessage("roleId", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Date Of Birth <span style="color: red">*</span> :
					</th>
					<td><input type="date" name="dob" size="26"
						placeholder="Enter Dob "
						value="<%=DataUtility.getDateString(bean.getDob())%>"> <font
						color="red"><%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Mobile No <span style="color: red">*</span> :
					</th>
					<td><input type="text" name="mobileNo"
						placeholder="Enter Mobile No" size="26" maxlength="10"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Password <span style="color: red">*</span> :
					</th>
					<td><input type="password" name="password"
						placeholder="Enter Password" size="26"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"><font
						color="red"><%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>

				<tr>
					<th>Confirm Password <span style="color: red">*</span> :
					</th>
					<td><input type="password" name="confirmPassword"
						placeholder="Re-Enter password" size="26"
						value="<%=bean != null && bean.getId() > 0 ? DataUtility.getStringData(bean.getPassword())
					: bean.getConfirmpassword()%>"><font
						color="red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
					<td></td>
				</tr>


				<tr>
					<th></th>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation"
						value="<%=bean != null && bean.getId() > 0 ? UserCtl.OP_UPDATE : UserCtl.OP_SAVE%>">
					</td>
				</tr>
			</table>
		</center>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>