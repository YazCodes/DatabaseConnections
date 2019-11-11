package com.spartaglobal.DatabaseConnections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NWEmployeesDAO {

    private final String SQL = "SELECT TOP 10 * FROM Employees"; //an SQL qurery should live in the method
    private NorthwindDBManager nwconn = new NorthwindDBManager();

    public List<String>getEmployeeList () {
        final String SQL = "SELECT firstName, lastName FROM Employees";
        List<String> employeeNames = new ArrayList<>();

        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  employeeNames;
    }



    public int GetTotalNumberOfEmplpoyeesV1() {
        int employeeNum = 0;
        final String SQL = "SELECT COUNT(*) AS 'Total'FROM Employees";
        try (Statement stm = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stm.executeQuery(SQL);
            while (resultSet.next()) {
                employeeNum = resultSet.getInt("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeNum;

    }

}





