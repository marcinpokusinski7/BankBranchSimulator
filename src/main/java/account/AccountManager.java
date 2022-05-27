package account;

import bankbranch.Bank;
import exceptions.BalanceCannotBeNegativeException;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static List<Account> AVAILABLE_USER_ACCOUNTS = new ArrayList<>();

    public Account createUserAccount(String accountOwnerBank, double balance, Bank bank) throws BalanceCannotBeNegativeException {
        var user = new Account(accountOwnerBank, balance, bank);
        AVAILABLE_USER_ACCOUNTS.add(user);
        return user;
    }



}
