<%@page import = "java.sql.*"%>
<html>
<body bgcolor="pink">

<%
int sum=0;
String[] selectedProductPrices = request.getParameterValues("product");

for(int i=0; i<selectedProductPrices.length; i++)
{
	sum = sum+Integer.parseInt(selectedProductPrices[i]);
}
%>

<%out.println("Total Price is " + sum); %>
<form action="index.html">
<button type="submit">Logout</button>
</form>

</body>
</html>