package com.lcpan;

import java.sql.*;

// Query selected employees
public class QueryDemo5 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");			
				
			String empno = "1001";
			String qryStmt = "SELECT * FROM employee WHERE empno=" + empno;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(qryStmt);
		/*	
			String empno = "1001";
			String qryStmt = "SELECT * FROM employee WHERE empno=" + empno;
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			
			String empno = "1001";
			String qryStmt = "SELECT * FROM employee WHERE empno=?";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			pstmt.setString(1, empno);
			ResultSet rs = pstmt.executeQuery();
			
		 	String qryStmt = "SELECT * FROM employee WHERE deptno=? and title=?";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			pstmt.setString(1, "100");
			pstmt.setString(2, "engineer");
			ResultSet rs = pstmt.executeQuery();
		*/	
			while(rs.next()) {
				System.out.println("name = " + rs.getString("ename"));
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class QueryDemo5
