package Bank;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args){
            BankAccount ob = new BankAccount("Jyo", "357");
            ob.showMenu();
    }
}
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName=cname;
        customerId=cid;
    }

    void deposit(int amount)
    {
        if(amount != 0)
        {
            balance=balance+amount;
            previousTransaction=amount;
        }
    }
    void withdraw(int amount)
    {
        if(amount!=0)
        {
            balance=balance-amount;
            previousTransaction= -amount;
        }
    }
    void getPreviousTransaction()
    {
        if(previousTransaction>0)
        {
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction<0)
        {
            System.out.println("Withdraw: "+Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No Transaction Occurred");
        }
    }
    void showMenu() {
        char option = '\0';
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome" + customerName);
        System.out.println("Your ID is" + customerId);
        System.out.println("\n");
        System.out.println("A, Check Balance");
        System.out.println("B, Deposit");
        System.out.println("C, Withdraw");
        System.out.println("D, Previous Transaction");
        System.out.println("E, Exit");

        do {
            System.out.println("Enter an option");
            option = in.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("Balance=" + balance);
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount = in.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount1 = in.nextInt();
                    deposit(amount1);
                    System.out.println("\n");
                    break;
                case 'D':
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Invalid Entry, please try to enter again");
                    break;
            }
        }while (option!= 'E');
        System.out.println("Thank you");

    }

}
