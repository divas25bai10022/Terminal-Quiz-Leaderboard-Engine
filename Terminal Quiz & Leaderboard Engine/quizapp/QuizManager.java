package quizapp;

import java.io.*;
import java.util.*;

public class QuizManager {

    ArrayList<Question> questions = new ArrayList<Question>();

    String qFile = "questions.txt";
    String lbFile = "leaderboard.txt";

    class Score {
        String name;
        int points;

        Score(String name, int points) {
            this.name = name;
            this.points = points;
        }
    }

    public void loadQuestions() {

        questions.clear();

        File file = new File(qFile);

        if (!file.exists()) {
            createSample();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(qFile));

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().equals("")) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length < 6) {
                    continue;
                }

                try {
                    String question = parts[0];
                    String[] options = new String[4];

                    options[0] = parts[1];
                    options[1] = parts[2];
                    options[2] = parts[3];
                    options[3] = parts[4];

                    int answer = Integer.parseInt(parts[5]);

                    questions.add(new Question(question, options, answer));
                }
                catch (Exception e) {
                    System.out.println("Skipped a question because its data was not correct.");
                }
            }

            br.close();
        }
        catch (Exception e) {
            System.out.println("Could not read questions.");
        }
    }

    private void createSample() {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(qFile));

            pw.println("What is 2+2?|3|4|5|6|2");
            pw.println("Capital of France?|Berlin|Madrid|Paris|Rome|3");
            pw.println("Java is a ___ language?|Compiled|Interpreted|Both|None|3");

            pw.close();
        }
        catch (Exception e) {
            System.out.println("Could not create questions file.");
        }
    }

    public void addQuestion(String q, String o1, String o2, String o3, String o4, int ans) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(qFile, true));

            pw.println(q + "|" + o1 + "|" + o2 + "|" + o3 + "|" + o4 + "|" + ans);

            pw.close();

            String[] options = {o1, o2, o3, o4};
            questions.add(new Question(q, options, ans));
        }
        catch (Exception e) {
            System.out.println("Could not save question.");
        }
    }

    public void viewQuestions() {

        if (questions.size() == 0) {
            System.out.println("There are no questions.");
            return;
        }

        System.out.println("\n===== Question Bank =====");

        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("\n" + (i + 1) + ". " + q.getQ());

            String[] options = q.getOpts();

            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
        }
    }

    public int runQuiz(Scanner sc) {

        if (questions.size() == 0) {
            System.out.println("No questions available.");
            return 0;
        }

        ArrayList<Question> quiz = new ArrayList<Question>(questions);
        Collections.shuffle(quiz);

        int score = 0;

        for (int i = 0; i < quiz.size(); i++) {

            Question q = quiz.get(i);

            System.out.println("\nQuestion " + (i + 1) + " of " + quiz.size());
            System.out.println(q.getQ());

            String[] options = q.getOpts();

            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int answer = 0;

            while (answer < 1 || answer > 4) {

                System.out.print("Your answer: ");

                try {
                    answer = Integer.parseInt(sc.nextLine());
                }
                catch (Exception e) {
                    answer = 0;
                }

                if (answer < 1 || answer > 4) {
                    System.out.println("Enter 1, 2, 3 or 4.");
                }
            }

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            }
            else {
                System.out.println("Wrong. Correct answer: " + q.getAns());
            }
        }

        double percentage = (score * 100.0) / quiz.size();

        System.out.println("\n===== Result =====");
        System.out.println("Score: " + score + "/" + quiz.size());
        System.out.println("Percentage: " + percentage + "%");

        return score;
    }

    public void saveScore(String name, int points) {

        ArrayList<Score> scores = readScores();

        scores.add(new Score(name, points));

        for (int i = 0; i < scores.size() - 1; i++) {

            for (int j = i + 1; j < scores.size(); j++) {

                if (scores.get(j).points > scores.get(i).points) {

                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(lbFile));

            for (int i = 0; i < scores.size(); i++) {
                pw.println(scores.get(i).name + "|" + scores.get(i).points);
            }

            pw.close();
        }
        catch (Exception e) {
            System.out.println("Could not save leaderboard.");
        }
    }

    private ArrayList<Score> readScores() {

        ArrayList<Score> scores = new ArrayList<Score>();

        File file = new File(lbFile);

        if (!file.exists()) {
            return scores;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(lbFile));

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().equals("")) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length >= 2) {

                    try {
                        String name = parts[0];
                        int points = Integer.parseInt(parts[1]);

                        scores.add(new Score(name, points));
                    }
                    catch (Exception e) {
                    }
                }
            }

            br.close();
        }
        catch (Exception e) {
            System.out.println("Could not read leaderboard.");
        }

        return scores;
    }

    public void showLeaderboard() {

        ArrayList<Score> scores = readScores();

        if (scores.size() == 0) {
            System.out.println("No scores yet.");
            return;
        }

        System.out.println("\n===== Leaderboard =====");

        for (int i = 0; i < scores.size(); i++) {

            Score s = scores.get(i);

            System.out.println((i + 1) + ". " + s.name + " - " + s.points);
        }
    }
}
