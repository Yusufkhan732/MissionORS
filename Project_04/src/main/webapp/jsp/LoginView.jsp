<%@page import="in.co.rays.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>

	<h1 align="center">Login</h1>

	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<center>


			<span style="color: red"><%=ServletUtility.getErrorMessage(request)%></span>
			<span style="color: green"><%=ServletUtility.getSuccessMessage(request)%></span>
			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your email"><font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"><font color="red">

							<%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"><input type="submit"
						name="operation" value="<%=LoginCtl.OP_SIGN_UP%>"></td>
				</tr>
			</table>
		</center>
	</form>
	<%@include file="Footer.jsp"%>

</body>
</html>