package com.mbb.demo;
import java.sql.*;

import com.mbb.bean.Product;

public class ProductDAO {
public static Connection con=getCon();
public static PreparedStatement ps;
public static ResultSet rs;
public static Connection getCon()
{
 try
 {
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password&A1");
System.out.println("Connected Successfully...");
return con;
 }
 catch(ClassNotFoundException cnf)
 {
  System.out.println(cnf);
 }
 catch(SQLException sql)
 {
  System.out.println(sql);
 }
 return con;
}
public static int insert(Product e)
{
 int i=0;
 try
 {
 ps=con.prepareStatement("insert into product values(?,?,?)");
 ps.setInt(1, e.getId());
 ps.setString(2,e.getName());
 ps.setInt(3,e.getPrice());
 i=ps.executeUpdate();
  return i;
 }
 catch(SQLException sql)
 {
  
 }
 return i;
}


public static ResultSet selectAll()
{
 try
 {
 ps=con.prepareStatement("select * from product");
 rs=ps.executeQuery();
 return rs;
 }
 catch(SQLException sql)
 {
  System.out.println(sql);
 }
 return rs;
}

public static int delete(Product e)
{
 int i=0;
 try
 {
 ps=con.prepareStatement("delete from product where NAME = ?");
 ps.setString(1, e.getName());
 i=ps.executeUpdate();
  return i;
 }
 catch(SQLException sql)
 {
  
 }
 return i;
}
public static int update(Product e)
{
	int i = 0;
	try {
		ps = con.prepareStatement("update product set PRICE = ?, ID = ?, NAME = ?  where NAME = ? ");
		ps.setInt(1, e.getPrice());
		ps.setInt(2, e.getId());
		ps.setString(3,e.getName());
		ps.setString(4, e.getName());
	i=ps.executeUpdate();
	return i;	
	}
	catch(SQLException sql)
	{
		
	}
	return i;
}

}

