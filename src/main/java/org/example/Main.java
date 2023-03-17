package org.example;

import org.example.controllers.AuthController;
import org.example.database.AppDbContext;
import org.example.models.User;
import org.example.models.UserWallet;
import org.example.repositories.OwnerWalletRepository;
import org.example.repositories.UserRepository;
import org.example.repositories.UserWalletRepository;
import org.example.repositories.impl.OwnerWalletRepositoryImpl;
import org.example.repositories.impl.UserRepositoryImpl;
import org.example.repositories.impl.UserWalletRepositoryImpl;
import org.example.services.OwnerWalletService;
import org.example.services.UserWalletService;
import org.example.services.impl.OwnerWalletServiceImpl;
import org.example.services.impl.UserWalletServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppDbContext context = new AppDbContext();
        UserRepository userRepository = new UserRepositoryImpl(context);
        OwnerWalletRepository ownerWalletRepository = new OwnerWalletRepositoryImpl(context);
        UserWalletRepository userWalletRepository = new UserWalletRepositoryImpl(context);
        OwnerWalletService ownerWalletService = new OwnerWalletServiceImpl(ownerWalletRepository);
        UserWalletService userWalletService = new UserWalletServiceImpl(userWalletRepository, ownerWalletService);

        Scanner input = new Scanner(System.in);
//
//        final List<User> allUser = userRepository.findAllUser();
//        for (User user : allUser) {
//            System.out.println(user.getUsername() +" "+ user.getEmail());
//        }

//        System.out.print("Masukan id user: ");
//        String userId = input.nextLine();
//        System.out.print("Jumlah saldo: ");
//        long balance = Long.parseLong(input.nextLine());
//        userWalletService.updateUserWalletTopUp(userId, balance);
//
//        System.out.print("Masukan id user: ");
//        String userId = input.nextLine();
//        System.out.print("Jumlah saldo: ");
//        long balance = Long.parseLong(input.nextLine());
//        userWalletService.updateUserWalletBooked(userId, balance);

        // Find user Wallet
        System.out.print("input userId: ");
        String userId = input.nextLine();
        final UserWallet userWalletByUserId = userWalletService.findUserWalletByUserId(userId);
        System.out.println(userWalletByUserId.getBalance());
    }
}
