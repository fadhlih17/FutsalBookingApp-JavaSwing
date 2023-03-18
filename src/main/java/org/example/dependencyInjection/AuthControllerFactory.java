package org.example.dependencyInjection;

import org.example.controllers.AuthController;
import org.example.database.AppDbContext;
import org.example.repositories.*;
import org.example.repositories.impl.*;
import org.example.services.AuthService;
import org.example.services.EmployeeService;
import org.example.services.OwnerWalletService;
import org.example.services.UserWalletService;
import org.example.services.impl.AuthServiceImpl;
import org.example.services.impl.EmployeeServiceImpl;
import org.example.services.impl.OwnerWalletServiceImpl;
import org.example.services.impl.UserWalletServiceImpl;

public class AuthControllerFactory {
    private AppDbContext context = new AppDbContext();
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    private UserRepository userRepository = new UserRepositoryImpl(context);
    private UserWalletRepository userWalletRepository = new UserWalletRepositoryImpl(context);
    private OwnerWalletRepository ownerWalletRepository = new OwnerWalletRepositoryImpl(context);
    private PersonaliaRepository personaliaRepository = new PersonaliaRepositoryImpl(context);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(context);
    private OwnerWalletService ownerWalletService = new OwnerWalletServiceImpl(ownerWalletRepository);
    private UserWalletService userWalletService = new UserWalletServiceImpl(userWalletRepository, ownerWalletService);
    private EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
    private AuthService authService = new AuthServiceImpl(userRepository, adminRepository, userWalletService, ownerWalletService, personaliaRepository, employeeService);

    public AuthController create() {
        return new AuthController(authService);
    }
}
