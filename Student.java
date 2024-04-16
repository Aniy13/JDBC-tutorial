package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	

public void createDatabase() {
	// TODO Auto-generated method stub
	
}

public void createtable() {
	// TODO Auto-generated method stub

	try {
		String url="jdbc:mysql://localhost/myJDBC";
//		String db="myJDBC";
		String userName="root";
		String password="pass1234";
		
		Connection con=DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		
		String query="create table students(sid int(3),sname varchar(50),semail varchar(25))";
		boolean b= st.execute(query);
		
		System.out.println("Table created succefully!");
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public void createData() {
	// TODO Auto-generated method stub
	try {
		String url="jdbc:mysql://localhost/myJDBC";
//		String db="myJDBC";
		String userName="root";
		String password="pass1234";
		
		Connection con=DriverManager.getConnection(url,userName,password);
//		Statement st = con.createStatement();
		
		
		String query="insert into students(sid,sname,semail) values(?,?,?)";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1,102);
		pstm.setString(2,"Amey");
		pstm.setString(3, "amey05@gmail.com");
	    pstm.executeUpdate();
		
		System.out.println("Data added succefully!");
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}

public void readData() {
	// TODO Auto-generated method stub
	try {
		String url="jdbc:mysql://localhost/myJDBC";
//		String db="myJDBC";
		String userName="root";
		String password="pass1234";
		
		Connection con=DriverManager.getConnection(url,userName,password);
//		Statement st = con.createStatement();
		
		
		String query="select * from students";
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
	    while(rs.next()) {
	    	System.out.println("id = "+rs.getInt(1));
	    	System.out.println("name = "+rs.getString(2));
	    	System.out.println("email = "+rs.getString(3));
	    }
		System.out.println("read succefully!");
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public void update() {
	// TODO Auto-generated method stub
	try {
		String url="jdbc:mysql://localhost/myJDBC";
//		String db="myJDBC";
		String userName="root";
		String password="pass1234";
		
		Connection con=DriverManager.getConnection(url,userName,password);
//		Statement st = con.createStatement();
		
		
		String query="update students set sid = ?  where sname=?";
		
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1,103);
		pstm.setString(2,"amey");
//		pstm.setString(3, "nikd55@gmail.com");
	    pstm.executeUpdate();
		
		System.out.println("Data updated succefully!");
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public void deleteData() {
	// TODO Auto-generated method stub
	
	try {
		String url="jdbc:mysql://localhost/myJDBC";
//		String db="myJDBC";
		String userName="root";
		String password="pass1234";
		
		Connection con=DriverManager.getConnection(url,userName,password);
//		Statement st = con.createStatement();
		
		
		String query="delete from students where sname=?";
		
		PreparedStatement pstm = con.prepareStatement(query);
		
		pstm.setString(1,"amey");
	
	    pstm.executeUpdate();
		
		System.out.println("Data deleted succefully!");
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

}
