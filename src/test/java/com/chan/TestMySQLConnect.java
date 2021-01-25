package com.chan;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class TestMySQLConnect {
	@Test
	public void TestConnect() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try( Connection con = DriverManager.getConnection("jdbc:mysql://3.34.197.25:3306/hermes","root","mono1234M!"))
		{
			System.out.println("Connection Success");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
