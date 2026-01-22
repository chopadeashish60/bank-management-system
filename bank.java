import java.io.*;
import java.util.*;

class BankAccount 
{
    int accountNo, balance;
    String name;

    public BankAccount(String name, int accountNo, int balance)
     {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void withdraw(int amount)
     {
        if (amount > balance) 
        {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. Remaining balance: " + balance);
        }
    }

    public void deposit(int amount)
     {
        balance += amount;
        System.out.println(amount + " deposited successfully. Total balance: " + balance);
    }

    public void display()
     {
        System.out.println("Account holder: " + name);
        System.out.println("Account number: " + accountNo);
        System.out.println("Balance: " + balance);
    }
}

public class Bank
 {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while (true) {
            System.out.println("\n==== ONLINE BANKING SYSTEM ====");
            System.out.println("\n   welcome to chattrapati urbon bank  branch umarkhed");
            System.out.println("1. CREATE ACCOUNT");
            System.out.println("2. WITHDRAW BALANCE");
            System.out.println("3. DEPOSIT MONEY");
            System.out.println("4. DISPLAY ACCOUNT");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");

            int choice = s.nextInt();
            switch (choice) {
                case 1: createAccount();
                 break;
                case 2: withdraw(); 
                break;
                case 3: deposit();
                
                break;
                case 4: display(); 
                break;
                case 5:
                 return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void createAccount() 
    {
        System.out.print("Enter account holder name: ");
        s.nextLine();
        String name = s.nextLine();
        System.out.print("Enter account number: ");
        int accountNo = s.nextInt();
        System.out.print("Enter balance: ");
        int balance = s.nextInt();

        accounts.add(new BankAccount(name, accountNo, balance));
        System.out.println("Account created successfully!");
    }

    static void withdraw()
     {
        System.out.print("Enter account number: ");
        int acc = s.nextInt();
        System.out.print("Enter amount to withdraw: ");
        int amount = s.nextInt();

        for (BankAccount b : accounts)
         {
            if (b.accountNo == acc) 
            {
                b.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void deposit() 
    {
        System.out.print("Enter account number: ");
        int acc = s.nextInt();
        System.out.print("Enter amount to deposit: ");
        int amount = s.nextInt();

        for (BankAccount b : accounts)
         {
            if (b.accountNo == acc) 
            {
                b.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void display() 
    {
        for (BankAccount b : accounts) 
        {
            b.display();
            System.out.println("----------------------------");
        }
    }
}
