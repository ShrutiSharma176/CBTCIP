# Task-1 : Guess The Number Game
## Description
Guess The Number" is a simple console-based game where the player tries to guess a randomly generated number between 1 and 100. The player has a limited number of attempts to guess the number correctly, 
and they score points based on their performance. If the player runs out of attempts,they have the option to purchase additional attempts using their score points.
## Running the Game
1. **Copy the Program:** Copy the code in your local machine.
2. **Compile the Program:** Open your terminal or command prompt, navigate to the directory where the GuessTheNumber.java file is located, and run **javac GuessTheNumber.java**
3. **Run the Program:** After compiling, run **java GuessTheNumber**
## How to Play
1. **Start the Game:** Run the program, and a random number between 1 and 100 will be generated.
2. **Guess the Number:** Enter your guesses. You will be prompted whether to guess higher or lower based on your input.
3. **Attempts:** You start with 6 attempts. For each wrong guess, you lose an attempt and a point.
4. **Score:** You start with 10 points per round. Each wrong guess decreases your score by 1.
5. **Win Condition:** If you guess the number correctly, you retain your score for that round.
6. **Out of Attempts:** If you run out of attempts, you have the option to buy 5 more attempts for 20 points.
7. **Continue Playing:** After each round, you can choose to play again or exit.


# Task-2 : Bank Management System
## Description
This is a simple console-based bank management system implemented in Java. It allows users to create accounts, deposit and withdraw funds, transfer money between accounts, and view account details.
## Features
1. **Create Account:** Allows users to create a new bank account with a unique account number, account holder name, and initial balance.
2. **Deposit Amount:** Users can deposit money into their account.
3. **Withdraw Amount:** Users can withdraw money from their account, ensuring they do not withdraw more than their available balance.
4. **Transfer Amount:** Users can transfer money from one account to another.
5. **View Account Detail:** Users can view the details of their account, including account number, holder name, and current balance.
## How to Use
1. **Copy the Program:** Copy the code in your local machine.
2. **Compile the Program:** Open your terminal or command prompt, navigate to the directory where the BankY.java file is located, and run **javac BankY.java**
3. **Run the Program:** After compiling, run **java BankY**
4. **Follow the Menu:** The program will display a menu with options to create an account, deposit funds, withdraw funds, transfer funds, and view account details. Enter the corresponding number for the action you want to perform and follow the prompts.

# Task-3: Examination System
## Description
This is a simple console-based examination system implemented in Java. It allows users to log in, answer multiple-choice questions, and get their scores. The system also features automatic submission of the exam after a set duration.
## Features
### User Management:
1. Users can log in with their roll number, username, and password.
2. Users' credentials are stored in a UserService class.
3. Users can update their profile and password.
### Question Management:
1. The exam consists of multiple-choice questions.
2. Each question has a set of options and one correct answer.
3. Users can select their answers, and the system calculates the score.
### Exam Management:
1. The exam duration is managed by a Timer class.
2. The exam is auto-submitted when the time is up.
3. Users can view their scores after submitting the exam.
## How to Use
1. **Copy the Program:** Copy the code in your local machine.
2. **Compile the Program:** Open your terminal or command prompt, navigate to the directory where the Examination.java file is located, and run **javac Examination.java**
3. **Run the Program:** After compiling, run **java Examination**
4. **Follow the Prompts**: The program will prompt you to log in with your roll number, username, and password. If the credentials are correct, you can proceed with the exam. Answer the questions by selecting the correct option number.
