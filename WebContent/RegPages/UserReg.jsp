<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login / Registration Demo</title>
<script language="javascript">
function validatePassword()
{
	var passwordinput=document.getElementById("password");
	var confirminput=document.getElementById("confirm_password");
	//if(passwordinput.value!=null || passwordinput.value=="" || confirmpassw)
	//console.log(passwordinput.value);
	//alert(passwordinput.text);
}
</script>
<s:head/>
</head>
<body>

<s:form validate="true" action="CreateUser.action" method="POST" namespace="/RegPages"  >
<s:textfield name="name" label="Name" />
<s:textfield name="email" label="Email"/>
<s:password name="password" label="Password" id="password" /><img id="validateicon" src="image/check.gif"/>
<s:password name="confirmpassword" label="Confirm" id="confirm_password" />

<s:submit value="Create User"/>
</s:form>
</body>
</html>