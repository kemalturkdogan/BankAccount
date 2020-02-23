package Std_Version;

import java.util.Scanner;

public class App {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank(100);
        BankIO.getAccountData("accounts.txt", bank);

        Account account = null;
        int choice;
        double amount;
        int accountNumber;

        do {
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    amount = getAmount();
                    accountNumber = getAccountNumber();
                    try {
                        account = new Account(amount, accountNumber);
                        bank.add(account);
                        System.out.println("Account info: " + account + "\n");
                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }
                    break;

                case 2:
                    amount = getAmount();
                    try {
                        account.deposit(amount);
                        System.out.println("Account info: " + account + "\n");
                    } catch (NullPointerException exception) {
                        System.out.println("\n*****ERROR*****: " + "No account! First find account"
                                + " or create a new account\n");
                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }

                    break;

                case 3:

                    amount = getAmount();
                    try {
                        account.withdraw(amount);
                        System.out.println("Account info: " + account + "\n");
                    } catch (NullPointerException exception) {
                        System.out.println("\n*****ERROR*****: " + "No account! First find account"
                                + " or create a new account\n");

                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }

                case 4:
                    accountNumber = getAccountNumber();
                    Account found = bank.find(accountNumber);
                    if (found != null) {
                        account = found;
                        System.out.println("Account info: " + account + "\n");
                    } else {
                        System.out.println("\n*****ERROR*****: Bank account " + accountNumber
                                + " not found!\n");
                    }
                    break;

                case 5:
                    System.out.print("\n\nThe accounts: \n" + bank + "\n\n");
                    break;
            }
        } while (choice != 0);
        System.out.println("\n\nGoodbye!");
    }

    private static int getUserChoice() {
        int choice;
        do {
            choice = -1;
            System.out.println("Menu Options:");
            System.out.println("0) Quit");
            System.out.println("1) Create new account");
            System.out.println("2) Deposit to current account");
            System.out.println("3) Withdraw from current account");
            System.out.println("4) Find account");
            System.out.println("5) Print all accounts");

            System.out.print("Enter your choice (0 - 5): ");
            try {
                choice = Integer.parseInt(stdin.nextLine());
            } catch (NumberFormatException exception) {
            }
            if (choice < 0 || choice > 5) {
                System.out.println("Invalid choice");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

    private static double getAmount() {
        System.out.print("Enter the amount: $ ");
        double amount = -1;
        boolean valid = false;
        do {
            try {
                amount = Double.parseDouble(stdin.nextLine());
                valid = true;
            } catch (NumberFormatException exception) {
                System.out.println("Make sure you enter a valid double!");
            }
        } while (!valid);
        return amount;
    }

    private static int getAccountNumber() {
        System.out.print("Enter the account number: ");
        int amount = -1;
        boolean valid = false;
        do {
            try {
                amount = Integer.parseInt(stdin.nextLine());
                valid = true;
            } catch (NumberFormatException exception) {
                System.out.println("Make sure you enter a valid integer!");
            }
        } while (!valid);
        return amount;
    }
}
