package Std_Version;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankIO {

    public static Account getAccounts(Scanner in) {
        System.out.println("Reading: AccountNumber,balance");
        String oneLine = in.nextLine();
        Scanner lineTokenizer = new Scanner(oneLine);
        lineTokenizer.useDelimiter(" ");
        int accountNumber = lineTokenizer.nextInt();
        double balance = lineTokenizer.nextDouble();
        Account oneAccount = new Account(accountNumber, (int) balance);
        return oneAccount;
    }

    public static void getAccountData(String path, Bank bank) {
        try {

            Scanner inputSource = new Scanner(new File("accounts.txt"));
            System.out.println(bank);
            while (inputSource.hasNextLine()) {
                Account acct = BankIO.getAccounts(inputSource);
                bank.add(acct);
            }

        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
        }

    }

}
