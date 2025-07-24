package ATM_Oops_;

import java.util.*;
class ATM
{
    float balance;
    int PIN=5233;
    public void check_pin() {
        System.out.println("Enter your pin:");
        Scanner sc = new Scanner(System.in);
        int enterPIN = sc.nextInt();
        if (enterPIN == PIN) {
            menu();
        } else {
            System.out.print("\nInvalid pin,Please ");
            check_pin();
        }
    }
    public void menu() {
        System.out.println("Enter the choice:");
        System.out.println("1. Check Account balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice) {
            case 1: CheckBalance();
            case 2: withdrawMoney();
            case 3: DepositMoney();
            case 4:
                System.exit(0);
            default:
                System.out.println("Enter the valid choice: ");
                menu();
        }
    }
    public void CheckBalance(){
        System.out.println("Account Balance is "+balance);
        menu();
    }
    public void withdrawMoney(){
        System.out.println("Enter the amount to Withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount=sc.nextFloat();
        if(amount>balance) {
            System.out.println("Insufficient Balance!,");
        }else {
            balance = balance - amount;
            System.out.println("Money withdrawal Successfully:");
        }
        menu();
    }
    public void DepositMoney(){
        System.out.println("Enter Deposit Amount: ");
        Scanner sc = new Scanner(System.in);
        float amount=sc.nextFloat();
        balance=balance+amount;
        System.out.println("Money deposited Successfully:");
        menu();
    }
}
public class ATM_Machine_Basic {
    public static void main(String[] args) {
        ATM a=new ATM();
        a.check_pin();
    }
}
