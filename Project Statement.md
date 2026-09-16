# Project Statement

## Problem Statement

The project is a small quiz application made in Java that runs in the terminal.

The basic idea is simple: the user should be able to start a quiz, answer the questions, and see the score at the end. The program also needs to check whether the input is valid and keep the score saved after the quiz is over.

For this, the questions are stored in `questions.txt` and the scores are stored in `leaderboard.txt`. This avoids the need for a database for a project of this size.

## Scope of the Project

The project currently focuses only on the basic quiz system.

It can load questions from a file, show them to the user, check the answers, calculate the score, and save the result in the leaderboard. The questions are also shuffled before a quiz starts.

The project is not meant to be an online quiz platform. It does not have a GUI, login system, online database, or multiplayer features. These could be added later, but they are outside the current version.

## Target Users

The main users are students or anyone who wants to take a quick quiz using a computer terminal.

The project can also be useful for beginners learning Java because it uses basic concepts such as classes, `ArrayList`, loops, `Scanner`, file handling, and exception handling.

## High-level Features

- Start and exit the quiz from a menu
- Enter a name before starting
- Load questions from `questions.txt`
- Shuffle questions for each quiz attempt
- Show four options for every question
- Check the selected answer
- Handle invalid input
- Show the final score and percentage
- Save scores in `leaderboard.txt`
- Display the leaderboard
- Display the available questions
- Create a sample question file if `questions.txt` is missing
- Run basic tests using `TestQuizEngine`