package cmdexe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database_Controller {
	
	private String DatabaseUrl = "jdbc:mysql://192.168.1.181:3306/Users?user=dummy"; 
	
	public String CheckValuesInDatabase(String WhatToSelect, String TableName, String WhereToPullValues) throws SQLException {
        Connection DatabaseConnection = DriverManager.getConnection(DatabaseUrl);
        Statement DatabaseStatement = DatabaseConnection.createStatement();
        ResultSet SelectResultSet = DatabaseStatement.executeQuery("SELECT " + WhatToSelect + " FROM " + TableName + " WHERE " + WhereToPullValues);
        String Value = null;
        while(SelectResultSet.next()) {
        	Value = SelectResultSet.getString(1);
	    }
        DatabaseConnection.close();
        return Value;
	}
	
	public void InputIntoDatabase(String TableName, String Columns, String Values) throws SQLException {
        Connection DatabaseConnection = DriverManager.getConnection(DatabaseUrl);
        Statement DatabaseStatement = DatabaseConnection.createStatement();
        DatabaseStatement.executeUpdate("INSERT INTO " + TableName + "(" + Columns + ")" + "VALUES (" + Values + ")");
        DatabaseConnection.close();
	}	
}
