/**
 * Musterlösung Bank-Aufgabe Teil 1
 * 
 * @author Tobias Lauer
 */
public class Bank {
    private String name;
    private Account[] accounts;

    /**
     * Creates a new Bank
     * 
     * @param name the name of this bank
     */
    public Bank(String name) {
        this.name = name;
        accounts = new Account[100];
    }

    /**
     * Adds the given account to this bank.
     * Doesn't do anything if account is already in list or if it is null.
     * 
     * @param newAccount the accoutn to be added
     */
    public void addAccount(Account newAccount) {
        if (newAccount != null && findAccount(newAccount.getAccountID()) == null) {
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] == null) {
                    accounts[i] = newAccount;
                    return;
                }
            }
        }
    }

    /**
     * Outputs the details of this bank.
     */
    public void print() {
        System.out.println("Bank: "+name);
        for (Account a : accounts) {
            if (a != null) {
                System.out.println("Account "+a.getAccountID()+": Balance = " + a.getBalance() 
                + " €, Owner = " + a.getOwner().getFirstName() + " " + a.getOwner().getLastName() 
                +  ", Created = " + a.getCreationDate());
            }
        }
        System.out.println();
    }

    /**
     * Transfers the specified amount from the first specified account to the second specified account.
     * The accounts are specified by teh account IDs.
     * 
     * @param sourceID the account ID of the source account of the transfer
     * @param targetID the account ID of the target account of the transfer
     * @param amount the amount to be transfered
     * @return true iff the transfer was successful
     */
    public boolean transfer(int sourceID, int targetID, float amount) {
        Account source = findAccount(sourceID);
        Account target = findAccount(targetID);        
        if (checkTransfer(source, target, amount)) {
            source.withdraw(amount);
            target.deposit(amount);
            return true;
        } else {
            return false;
        }
    }

    private Account findAccount(int accountID) {
        for (Account a : accounts) {
            if (a != null && a.getAccountID() == accountID) {
                return a;
            }
        }
        return null;
    }

    private boolean checkTransfer(Account source, Account target, float amount) {
        return (source != null && target != null 
                && source != target && amount >= 0 && source.getBalance() >= amount);
    }
}
