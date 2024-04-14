package JavaPractice.ProjectsAndMisc;

import java.util.Random;
import java.util.Scanner;

class JavaAnotherProject {
    static Scanner sc=new Scanner(System.in);

    static int score=0;
    static String name = null;

    private static void checkerAnswer(String toCompare , String withCompare){
        if(toCompare.equalsIgnoreCase(withCompare)){
            score++;
        }
    }
    private static void scorePrinter(){
        System.out.println("Score is "+score+" , and name is "+name);
    }

    static void printMainMenu(){
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");

        System.out.println("               WELCOME               ");
        System.out.println("                 To               ");
        System.out.println("             Quiz game 2024        ");
        System.out.println("______________________________________");
        System.out.println("______________________________________");
        System.out.println("1.Play");
        System.out.println("2.Instructions");
        System.out.println("3.about lifelines");
        System.out.println("4.about game");
        System.out.println("5.Exit ");

        System.out.println("Enter the option you want to select");
        int iSelect = sc.nextInt();

        switch(iSelect)
        {
            case 1:{
                gamemenu();
                break;
            }

            case 2:
                showInstructions();
                printMainMenu();
                break;

            case 3:
                aboutLifeline();
                printMainMenu();
                break;

            case 4:
                aboutGame();
                printMainMenu();
                break;

            case 5:
                exit();
                break;

            default:
                System.out.println("Invalid output, try again");
                printMainMenu();
                break;
        }
    }

    static void exit()
    {
        System.out.println("Thanks for playing ");
    }
    static void showInstructions()
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Read questions carefully.");
        System.out.println("Understand that English isnt's everyonr first so be lenient.");
        System.out.println("Answer the question by selecting one of 4 choices.");
        System.out.println("Each question have different points");
        System.out.println("Game become harder and harder");
        System.out.println("this game contain 15 questions");
        System.out.println("you can use lifeline also");
        System.out.println("-----------------------------------------------------------");
    }

    static void aboutLifeline()
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("50:50 lifeline cancel 2 incorrect answers");
        System.out.println("Skip lifeline skip the questions");
        System.out.println("audience poll lifeline audience give answer");
        System.out.println("hint lifeline give hint of answer");
        System.out.println("-----------------------------------------------------------");
    }

    static void aboutGame()
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("This game was developed by Adarsh shukla");
        System.out.println("This game can check your knowledge");
        System.out.println("-----------------------------------------------------------");
    }


    static void gameFunction(){

    }

    private static int[] generateRandomNumbers(int min, int max, int count) {
        // Create an array to store numbers within the range
        int[] numbers = new int[max - min + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = min + i;
        }

        // Shuffle the array using Fisher-Yates shuffle algorithm
        Random random = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap numbers[index] and numbers[i]
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }

        // Return the first 'count' elements of the shuffled array
        int[] result = new int[count];
        System.arraycopy(numbers, 0, result, 0, count);
        return result;
    }
    static void gamemenu()
    {
        String q1 ="what is the capital of gujarat?\n A)Ahmedabad B)Gandhinagar \nC)Surat D)Vadodara";
        String q2 ="what gives us energy to work and play?\n A)Air  B)Sunlight \n  C)Food   D)Water";
        String q3 ="what is the other name of india?  \n A)Bharat   B)United Kingdom \n  C)America   D)chin";
        String q4 ="Which company invented java language? \n  A)Apple   B)Sun Microsystem \n  c)oracle   d)blackberry";
        String q5 ="Which city is known as manchester of india? \n  A)Mumbai   B)Surat \n c)Banglore  D)Ahmedabad" ;
        String q6 ="which thing we get from animals? \n  A)sugar   B)Milk \n  C)bread   D)salt";
        String q7 ="When is national youth day celebrated? \n  A)12 january   B)5 august \n  C) 17 may   D)5 september";
        String q8 ="Which is the longest river in the world?  \n A)Ganga   B)Amazon \n  C)Nile   D)Brahmaputra";
        String q9 ="who invented the Telephone? \n  A)Galelio   B)Graham bell \n  C)Nilola tesla   D)wright brothers";
        String q10 ="In terms of internet  WWW stands for __?\n   A)World word web   B)World wide Webinar  \n C)World wide word   D)World wide web";

        String qL1 ="what is the capital of gujarat?\n A)Ahmedabad B)Gandhinagar ";
        String qL2 ="what gives us energy to work and play?\n A)Air  B)Food   ";
        String qL3 ="what is the other name of india?  \n A)Bharat B)chin";
        String qL4 ="Which company invented java language? \nA)Sun Microsystem   B)oracle ";
        String qL5 ="Which city is known as manchester of india?  \n A)Mumbai B)Ahmedabad" ;
        String qL6 ="which thing we get from animals? \n  A)sugar   B)Milk ";
        String qL7 ="When is national youth day celebrated?  \n A)12 january   B)5 august ";
        String qL8 ="Which is the longest river in the world? \n A)Amazon   B)Nile ";
        String qL9 ="who invented the Telephone? \n A)Graham bell   B)Nilola tesla ";
        String qL10 ="In terms of internet  WWW stands for __?\n  A)World wide word  B)World wide web";

        String[] quesL=new String[10];
        quesL[0]=qL1;
        quesL[1]=qL2;
        quesL[2]=qL3;
        quesL[3]=qL4;
        quesL[4]=qL5;
        quesL[5]=qL6;
        quesL[6]=qL7;
        quesL[7]=qL8;
        quesL[8]=qL9;
        quesL[9]=qL10;

        String[] ques=new String[10];
        ques[0]=q1;
        ques[1]=q2;
        ques[2]=q3;
        ques[3]=q4;
        ques[4]=q5;
        ques[5]=q6;
        ques[6]=q7;
        ques[7]=q8;
        ques[8]=q9;
        ques[9]=q10;

        String[] answer=new String[10];
        answer[0]="B";
        answer[1]="C";
        answer[2]="A";
        answer[3]="B";
        answer[4]="D";
        answer[5]="B";
        answer[6]="A";
        answer[7]="C";
        answer[8]="B";
        answer[9]="D";

        String[] answerL=new String[10];
        answerL[0]="B";
        answerL[1]="B";
        answerL[2]="A";
        answerL[3]="A";
        answerL[4]="B";
        answerL[5]="B";
        answerL[6]="A";
        answerL[7]="B";
        answerL[8]="A";
        answerL[9]="B";

        String h1="It is a greenest city of asia.";
        String h2="It can be eaten.";
        String h3="It is in name of great indian king.";
        String h4="This company also created ZFS.";
        String h5="In this city river Sabarmati flows.";
        String h6="This thing is from cow.";
        String h7="In this date Swami vivekanand birthday come.";
        String h8="This river flow in Africa";
        String h9="This scientist come from England.";
        String h10="World w_____";

        String[] hint=new String[10];
        hint[0]=h1;
        hint[1]=h2;
        hint[2]=h3;
        hint[3]=h4;
        hint[4]=h5;
        hint[5]=h6;
        hint[6]=h7;
        hint[7]=h8;
        hint[8]=h9;
        hint[9]=h10;

        System.out.println("Enter your name Please : ");
        name = sc.next();

        Scanner sc=new Scanner(System.in);

        int[] pointsRand = generateRandomNumbers(0 , 9 , 10);

        for(int i=0;i<10;i++){
            System.out.println(ques[pointsRand[i]]);
            String given = sc.next();

            if(given.equalsIgnoreCase("lifeline")){
                System.out.println("Select the Lifeline");
                System.out.println("1. 50-50\n2. skip\n3.Hint");
                int givenHere = sc.nextInt();

                if(givenHere == 1){
                    System.out.println(quesL[pointsRand[i]]);
                    String inp = sc.next();
                    checkerAnswer(inp,answerL[pointsRand[i]]);
                } else if (givenHere == 2) {
                    if(pointsRand[i] == 0){
                        System.out.println(ques[1]);
                        String inp = sc.next();
                        checkerAnswer(inp,answerL[1]);
                    }else if(pointsRand[i] == 9){
                        System.out.println(ques[8]);
                        String inp = sc.next();
                        checkerAnswer(inp,answerL[8]);
                    }else{
                        System.out.println(ques[pointsRand[i+1]]);
                        String inp = sc.next();
                        checkerAnswer(inp,answerL[pointsRand[i]+1]);
                    }
                }else if (givenHere == 3) {
                    System.out.println(hint[pointsRand[i]]);
                }
            }else if(!given.equalsIgnoreCase(answer[pointsRand[i]] )){
                scorePrinter();
                break;
            }
            else{
                score++;
            }

        }

        scorePrinter();

    }

    public static void main(String[] args)
    {
        JavaAnotherProject JavaAnotherProject1 = null;
        printMainMenu();
    }
}
