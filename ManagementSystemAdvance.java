package JavaPractice.ProjectsAndMisc;

import java.util.Scanner;
class account
{
    Scanner sc=new Scanner(System.in);
    String AN;
    String first_name;
    String middle_name;
    String last_name;
    int balance;
    String PAN;
    void setAccountNumber()
    {
        boolean[] b = new boolean[10];

        System.out.println("Enter the account no. :");
        AN=sc.next();
        if(AN.length()!=10)
        {
            System.out.println("There should only be 10 digits");
            setAccountNumber();
            return;

        }

        for(int i=0 ; i < AN.length() ; i++)
        {
            if(!(AN.charAt(i)<'0' ||  AN.charAt(i)>'9'))
            {
            }else {
                System.out.println("The account no. uses numbers from 0 to 9 only");
                setAccountNumber();
                return;
            }
        }
    }

    void setName()
    {
        System.out.println("Enter the first name:");
        first_name=sc.next();
        System.out.println("Enter the middle name:");
        middle_name=sc.next();
        System.out.println("Enter the last name:");
        last_name=sc.next();
    }

    void balance()
    {
        System.out.println("Enter the balance of the account");
        balance=sc.nextInt();
        if(balance<5000)
        {
            System.out.println("The balance should be atleast 5000");
            balance();
            return;

        }
    }

    void setPAN()
    {
        System.out.println("Enter the PAN number");
        PAN=sc.next();
        if(PAN.length()!=10)
        {
            System.out.println("The maximum length of PAN no. can only be 10");
            return;
        }
        for (int i=0 ; i<PAN.length() ; i++)
        {
            if(i>=0 && i<=4)
            {
                if(PAN.charAt(i)<='A' && PAN.charAt(i)>='Z')
                {
                    System.out.println("The first 5 character shuld be between A and Z");
                    setPAN();
                    return;

                }
            }

            else if(i>=5 && i<=8)
            {
                if(PAN.charAt(i)<='0' && PAN.charAt(i)>='9')
                {
                    System.out.println("The characters from 5 to 9 should be from 0 to 9 only");
                    setPAN();
                    return;

                }
            }

            else if(i==9)
            {
                if(PAN.charAt(i)<='a' && PAN.charAt(i)>='z')
                {
                    System.out.println("The 10th character should be from a to z only");
                    setPAN();
                    return;
                }
            }
        }
    }

    void display(account arr[])
    {
        for(account account : arr)
        {
            System.out.println("Acoount no.: "+ account.AN);
            System.out.println("Acoount name: "+ account.first_name+" " + account.middle_name+ " " +account.last_name);
            System.out.println("Acoount balance: "+ account.balance);
            System.out.println("Acoount PAN no.: "+ account.PAN);
        }
    }
}


public class ManagementSystemAdvance
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        account d=new account();
        System.out.println("Enter the no. of accounts: ");
        int n=sc.nextInt();
        account arr[]=new account[n];
        for (int i=0 ; i<n ; i++)
        {
            arr[i]=new account();
        }

        for (int i=0 ; i<n ; i++)
        {
            arr[i].setAccountNumber();
            arr[i].setName();
            arr[i].balance();
            arr[i].setPAN();
        }
        d.display(arr);
    }
}