<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<s:head/>
</head>
<body>

<s:form action="UserLogin" cssStyle="width:400px" >
<s:textfield  name="user.name"  label="Name" />

<s:password name="user.password" label="Password"/>

<s:submit value="Login"/>
</s:form>
<a href="<s:url action='UserForget'/>">Already have an account?</a>
<a href="UserReg.jsp">Create a new account</a>
</body>
</html>