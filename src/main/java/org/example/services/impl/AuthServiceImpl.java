package org.example.services.impl;

import org.example.dtos.LoginRequest;
import org.example.dtos.LoginResponse;
import org.example.exceptions.UnauthorizedException;
import org.example.models.*;
import org.example.repositories.AdminRepository;
import org.example.repositories.PersonaliaRepository;
import org.example.repositories.UserRepository;
import org.example.services.AuthService;
import org.example.services.OwnerWalletService;
import org.example.services.UserWalletService;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.util.UUID;

public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    AdminRepository adminRepository;
    PersonaliaRepository personaliaRepository;
    UserWalletService userWalletService;
    OwnerWalletService ownerWalletService;

    public AuthServiceImpl(UserRepository userRepository, AdminRepository adminRepository, UserWalletService userWalletService, OwnerWalletService ownerWalletService, PersonaliaRepository personaliaRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.userWalletService = userWalletService;
        this.ownerWalletService = ownerWalletService;
        this.personaliaRepository = personaliaRepository;
    }

    private User loadEmailUser(String emailInput) {
        User user = userRepository.findUserByEmail(emailInput);

        if (user == null) try {
            throw new UnauthorizedException("Pengguna belum mendaftar, silahkan sign-up terlebih dahulu !");
        } catch (UnauthorizedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new RuntimeException(e);
        }

        return user;
    }
    private User loadRegisterEmailUser(String email){
        User user = userRepository.findUserByEmail(email);

        if (user != null) try {
            throw new UnauthorizedException("Registrasi gagal, email sudah terdaftar !");
        } catch (UnauthorizedException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    private Admin loadUsernameAdmin(String usernameInput) {
        Admin admin = adminRepository.findAdminByUsername(usernameInput);

        if (admin == null) try {
            throw new UnauthorizedException("Username atau password salah, pastikan akun sudah terdaftar. Hubungi personalia untuk mendaftar");
        } catch (UnauthorizedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw new RuntimeException(e);
        }

        return admin;
    }

    private Admin loadRegisterUsernameAdmin(String usernameInput){
        Admin admin = adminRepository.findAdminByUsername(usernameInput);

        if (admin != null) try {
            throw new UnauthorizedException("Registrasi gagal, admin sudah terdaftar !");
        } catch (UnauthorizedException e) {
            throw new RuntimeException(e);
        }

        return admin;
    }

    public String registerAdmin(Admin request){
        loadRegisterUsernameAdmin(request.getUsername());
        request.setId(UUID.randomUUID().toString());
        Admin admin = new Admin(request.getId(), request.getUsername(), BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        Admin saveAdmin = adminRepository.createAdmin(admin);
        OwnerWallet ownerWallet = ownerWalletService.findOwnerWallet();

        if (ownerWallet == null){
            OwnerWallet create = new OwnerWallet();
            create.setBalance(0);
            ownerWalletService.createWalletOwner(create);
        }
        return saveAdmin.getUsername();
    }

    public LoginResponse loginAdmin(LoginRequest request){
        Admin admin = loadUsernameAdmin(request.getUsername());
        boolean isValid = BCrypt.checkpw(request.getPassword(), admin.getPassword());

        if (!isValid){
            try {
                throw new UnauthorizedException("Email atau password salah");
            } catch (UnauthorizedException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                throw new RuntimeException(e);
            }
        }

        return new LoginResponse(admin.getUsername(), "Admin");
    }
    public String registerUser(User request){
        loadRegisterEmailUser(request.getEmail());
        request.setId(UUID.randomUUID().toString());

        User user = new User();
        user.setId(request.getId());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());

        User saveUser = userRepository.createUser(user);
        var userWallet = userWalletService.findUserWalletByUserId(saveUser.getId());

        if (userWallet == null){

            UserWallet create = new UserWallet();
            create.setBalance(0);
            create.setUserId(saveUser.getId());
            userWalletService.createUserWallet(create);

        }

        return saveUser.getUsername();
    }

    public LoginResponse loginUser(LoginRequest request) {

        User user = loadEmailUser(request.getUsername());
        boolean isValid = BCrypt.checkpw(request.getPassword(), user.getPassword());

        if (!isValid){
            try {
                throw new UnauthorizedException("Email atau password salah");
            } catch (UnauthorizedException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return new LoginResponse(user.getUsername(), "User");
    }

    public LoginResponse loginPersonalia(Personalia personalia){
        final Personalia personalia1 = personaliaRepository.findPersonalia(personalia);
        if (personalia1 == null){
            try {
                throw new UnauthorizedException("Username atau password salah !");
            } catch (UnauthorizedException e) {
                throw new RuntimeException(e);
            }
        }
        return new LoginResponse(personalia1.getUsername(), "personalia");
    }
}
