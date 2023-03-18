package org.example.repositories;

import org.example.models.Admin;

import java.util.List;

public interface AdminRepository {
    Admin createAdmin(Admin admin);
    Admin findAdminByEmployeeId(String usernameInput);
    List<Admin> findAllAdmin();
}
