<%@page import="com.mbb.demo.CustomerDAO" %>
<%@page import="com.mbb.demo.ProductDAO" %>
<%@page import="java.sql.*" %>
<html>
<body bgcolor="yellow">
<jsp:useBean id="emp" class="com.mbb.bean.Customer"/>
<jsp:setProperty property="*" name="emp"/>
<%=CustomerDAO.insert(emp) %>

<form action="ex2.jsp">

<table>
<thead>
<tr><th></th><th>ProductId</th><th>ProductName</th><th>ProductPrice</th></tr>
</thead>
<tbody>
<% ResultSet r=ProductDAO.selectAll(); 

while(r.next())
{%>
<tr> <td><input type="checkbox" name ="product" value = "<%=r.getInt(3) %>"/></td><td> <%=r.getInt(1) %></td><td><%=r.getString(2) %></td><td><%=r.getInt(3)%></td></tr>
<%} %>
</tbody>
</table>
<input type = "submit">
</form>
</body>
</html>
