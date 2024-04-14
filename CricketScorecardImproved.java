package JavaPractice.ProjectsAndMisc;


import java.util.*;
class card{
    card(){}

    Scanner aa=new Scanner(System.in);
    int score;
    String batting;
    String batting1;


    int fours;
    card inning1;
    int sixes;

    int wickets;

    int overs;
    int run;

    double runrate;
    card(int overs){
        this.overs=overs;
    }


    void firstinning(card c){
        int f = 0;
        int s = 0;

        System.out.println("----in case of wickets please enter -1----");
        card inning2=new card();
        System.out.println("====================");
        System.out.println("First innings: ");
        boolean a=false;
        for (int i=1;i<=overs;i++){
            for(int j=1;j<=6;j++){
                if(c.wickets==10){
                    System.out.println("All out first innings over!!");
                    a=true;
                    break;
                }
                System.out.println("Enter runs scored on "+j+" ball");
                c.run=aa.nextInt();
                c.score+=c.run;
                if(c.run==4){
                    c.fours++;
                    f++;
                }
                if(c.run==6){
                    c.sixes++;
                    s++;
                }
                if(c.run==-1){
                    c.wickets++;
                }

            }
            if(a){
                break;
            }
            System.out.println(batting+" at "+ c.score+"/"+c.wickets+" after "+i+" overs");
            System.out.println("Boundaries in over:");
            System.out.println("Total Fours :" +f);
            System.out.println("Total Six :" +s);

        }
        c.runrate=c.score/overs;
        scorecard(c);
        System.out.println("==========================");
        System.out.println(batting1+" need "+(c.score+1)+" runs in "+overs*6+" balls");
        seccondinnings(inning2);
    }
    void seccondinnings(card c2) {
        int f = 0,s = 0;
        boolean a=false;
        System.out.println("==========================");
        System.out.println("Second innings: ");
        for (int i = 1; i <= overs; i++) {
            for (int j = 1; j <= 6; j++) {
                if (c2.wickets == 10) {
                    System.out.println(batting + " won!!");
                    a = true;
                    scorecard(c2);
                    break;
                }
                if (c2.score > inning1.score) {
                    System.out.println(batting1 + " won by " + (10 - c2.wickets) + " wicekts left!!");
                    a = true;
                    scorecard(c2);
                    break;
                }
                System.out.println("Enter runs scored on " + j + " ball");
                c2.run = aa.nextInt();


                c2.score += c2.run;
                if (c2.run == 4) {
                    c2.fours++;
                    f++;
                }
                if (c2.run == 6) {
                    c2.sixes++;
                    s++;
                }
                if (c2.run == -1) {
                    c2.wickets++;
                }

            }
            if (a) {
                break;
            } else {
                System.out.println(batting1 + " at " + c2.score + "/" + c2.wickets + " after " + i + " overs");
                System.out.println("Boundaries in over:");
                System.out.println("Total Fours :" +f);
                System.out.println("Total Six :" +s);
            }
        }
        if (!a) {
            System.out.println(batting + " won!!");
            scorecard(c2);
        }
    }

    void toss(String t1,String t2){
        System.out.println("Toss is being tossed");
        Random r=new Random();
        int a=r.nextInt(2);
        //System.out.println(a);
        if(a==0){
            System.out.println(t1+" won the toss \nthey choose to: ");
            choice(t1,t2);

        }
        else{
            System.out.println(t2+"won the toss \nthey choose to: ");
            choice(t2,t1);
        }

    }
    void choice(String team1,String team2){

        inning1=new card();

        String ab=aa.next();
        if(ab.equals("bat")){
            batting=team1;
            batting1=team2;
            System.out.println("First innings will be played by :"+batting);
            firstinning(inning1);
        }
        if(ab.equals("bowl")) {
            batting = team2;
            batting1=team1;
            System.out.println("First innings will be played by :"+ batting);

            firstinning(inning1);
        }
    }
    void scorecard(card c){
        System.out.println("====Total runs: "+c.score+"====");
        //System.out.println("====Boundaries: "+c.fours+sixes+"====");
        System.out.println("====Sixes: "+c.sixes+"====");
        System.out.println("====Fours: "+c.fours+"====");
        System.out.println("====Runrate: "+c.runrate+"====");
        System.out.println("====Wickets: "+c.wickets+"====");


    }

}
class cric{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        player[] playersTeam1 = new player[11];
        player[] playersTeam2 = new player[11];

        for (int i = 0; i < 11; i++) {
            playersTeam1[i] = new player();
        }
        for (int i = 0; i < 11; i++) {
            playersTeam2[i] = new player();
        }



        Scanner ab=new Scanner(System.in);
        System.out.println("Enter number of overs");
        card c=new card(ab.nextInt());

        System.out.println("Name of team 1");
        String t1=ab.next();
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter Player " +(i+1));
            playersTeam1[i].playerName=sc.next();

        }
        System.out.println("Name of team 2");
        String t2=ab.next();
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter Player " +(i+1));
            playersTeam1[i].playerName=sc.next();

        }
        c.toss(t1,t2);


    }
}
class player{
    String playerName;
    int playerRunrate;
    int runScored;
    int boundaries;
}