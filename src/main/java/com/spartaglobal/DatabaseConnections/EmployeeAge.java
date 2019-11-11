package com.spartaglobal.DatabaseConnections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAge {

    private final String SQL = "SELECT AGE"; //an SQL qurery should live in the method
    private NorthwindDBManager nwconn = new NorthwindDBManager();

    public List<String> getEmployeeOver60 () {
        final String SQL = "SELECT firstName, lastName, DATEDIFF(d, Birthdate, GETDATE())/ 365 as \"AGE\" FROM Employees";
        List<String> employeeOver60 = new ArrayList<>();

        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName") + resultSet.getString("AGE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  employeeOver60;
    }
}
