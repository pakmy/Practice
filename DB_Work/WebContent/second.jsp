<%@page import="com.mbb.demo.ProductDAO" %>
<%@page import="com.mbb.demo.EmployeeDAO" %>
<%@page import="java.sql.*" %>
<html>
<body bgcolor="yellow">
<table border="4">
<jsp:useBean id="emp" class="com.mbb.bean.Employee"/>
<jsp:setProperty property="*" name="emp"/>
<%ResultSet r=EmployeeDAO.selectAll(); 
while(r.next())
{
%>
<% if(emp.getLoginid().equals(r.getString(1))&& emp.getPassword().equals(r.getString(2)))
{
	String usr=request.getParameter("loginid");
	session.setAttribute("xxx", usr);
	String redirectURL = "product.html";
	response.sendRedirect(redirectURL);
}
else{
	//out.println("Wrong Id/Password");
	String redirectURL = "index.html";
    response.sendRedirect(redirectURL);
}
%>

<%} %>
</body>
</html>
