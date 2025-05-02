package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {

	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

			if (conn != null) {
				System.out.println("DB 연결성공 !");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void close(PreparedStatement pstmt, Connection conn, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			close(pstmt, conn);
			System.out.println("추가 rs 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt, Connection conn) {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			System.out.println("conn, pstmt 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
