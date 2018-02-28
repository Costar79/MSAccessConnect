package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Chandu A
 *
 */
@SuppressWarnings("unused")
class DataBaseConnect {

	public static boolean connect(String database) {
		try {

			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + database);
			Statement stment = conn.createStatement();
			try {
				ResultSet rs = stment.executeQuery("Select * from Student");

				while (rs.next()) {
					System.out.println("ID =" + rs.getInt(1) + ", Name =" + rs.getString(2));
				}
			} catch (Exception e) {
				System.out.println("Student Table not found");
			}
			/*
			 * For Java 1.5 String url =
			 * "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=" + database +
			 * ";DriverID=22;READONLY=true";
			 * 
			 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection c =
			 * DriverManager.getConnection(url); Statement st = c.createStatement();
			 */
			System.out.println("Connection Successful");
			return true;
		} catch (Exception ee) {
			ee.printStackTrace();
			return false;
		}

	}
}