import javax.swing.text.Style;
import java.util.Scanner;

public class Account {

    // Changes:
    // 1/30/2023
    // used getBalance()

    // Class Variables
    // **** Note 1. Later change to private
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;


    //Class Constructor - is the minimum Variable requirements for this Class to exist
    // **** Note 2. make private
    Account(String needsName, String needsID){
        customerName = needsName;
        customerID = needsID;
    }


    // Methods

    // Method to get Balance
    int getBalance(){

        return balance;
    }

    // Method to make a Deposit
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Method for Withdrawal
    // **** Note 3. turn into a && statement for over drafting
    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = amount;
        }
    }

    // Method for Previous Transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction occurred");
        }
    }

    // Method to Calculate Interest
    void calculateInterest(int years){
        double interestRate = 3.89;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println( ("The current interest rate is: " + (100 * interestRate)));
        System.out.println("After " + years + " years, your balance will be: " + newBalance );
    }


    // Method for Menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Maker a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("=====================================");
                    System.out.println("Balance = $" + getBalance());
                    System.out.println("=====================================");
                    System.out.println();
                    break;

                // Case 'B' allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter tan amount to deposit: ");
                    int amountToAdd = scanner.nextInt();
                    deposit(amountToAdd);
                    System.out.println();
                    break;

                // Case 'C' allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amountToSub = scanner.nextInt();
                    withdraw(amountToSub);
                    System.out.println();
                    break;

                // Case 'D' allows the user to view their most recent transaction
                case 'D':
                    System.out.println("=====================================");
                    getPreviousTransaction();
                    System.out.println("=====================================");
                    System.out.println();
                    break;

                // Case 'E' calculates the accrued interest on the account after a number of years
                case 'E':
                    System.out.println("enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                // Case 'F' exits the user from their account
                case 'F':
                    System.out.println("=====================================");
                break;

                // The default case lets the user know they entered an invalid char
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
                    break;

            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }

}

/* **** WORKING NOTES ******
// Constructor = Name of class (plus what Variables you want automatically when you Instantiate a new Object)
// Object(String needsName, String needsID){
        customerName = needsName;
        customerID = needsID;
    }
// Do While
// Case
// When is the return void and when is it a Variable??

 */