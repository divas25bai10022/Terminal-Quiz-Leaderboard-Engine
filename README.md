
# Terminal Quiz & Leaderboard Engine

This is a Java terminal quiz project. The user can take a quiz, answer multiple choice questions, see their score, and check the leaderboard.

I made this project to practice basic Java concepts and file handling.

## Features

* Multiple choice quiz
* Questions are read from `questions.txt`
* Questions are shuffled before the quiz
* Score is calculated after the quiz
* Player scores are saved in `leaderboard.txt`
* Leaderboard can be viewed from the main menu
* All available questions can also be viewed
* Basic input validation is included

## Files

```text
quizapp/
    Main.java
    Question.java
    QuizManager.java
    TestQuizEngine.java

questions.txt
leaderboard.txt
```

`Main.java` is used to start the program and show the menu.

`Question.java` contains the question details.

`QuizManager.java` handles most of the quiz work, like loading questions, running the quiz and saving scores.

`TestQuizEngine.java` contains some basic tests.

`questions.txt` stores the questions and `leaderboard.txt` stores the scores.

## Question Format

The questions are stored in this format:

```text
question|option1|option2|option3|option4|correct option
```

Example:

```text
What is 2+2?|3|4|5|6|2
```

Here, `2` at the end means that option 2 is the correct answer.

## Running the Project

Make sure Java is installed on your system.

To compile the project:

```bash
javac -d bin quizapp/*.java
```

Then run it using:

```bash
java -cp bin quizapp.Main
```

The program will show a menu where you can choose to take a quiz, view the leaderboard, view questions, or exit.

## Testing

The project has a basic test file called `TestQuizEngine.java`.

To run it:

```bash
javac -d bin quizapp/*.java
java -ea -cp bin quizapp.TestQuizEngine
```

## Concepts Used

Some of the Java concepts used in this project are:

* Classes and objects
* ArrayList
* Loops
* If-else
* Scanner
* File handling
* Exception handling
* Methods
* Collections and shuffling

## Future Improvements

Some things that can be added later are:

* Timer for the quiz
* Different difficulty levels
* More question categories
* Negative marking
* Better player statistics
* GUI version
* Database support

