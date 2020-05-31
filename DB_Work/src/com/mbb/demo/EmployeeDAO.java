package com.mbb.demo;
import java.sql.*;

import com.mbb.bean.Employee;
public class EmployeeDAO {
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


public static ResultSet selectAll()
{
 try
 {
 ps=con.prepareStatement("select * from emp4");
 rs=ps.executeQuery();
 return rs;
 }
 catch(SQLException sql)
 {
  System.out.println(sql);
 }
 return rs;
}

}