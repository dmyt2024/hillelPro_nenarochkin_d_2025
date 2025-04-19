package lesson_29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.connection();

        // CREATE NEW TABLE
//        String newTable = "CREATE TABLE employees(id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY," +
//                          " name VARCHAR(100)," +
//                          " age INTEGER," +
//                          "position VARCHAR(100)," +
//                          "salary FLOAT)";
//        dbConnector.executeUpdateEmployee(newTable);



        EmployeeDAO employeeDAO = new EmployeeDAO(dbConnector.getConnection());

        // employeeDAO.addEmployee(new Employee("Tom",34, "teamlead", 1500));

        //employeeDAO.updateEmployee(new Employee(3, "VASYL", 30, "senior developer", 1000));

        //employeeDAO.deleteEmployee(4);

        //employeeDAO.getAllEmployees().forEach(System.out::println);


        // Завершення зʼєднання

        //dbConnector.disconnect();













    }
}
