<%@page import="com.mbb.demo.CustomerDAO" %>
<%@page import="com.mbb.demo.ProductDAO" %>
<%@page import="java.sql.*" %>
<html>
<body bgcolor="yellow">
<jsp:useBean id="emp" class="com.mbb.bean.Customer"/>
<jsp:setProperty property="*" name="emp"/>
<%=CustomerDAO.insert(emp) %>
<table border="4">
<tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th></tr>
<%ResultSet r=ProductDAO.selectAll(); 
while(r.next())
{
%>
<tr><td><%=r.getInt(1) %></td><td><%=r.getString(2) %></td><td><%=r.getInt(3)%></td></tr>
	<select>
		<option><%=r.getInt(1) %></option>
	    <option><%=r.getString(2) %></option>
	    <option><%=r.getInt(3) %></option>
	</select>
<%} %>
</body>
</html>