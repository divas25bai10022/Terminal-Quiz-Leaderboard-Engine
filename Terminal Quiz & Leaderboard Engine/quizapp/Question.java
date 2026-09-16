package quizapp;

public class Question {

    private String question;
    private String[] options;
    private int answer;

    public Question(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQ() {
        return question;
    }

    public String[] getOpts() {
        return options;
    }

    public int getAns() {
        return answer;
    }

    public boolean isCorrect(int choice) {
        return choice == answer;
    }
}
