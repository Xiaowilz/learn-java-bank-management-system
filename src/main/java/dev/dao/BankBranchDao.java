package dev.dao;

import dev.model.BankBranch;

import java.util.List;

public interface BankBranchDao {
    public List<BankBranch> getBankBranches();

    public boolean addBankBranch(BankBranch bankBranch);

    public BankBranch getBankBranch(int id);

    public boolean updateBankBranch(int id, BankBranch bankBranch);

    public boolean deleteBankBranch(int id);

}
