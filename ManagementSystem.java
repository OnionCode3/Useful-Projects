package JavaPractice.ProjectsAndMisc;

import java.util.Scanner;

class Account {
    long accountNumber;
    String first_name;
    String middle_name;
    String last_name;
    String panNo;
    double accountBalance;
    Scanner sc = new Scanner(System.in);


    void setAccountNumber() {
        System.out.println("enter acc no : ");
        String n = sc.next();

        String s = n;
        if (s.length() != 10) {
            System.out.println("Enter account number again : must be 10 digits ");
            setAccountNumber();
            return;
        }

        int x = 0;
        for (int i = 0; i < 9; i++) {
            x = 0;
            for (int j = '0'; j < '9'; j++) {
                if (s.charAt(i) == (char) j) x++;
            }
            if (x == 0) {
                System.out.println("Enter acc no again : must be numbers ");
                setAccountNumber();
                return;
            }
        }

        accountNumber = Integer.parseInt(s);
    }

    boolean stringChecker(String s) {
        if (s.length() != 10) return false;

        boolean[] b = new boolean[10];

        int x = 0;

        for (int i = 0; i < 5; i++) {
            x = 0;
            for (int j = 'A'; j < 'Z'; j++) {
                if (s.charAt(i) == (char) j) x++;
            }
            if (x == 0) return false;
            else b[i] = true;
        }

        for (int i = 5; i < 9; i++) {
            x = 0;
            for (int j = '0'; j < '9'; j++) {
                if (s.charAt(i) == (char) j) x++;
            }
            if (x == 0) return false;
            else b[i] = true;
        }

        x = 0;
        for (int i = 'A'; i < 'Z'; i++) {
            if (s.charAt(9) == (char) i) x++;
        }
        if (x == 0) return false;
        else b[9] = true;
        boolean ans = true;

        for (int i = 0; i < 9; i++) {
            ans = ans && b[i];
        }
        return ans;
    }

    void setPanNo() {
        System.out.println("Enter Pan no :");
        String s = sc.next();

        if (stringChecker(s)) panNo = s;
        else {
            System.out.println("Please enter again");
            setPanNo();
        }
    }

    void setname() {
        System.out.println("Enter First Name : ");
        first_name = sc.next();
        System.out.println("Enter middle Name : ");
        middle_name = sc.next();
        System.out.println("Enter last Name : ");
        last_name = sc.next();
        System.out.println("________________________");
    }

    void setBalance() {
        System.out.println("Enter balance : ");
        double tmpBal = sc.nextDouble();

        if (!(tmpBal > 5000)) {
            System.out.println("Bal must be more than 5k ");
            setBalance();
            return;
        }

        accountBalance = tmpBal;
    }

    void searchData(int accNo, Account[] arr) {
        for (Account account : arr) {
            if (account.accountNumber == accNo) {
                System.out.println("Account number : " + account.accountNumber);
                System.out.println("Name is : " + account.first_name);
                System.out.println("Pan no is : " + account.panNo);
                System.out.println("balance is : " + account.accountBalance);
                return;
            }
        }
        System.out.println("Not found element");
    }

    void display(Account[] arr) {
        for (Account account : arr) {
            System.out.println("Account number : " + account.accountNumber);
            System.out.println("Name is : " + account.first_name);
            System.out.println("Pan no is : " + account.panNo);
            System.out.println("balance is : " + account.accountBalance);
            System.out.println("________________________");
        }
    }

}

public class ManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account a = new Account();

        System.out.println("Enter no of account : ");
        int n = sc.nextInt();

        Account[] arr = new Account[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Account();
            arr[i].setAccountNumber();
            arr[i].setname();
            arr[i].setBalance();
            arr[i].setPanNo();
        }

        a.display(arr);

    }
}
