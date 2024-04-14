package JavaPractice.ProjectsAndMisc;

import java.util.Scanner;

// Class to represent a cricket player
class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }
}

// Class to represent a cricket match
class Match {
    String format;
    int totalOvers;
    Player[] team1Players;
    Player[] team2Players;
    int[][] team1BattingScorecard; // [playerIndex][ballsFaced, runsScored]
    int[][] team2BattingScorecard;
    int[][] team1BowlingScorecard; // [playerIndex][oversBowled, runsGiven, wicketsTaken]
    int[][] team2BowlingScorecard;
    int team1Runs;
    int team2Runs;
    int team1Wickets;
    int team2Wickets;
    int ballsBowled;

    public Match(String format, int totalOvers, String[] team1PlayerNames, String[] team2PlayerNames) {
        this.format = format;
        this.totalOvers = totalOvers;
        this.team1Players = new Player[team1PlayerNames.length];
        this.team2Players = new Player[team2PlayerNames.length];
        this.team1BattingScorecard = new int[team1PlayerNames.length][2];
        this.team2BattingScorecard = new int[team2PlayerNames.length][2];
        this.team1BowlingScorecard = new int[team1PlayerNames.length][3];
        this.team2BowlingScorecard = new int[team2PlayerNames.length][3];

        for (int i = 0; i < team1PlayerNames.length; i++) {
            this.team1Players[i] = new Player(team1PlayerNames[i]);
        }

        for (int i = 0; i < team2PlayerNames.length; i++) {
            this.team2Players[i] = new Player(team2PlayerNames[i]);
        }

        this.team1Runs = 0;
        this.team2Runs = 0;
        this.team1Wickets = 0;
        this.team2Wickets = 0;
        this.ballsBowled = 0;
    }

    public void updateScore(int runsScored) {
        // Update team runs and wickets
        if (team1Runs >= team2Runs) {
            team2Runs += runsScored;
        } else {
            team1Runs += runsScored;
        }

        // Increment balls bowled
        ballsBowled++;

        // Check for innings change or match completion
        if (ballsBowled % 6 == 0 || team1Wickets == 10 || team2Wickets == 10 || ballsBowled == totalOvers * 6) {
            // Display match summary
            displayMatchSummary();
        }
    }

    public void displayMatchSummary() {
        // Display match summary
        System.out.println("\n-------------------------------------");
        System.out.println("               Match Summary");
        System.out.println("-------------------------------------");
        System.out.println("Team 1: " + team1Runs + "/" + team1Wickets);
        System.out.println("Team 2: " + team2Runs + "/" + team2Wickets);
        System.out.println("Overs Bowled: " + (ballsBowled / 6) + "." + (ballsBowled % 6));

        // Display batting scorecard for Team 1
        System.out.println("\nBatting Scorecard for Team 1:");
        for (int i = 0; i < team1Players.length; i++) {
            System.out.println(team1Players[i].name + ": " + team1BattingScorecard[i][1] +
                    " runs (" + team1BattingScorecard[i][0] + " balls)");
        }

        // Display batting scorecard for Team 2
        System.out.println("\nBatting Scorecard for Team 2:");
        for (int i = 0; i < team2Players.length; i++) {
            System.out.println(team2Players[i].name + ": " + team2BattingScorecard[i][1] +
                    " runs (" + team2BattingScorecard[i][0] + " balls)");
        }

        // Display bowling figures for Team 1
        System.out.println("\nBowling Figures for Team 1:");
        for (int i = 0; i < team1Players.length; i++) {
            System.out.println(team1Players[i].name + ": " + team1BowlingScorecard[i][0] +
                    " overs, " + team1BowlingScorecard[i][1] + " runs, " +
                    team1BowlingScorecard[i][2] + " wickets");
        }

        // Display bowling figures for Team 2
        System.out.println("\nBowling Figures for Team 2:");
        for (int i = 0; i < team2Players.length; i++) {
            System.out.println(team2Players[i].name + ": " + team2BowlingScorecard[i][0] +
                    " overs, " + team2BowlingScorecard[i][1] + " runs, " +
                    team2BowlingScorecard[i][2] + " wickets");
        }
    }
}

// Main class for the cricket scorecard project
public class CricketScorecard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input player information
        System.out.println("Enter player names for Team 1 (comma-separated):");
        String[] team1PlayerNames = scanner.nextLine().split(",");

        System.out.println("Enter player names for Team 2 (comma-separated):");
        String[] team2PlayerNames = scanner.nextLine().split(",");

        // Input match details
        System.out.println("Enter match format (Test, ODI, T20):");
        String format = scanner.nextLine();

        System.out.println("Enter total overs for the match:");
        int totalOvers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Initialize match object
        Match match = new Match(format, totalOvers, team1PlayerNames, team2PlayerNames);

        // Start match
        System.out.println("\n-------------------------------------");
        System.out.println("           Match Started");
        System.out.println("-------------------------------------");

        // Simulate ball-by-ball updates (simplified)
        for (int ball = 1; ball <= totalOvers * 6; ball++) {
            // Input ball details
            System.out.println("\nEnter runs scored on ball " + ball + ":");
            int runsScored = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Update match scorecard
            match.updateScore(runsScored);
        }

        // Display match summary
        System.out.println("\n-------------------------------------");
        System.out.println("            Match Ended");
        System.out.println("-------------------------------------");
        match.displayMatchSummary();
    }
}