package com.mbb.demo;
import java.sql.*;

import com.mbb.bean.Customer;


public class CustomerDAO {
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
public static int insert(Customer e)
{
 int i=0;
 try
 {
 ps=con.prepareStatement("insert into customer values(?,?)");
 ps.setString(1, e.getLoginid());
 ps.setString(2,e.getPassword());
 i=ps.executeUpdate();
  return i;
 }
 catch(SQLException sql)
 {
  
 }
 return i;
}


}

