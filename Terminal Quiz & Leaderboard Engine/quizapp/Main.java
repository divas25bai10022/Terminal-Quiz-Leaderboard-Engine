package quizapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuizManager manager = new QuizManager();

        manager.loadQuestions();

        int choice = 0;

        while (choice != 4) {
            System.out.println("\n===== Quiz App =====");
            System.out.println("1. Take Quiz");
            System.out.println("2. View Leaderboard");
            System.out.println("3. View Questions");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = 0;
            }

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                if (name.equals("")) {
                    name = "Player";
                }

                int score = manager.runQuiz(sc);
                manager.saveScore(name, score);

                System.out.println("Your score has been saved.");
            }
            else if (choice == 2) {
                manager.showLeaderboard();
            }
            else if (choice == 3) {
                manager.viewQuestions();
            }
            else if (choice == 4) {
                System.out.println("Thanks for playing.");
            }
            else {
                System.out.println("Please enter a number from 1 to 4.");
            }
        }

        sc.close();
    }
}
