package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Admin;
import org.example.models.Employee;
import org.example.repositories.EmployeeRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private AppDbContext context;
    public EmployeeRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e);
    }
    public Employee createEmployee(Employee employee){
        //String query = "insert into employee values id = '"+employee.getId()+"', name = '"+employee.getName()+"', address = '"+employee.getAddress()+"', birthdate = "+employee.getBirthDate()+", phonenumber = '"+employee.getPhoneNumber()+"', position = '"+employee.getPosition()+"'";
        String query = "INSERT INTO employee (id, name, address, birthdate, phonenumber, position) VALUES ('" + employee.getId() + "', '" + employee.getName() + "', '" + employee.getAddress() + "', '" + employee.getBirthDate() + "', '" + employee.getPhoneNumber() + "', '" + employee.getPosition() + "')";

        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return employee;
    }

    public boolean updateEmployee(Employee employee){
        String query = "update employee set name = '"+employee.getName()+"', address = '"+employee.getAddress()+"', birthdate = '"+employee.getBirthDate()+"', phonenumber = '"+employee.getPhoneNumber()+"', " +
                "position = '"+employee.getPosition()+"' where id = '"+employee.getId()+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return true;
    }

    public boolean deleteEmployee(String id){
        String query = "delete from employee where id = '"+id+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return true;
    }

    public List<Employee> findAllEmployee(){
        String query = "select * from employee";
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String birthdate = resultSet.getString("birthdate");
                //String birthdate = resultSet.getString("birthdate)
;                String phoneNumber = resultSet.getString("phonenumber");
                String position = resultSet.getString("position");
                employees.add(new Employee(id, name, address, phoneNumber, position, birthdate));
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return employees;
    }

    public List<Employee> findAllEmployeeByName(String inputName){
        String query = "select * from employee where name like '%"+inputName+"%'";
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String birthdate = resultSet.getString("birthdate");
                String phoneNumber = resultSet.getString("phonenumber");
                String position = resultSet.getString("position");
                employees.add(new Employee(id, name, address, phoneNumber, position, birthdate));
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return employees;
    }

    public Employee findAllEmployeeById(String idReq){
        String query = "select * from employee where id = '"+idReq+"'";
        Employee employee = null;
        ResultSet resultSet = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String birthdate = resultSet.getString("birthdate");
                String phoneNumber = resultSet.getString("phonenumber");
                String position = resultSet.getString("position");
                employee = new Employee(id, name, address, phoneNumber, position, birthdate);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return employee;
    }

    public List<Employee> findEmployeeWhereAdmin(){
        String query = "select id, name from employee where position = 'Admin'";
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employees.add(employee);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return employees;
    }
}
