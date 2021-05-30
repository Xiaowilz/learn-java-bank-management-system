package dev;

import dev.controller.BankBranchController;
import dev.dao.LoginDaoImplementation;
import dev.util.Hashing;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Hashing hashing = new Hashing();
        String username;
        String password;
        int chosenMenu;
        Scanner input = new Scanner(System.in);

        System.out.print("Silahkan masukkan username: ");
        username = input.nextLine();

        System.out.print("Silahkan masukkan password: ");
        password = hashing.encryptPassword(input.nextLine());

        LoginDaoImplementation loginDaoImplementation = new LoginDaoImplementation();

        if(loginDaoImplementation.login(username, password)){
            System.out.println("Berhasil Login");
            System.out.println("Menu");
            System.out.println("=======================");
            System.out.println("1. Menu Bank");
            System.out.println("2. Menu User");
            System.out.print("Masukkan pilihan: ");
            chosenMenu = input.nextInt();

            if(chosenMenu == 1) {
                BankBranchController bankBranchController = new BankBranchController();
                bankBranchController.index();
            }
        }
    }
}
