package lesson_29;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }


    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees(name, age, position, salary) VALUES (?,?,?,?)";
        try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {
            prepStatement.setString(1, employee.getName());
            prepStatement.setInt(2, employee.getAge());
            prepStatement.setString(3, employee.getPosition());
            prepStatement.setFloat(4, employee.getSalary());
            prepStatement.executeUpdate();
            System.out.println("Employee added successfully");

        }

    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {
            prepStatement.setString(1, employee.getName());
            prepStatement.setInt(2, employee.getAge());
            prepStatement.setString(3, employee.getPosition());
            prepStatement.setFloat(4, employee.getSalary());
            prepStatement.setInt(5, employee.getId());
            prepStatement.executeUpdate();
            System.out.println("Employee updated successfully");
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("Employee deleted successfully");
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    employees.add(new Employee(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("age"),
                                    resultSet.getString("position"),
                                    resultSet.getFloat("salary")
                            )
                    );
                }
            }
        }
        return employees;
    }
}
