public class Account {
    private int accountID;
    private float balance;
    private Date creationDate;
    private Person owner;

    private static int newAccountID = 0;

    public Account(Date creationDate, Person owner) {
        this.creationDate = creationDate;
        this.owner = owner;
        this.balance = 0;
        this.accountID = ++newAccountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public Person getOwner() {
        return owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public float getBalance() {
        return balance;
    }

    public boolean withdraw(float amount) {
        balance -= amount;
        return true;
    }

    public boolean deposit(float amount) {
        balance += amount;
        return true;
    }


}
