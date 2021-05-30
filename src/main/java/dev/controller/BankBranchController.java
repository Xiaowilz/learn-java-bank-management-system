package dev.controller;

import dev.model.BankBranch;
import dev.dao.BankBranchDaoImplementation;

import java.util.Scanner;

public class BankBranchController {
    Scanner input = new Scanner(System.in);
    BankBranchDaoImplementation bankBranchDaoImplementation = new BankBranchDaoImplementation();

    public void index() {
        System.out.println("1. Daftar Cabang Bank");
        System.out.println("2. Tambah Cabang Bank");
        System.out.println("3. Edit Cabang Bank");
        System.out.println("4. Hapus Cabang Bank");
        System.out.print("Masukkan pilihan: ");

        int chosenMenu = input.nextInt();

        if (chosenMenu == 1) {
            bankBranchDaoImplementation.getBankBranches();
        } else if (chosenMenu == 2) {
            create();
        } else if (chosenMenu == 3) {
            bankBranchDaoImplementation.getBankBranches();
            System.out.print("Masukkan ID Bank: ");
            int id = input.nextInt();

            edit(id);

        }else if (chosenMenu == 4){
            bankBranchDaoImplementation.getBankBranches();
            System.out.print("Masukkan ID Bank: ");
            int id = input.nextInt();

            System.out.println(destroy(id));

        }
    }

    public void create() {
        BankBranch bankBranch = new BankBranch();
        String name;
        String location;
        String description;

        input.nextLine();

        System.out.print("Masukkan nama BANK: ");
        name = input.nextLine();

        System.out.print("Masukkan Lokasi BANK: ");
        location = input.nextLine();

        System.out.print("Masukkan Deskripsi BANK: ");
        description = input.nextLine();

        bankBranch.setName(name);
        bankBranch.setLocation(location);
        bankBranch.setDescription(description);

        System.out.println(store(bankBranch));
    }

    public String store(BankBranch bankBranch) {
        String message;
        boolean result = bankBranchDaoImplementation.addBankBranch(bankBranch);

        if (result) {
            message = "Data Berhasil disimpan";
        }else {
            message = "Data Gagal disimpan";
        }

        return message;
    }

    public void edit(int id) {
        BankBranch bankBranch = bankBranchDaoImplementation.getBankBranch(id);

        input.nextLine();

        System.out.print("Masukkan Nama BANK: " + bankBranch.getName());
        bankBranch.setName(input.nextLine());

        System.out.print("Masukkan Lokasi BANK: "+ bankBranch.getLocation());
        bankBranch.setLocation(input.nextLine());

        System.out.print("Masukkan Deskripsi BANK: "+ bankBranch.getDescription());
        bankBranch.setDescription(input.nextLine());

        System.out.println(update(id, bankBranch));
    }

    public String update(int id, BankBranch bankBranch) {
        String message;

        boolean updated = bankBranchDaoImplementation.updateBankBranch(id, bankBranch);

        if (updated) {
            message = "Data Berhasil diupdate";
        }else {
            message = "Data Gagal diupdate";
        }

        return message;
    }

    public String destroy(int id) {
        String message;
        boolean result = bankBranchDaoImplementation.deleteBankBranch(id);

        if (result) {
            message = "Data Berhasil dihapus";
        }else {
            message = "Data Gagal dihapus";
        }

        return message;
    }
}
