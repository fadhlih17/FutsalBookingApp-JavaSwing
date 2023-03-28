package org.example.services.impl;

import org.example.exceptions.ErrorException;
import org.example.exceptions.WarningException;
import org.example.models.Employee;
import org.example.repositories.AdminRepository;
import org.example.repositories.EmployeeRepository;
import org.example.services.AdminService;
import org.example.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private AdminRepository adminRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AdminRepository adminRepository){
        this.employeeRepository = employeeRepository;
        this.adminRepository = adminRepository;
    }

    public Employee createEmployee(Employee request){
        if (employeeRepository.findAllEmployeeById(request.getId()) != null){
            try {
                throw new WarningException("Gagal membuat data karyawan, Id Karyawan sudah tersedia !");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        return employeeRepository.createEmployee(request);
    }

    public boolean updateEmployee(Employee employee){
        Employee emp = employeeRepository.findAllEmployeeById(employee.getId());
        if ( emp == null){
            try {
                throw new WarningException("Gagal merubah data karyawan, id tidak ditemukan !");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        return employeeRepository.updateEmployee(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAllEmployee();
    }

    public boolean deleteEmployee(String id){
        if (employeeRepository.findAllEmployeeById(id) == null){
            try {
                throw new WarningException("Gagal menghapus data, id karyawan tidak ditemukan");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        adminRepository.deleteAdminAccountByEmployeeId(id);
        return employeeRepository.deleteEmployee(id);
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findAllEmployeeByName(name);
    }

    public List<Employee> findEmployeeWhereAdmin(){
        return employeeRepository.findEmployeeWhereAdmin();
    }
}
