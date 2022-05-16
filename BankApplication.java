public class BankApplication {
    public static void main(String[] args) {
        Bank bank = new Bank("Sparbank Offenburg");
        bank.print();

        // Lege Personen an
        Person lisa = new Person("Lisa", "Simpson", 12);
        Person hans = new Person("Hans", "Wurst", 56);

        // Lege Konten an
        Account kontoVonLisa = new Account(new Date(12, 12, 2020), lisa);
        Account kontoVonHans = new Account(new Date(1, 9, 2000), hans);

        // Füge Konto von Lisa hinzu
        bank.addAccount(kontoVonLisa);
        bank.print();

        // Füge Konto von Hans hinzu
        bank.addAccount(kontoVonHans);
        bank.print();

        // Zahle auf beide Konten etwas ein
        kontoVonHans.deposit(135.56f);
        kontoVonLisa.deposit(34.10f);
        bank.print();

        // Überweisung von Hans an Lisa
        bank.transfer(2, 1, 35.56f);
        bank.print();

    }
}
