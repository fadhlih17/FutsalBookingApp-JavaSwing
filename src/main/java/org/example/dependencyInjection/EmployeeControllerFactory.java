package org.example.dependencyInjection;

import org.example.controllers.EmployeeController;
import org.example.database.AppDbContext;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.impl.EmployeeRepositoryImpl;
import org.example.services.EmployeeService;
import org.example.services.impl.EmployeeServiceImpl;

public class EmployeeControllerFactory {
    private AppDbContext context = new AppDbContext();
    private EmployeeRepository repository = new EmployeeRepositoryImpl(context);
    private EmployeeService employeeService = new EmployeeServiceImpl(repository);
    public EmployeeController controller (){
        return new EmployeeController(employeeService);
    }
}
