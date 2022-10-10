package mts.service.dao;

import mts.service.models.Department;
import mts.service.models.Employee;
import mts.service.models.Position;
import mts.service.models.Union;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/mts_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "kappatych20x1998";
    private static Connection connection;
    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    /* Запросы для Department*/

    public List<String> indexDepartments() {
        List<String>departments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT DISTINCT department FROM departments";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                //Department department = new Department();
                String department = resultSet.getString("department");
                //department.setDepartment(resultSet.getString("department"));
                //department.setJob(resultSet.getString("job"));
                //department.setSecondName(resultSet.getString("secondName"));

                departments.add(department);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return departments;
    }


    public List<Object> allData() {
        List<Object> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT pI.id, pI.firstName, pI.secondName, p.job, d.department " +
                    "FROM personalInfo pI " +
                    "join positions p on pI.id = p.id " +
                    "join departments d on pI.secondName = d.secondName";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                List<Object> res = new ArrayList<>();
                res.add(resultSet.getInt("id"));
                res.add(resultSet.getString("firstName"));
                res.add(resultSet.getString("secondName"));
                res.add(resultSet.getString("job"));
                res.add(resultSet.getString("department"));

                result.add(res);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public StringBuilder fullInfo(int id) {
        StringBuilder stringBuilder = new StringBuilder("");
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT pI.firstName, pI.secondName, p.job, d.department " +
                    "FROM personalInfo pI " +
                    "join positions p on pI.id = p.id " +
                    "join departments d on pI.secondName = d.secondName " +
                    "WHERE pI.id =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            stringBuilder.append(resultSet.getString("firstName"));
            stringBuilder.append(" ");
            stringBuilder.append(resultSet.getString("secondName"));
            stringBuilder.append(" ");
            stringBuilder.append(resultSet.getString("job"));
            stringBuilder.append(" ");
            stringBuilder.append(resultSet.getString("department"));
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return stringBuilder;
    }

    /* Запросы для Position */
    public List<String> indexPositions() {
        List<String>positions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT DISTINCT job FROM positions";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                String position = resultSet.getString("job");

                positions.add(position);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return positions;
    }

    /* Запросы к Employees*/
    public List<Employee>indexEmployees() {
        List<Employee>employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM personalInfo";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setSecondName(resultSet.getString("secondName"));

                employees.add(employee);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    public void insertEmployee(Union union) {
        List<String> pos = indexPositions();
        List<String> dep = indexDepartments();
        if (pos.contains(union.getJob()) && dep.contains(union.getDepartment())) {
            try {

                Statement statement = connection.createStatement();
                String SQL = "INSERT INTO personalInfo VALUES (" + union.getId() + ", '" + union.getFirstName() +
                        "', '" + union.getSecondName() + "')";
                statement.executeUpdate(SQL);
                SQL = "INSERT INTO departments VALUES ('" + union.getDepartment() + "', '" + union.getJob() +
                        "', '" + union.getSecondName() + "')";
                statement.executeUpdate(SQL);
                SQL = "INSERT INTO positions VALUES ('" + union.getJob() + "', " + union.getId() + ")";
                statement.executeUpdate(SQL);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
        public void save (Employee employee){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO personalInfo VALUES(1,?,?)");
                preparedStatement.setString(1, employee.getFirstName());
                preparedStatement.setString(2, employee.getSecondName());
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
