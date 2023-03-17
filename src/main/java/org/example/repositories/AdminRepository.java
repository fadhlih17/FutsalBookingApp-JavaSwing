package org.example.repositories;

import org.example.models.Admin;

public interface AdminRepository {
    Admin createAdmin(Admin admin);
    Admin findAdminByUsername(String usernameInput);
}
