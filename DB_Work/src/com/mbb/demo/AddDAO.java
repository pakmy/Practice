package com.mbb.demo;
import java.sql.*;

import com.mbb.bean.Add;

public class AddDAO {
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
public static int insert(Add e)
{
 int i=0;
 try
 {
 ps=con.prepareStatement("insert into add1 values(?,?,?)");
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
 ps=con.prepareStatement("select * from add1");
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

