package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.dtos.AbsentResponse;
import org.example.models.Absent;
import org.example.repositories.AbsentRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AbsentRepositoryImpl implements AbsentRepository {
    private AppDbContext context;
    public AbsentRepositoryImpl(AppDbContext context) {
        this.context = context;
    }
    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e.getMessage());
    }
    public Absent createAbsent(Absent absent){
        String query = "insert into absent values ('"+absent.getId()+"', '"+absent.getEmployeeId()+"', '"+absent.getDate()+"', '"+absent.getInformation()+"')";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return absent;
    }
    public List<AbsentResponse> findAllAbsent(){
        String query = "SELECT a.employee_id, e.name, " +
                "SUM(CASE WHEN a.information = 'Cuti' THEN 1 ELSE 0 END) AS Cuti, " +
                "SUM(CASE WHEN a.information = 'Alpa' THEN 1 ELSE 0 END) AS Alpa, " +
                "SUM(CASE WHEN a.information = 'Sakit' THEN 1 ELSE 0 END) AS Sakit, " +
                "SUM(CASE WHEN a.information = 'Izin' THEN 1 ELSE 0 END) AS Izin " +
                "FROM absent a " +
                "JOIN employee e ON a.employee_id = e.id " +
                "GROUP BY a.employee_id";
        ResultSet resultSet = null;
        List<AbsentResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                int leave = resultSet.getInt("Cuti");
                int alpha = resultSet.getInt("Alpa");
                int sick = resultSet.getInt("Sakit");
                int permission = resultSet.getInt("Izin");
                results.add(new AbsentResponse(employeeId, name, leave, alpha, sick, permission));
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return results;
    }
    public List<AbsentResponse> findAbsentByDate(int month, int year){
        String query = "SELECT a.employee_id, e.name, " +
                "SUM(CASE WHEN a.information = 'Cuti' THEN 1 ELSE 0 END) AS Cuti, " +
                "SUM(CASE WHEN a.information = 'Alpa' THEN 1 ELSE 0 END) AS Alpa, " +
                "SUM(CASE WHEN a.information = 'Sakit' THEN 1 ELSE 0 END) AS Sakit, " +
                "SUM(CASE WHEN a.information = 'Izin' THEN 1 ELSE 0 END) AS Izin " +
                "FROM absent a " +
                "JOIN employee e ON a.employee_id = e.id " +
                "WHERE MONTH(a.date) = "+month+" AND YEAR(a.date) = "+year+"" +
                "GROUP BY a.employee_id";
        List<AbsentResponse> responses  = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                int leave = resultSet.getInt("Cuti");
                int alpha = resultSet.getInt("Alpa");
                int sick = resultSet.getInt("Sakit");
                int permission = resultSet.getInt("Izin");
                responses.add(new AbsentResponse(employeeId, name, leave, alpha, sick, permission));
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return responses;
    }

    public List<AbsentResponse> findAllAbsentDetail(){
        String query = "SELECT a.employee_id, e.name, a.date, a.information\n" +
                "FROM absent a\n" +
                "JOIN employee e ON a.employee_id = e.id\n";
        ResultSet resultSet = null;
        List<AbsentResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                int leave = resultSet.getInt("Cuti");
                int alpha = resultSet.getInt("Alpa");
                int sick = resultSet.getInt("Sakit");
                int permission = resultSet.getInt("Izin");
                results.add(new AbsentResponse(employeeId, name, leave, alpha, sick, permission));
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return results;
    }

    public List<AbsentResponse> findAbsentDetailByDate(int date, int year){
        String query = "SELECT a.employee_id, e.name, a.date, a.information\n" +
                "FROM absent a\n" +
                "JOIN employee e ON a.employee_id = e.id\n" +
                "WHERE MONTH(a.date) = "+date+" AND YEAR(a.date) = "+year+"";
        ResultSet resultSet = null;
        List<AbsentResponse> results = new ArrayList<>();
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                int leave = resultSet.getInt("Cuti");
                int alpha = resultSet.getInt("Alpa");
                int sick = resultSet.getInt("Sakit");
                int permission = resultSet.getInt("Izin");
                results.add(new AbsentResponse(employeeId, name, leave, alpha, sick, permission));
            }
        } catch (Exception e) {
            error(e);
        } finally {
            context.closeResources();
        }
        return results;
    }
}
