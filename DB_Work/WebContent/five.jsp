<%@page import="com.mbb.demo.ProductDAO" %>
<html>
<body bgcolor="pink">
<jsp:useBean id="emp" class="com.mbb.bean.Product"/>
<jsp:setProperty property="*" name="emp"/>
<%=ProductDAO.delete(emp)+" record deleted successfully..." %>
</body>
</html>