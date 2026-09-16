package quizapp;

import java.io.File;
import java.util.Scanner;

public class TestQuizEngine {

    public static void main(String[] args) {

        testQuestion();
        testScore();
        testQuiz();

        System.out.println("All tests passed.");
    }

    static void testQuestion() {

        String[] options = {"A", "B", "C", "D"};

        Question q = new Question("What is 1+1?", options, 2);

        if (!q.isCorrect(2)) {
            throw new RuntimeException("Question test failed");
        }

        if (q.isCorrect(1)) {
            throw new RuntimeException("Question test failed");
        }

        System.out.println("Question test passed");
    }

    static void testScore() {

        QuizManager manager = new QuizManager();

        manager.qFile = "test_questions.txt";
        manager.lbFile = "test_leaderboard.txt";

        new File(manager.qFile).delete();
        new File(manager.lbFile).delete();

        manager.addQuestion("Question", "A", "B", "C", "D", 2);

        if (manager.questions.size() != 1) {
            throw new RuntimeException("Score test failed");
        }

        manager.saveScore("Alice", 10);

        new File(manager.qFile).delete();
        new File(manager.lbFile).delete();

        System.out.println("Score test passed");
    }

    static void testQuiz() {

        QuizManager manager = new QuizManager();

        manager.qFile = "test_quiz.txt";
        new File(manager.qFile).delete();

        manager.addQuestion("Question 1", "A", "B", "C", "D", 2);

        Scanner sc = new Scanner("2\n");

        int score = manager.runQuiz(sc);

        if (score != 1) {
            throw new RuntimeException("Quiz test failed");
        }

        new File(manager.qFile).delete();

        System.out.println("Quiz test passed");
    }
}
