# Terminal Quiz & Leaderboard Engine

This is a Java terminal app I built for running multiple-choice quizzes. It reads questions from a text file, lets users take the quiz, and saves scores to a leaderboard that persists between runs. No frameworks or external libraries — just plain Java.

---

## What's in it

**Main menu** gives you three things to do:
1. Take the quiz
2. Check the leaderboard
3. Browse the question bank

Questions are loaded from `questions.txt` at startup. If the file doesn't exist it creates a sample one automatically. The order is shuffled every time so repeat attempts feel different.

Scores get saved to `leaderboard.txt` and sorted by highest score. If two players tie, it sorts alphabetically.

If you mistype during the quiz (like entering a letter instead of a number) it just asks again — you don't lose the point for a typo.

---

## File format for questions

Each line in `questions.txt` follows this pattern:

```
question text|option1|option2|option3|option4|correct_number
```

The last number is the correct answer (1 through 4). If your question or option text contains a pipe character, escape it with a backslash: `\|`

---

## Project structure

```
quizapp/
  Main.java           - menu loop, entry point
  Question.java       - stores a single question
  QuizManager.java    - handles quiz logic, file reading, leaderboard
  TestQuizEngine.java - tests (no JUnit, just assertions)
questions.txt         - question bank
leaderboard.txt       - saved scores
```

---

## Running it

Compile from the project root:
```bash
javac -d bin quizapp/*.java
```

Run:
```bash
java -cp bin quizapp.Main
```

Run tests (needs `-ea` to enable assertions):
```bash
java -ea -cp bin quizapp.TestQuizEngine
```
