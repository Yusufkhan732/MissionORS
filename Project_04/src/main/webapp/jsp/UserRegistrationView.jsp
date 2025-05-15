
<%@page import="in.co.rays.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddUser</title>
</head>
<body>
	<jsp:useBean id="bean" class="in.co.rays.bean.UserBean" scope="request"></jsp:useBean>

	<%@include file="Header.jsp"%>

	<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">
		<div align="center">
			<h1 style="color: purple;">Add User</h1>
		</div>

		<center>
			<table>



				<tr>
					<th>First Name<span style="color: red;">*</span>:
					</th>

					<td><input type="text" name="firstName"
						placeholder="Enter First Name" size="26" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font>

					</td>

				</tr>

				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>

				<tr>
					<th>Last Name<span style="color: red;">*</span>:

					</th>

					<td><input type="text" name="lastName"
						placeholder="Enter Last Name" size="26" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("lastName", request)%>

					</font></td>

				</tr>
				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>
				<tr>
					<th>LoginId<span style="color: red;">*</span>:
					</th>

					<td><input type="text" name="login"
						placeholder="Ener Login Id" size="26" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("login", request)%>
					</font></td>
				</tr>

				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>

				<tr>
					<th>Gender<span style="color: red;">*</span>:

					</th>

					<td>
						<%
							HashMap map = new HashMap();

							map.put("Male", "Male");
							map.put("Female", "Female");

							String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%> <%=htmlList%> <font color="red"><%=ServletUtility.getErrorMessage("gender", request)%></font>

					</td>
				</tr>
				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>
				<tr>
					<th>Date of Birth<span style="color: red;">*</span>:

					</th>
					<td><input type="date" name="dob" placeholder="Ener Dob"
						size="26" style="width: 98%" value=""><font color="red"><%=ServletUtility.getErrorMessage("dob", request)%>

					</font></td>

				</tr>

				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>

				<tr>
					<th>Mobile No<span style="padding: 3px;"></span>:
					</th>

					<td><input type="text" name="mobileNo"
						placeholder="Enter Mobile No" size="26" maxlength="10" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("mobileNo", request)%>

					</font></td>

				</tr>
				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>
				<tr>
					<th>Password<span style="color: red;">*</span>:
					</th>

					<td><input type="password" name="password"
						placeholder="Enter Password" size="26" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("password", request)%>

					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px;"></th>
					<td></td>
				</tr>
				<tr>
					<th>Confirm Password <span style="color: red">*</span>:
					</th>
					<td><input type="password" name="password"
						placeholder="Enter Password" size="26" value=""><font
						color="red"><%=ServletUtility.getErrorMessage("password", request)%></font>
					</td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>

					<td></td>
				</tr>

				<tr>
					<th></th>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=UserRegistrationCtl.OP_SIGN_UP%>">
						&nbsp; <input type="submit" name="operation"
						value="<%=UserRegistrationCtl.OP_RESET%>">
					</td>
				</tr>
			</table>
		</center>
	</form>
	<%@include file="Footer.jsp"%>
</html>