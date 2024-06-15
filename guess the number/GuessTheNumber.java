import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNumber, num, lowerBound = 1, upperBound = 100;
        int attempts, score, totalScore = 0;
        char ch;
        int additionalAttemptsCost = 20;
        int additionalAttempts = 5;

        System.out.println("...Welcome to the Guess The Number game...");

        Random rand = new Random();

        do {
            randomNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            // Uncomment the next line to display the random number for debugging purposes
            // System.out.println("random number: " + randomNumber);
            System.out.println("random number : "+randomNumber);
            attempts = 6;
            score = 10;

            while (attempts > 0) {
                System.out.println("Enter any number between 1 to 100: ");
                num = sc.nextInt();

                if (num == randomNumber) {
                    System.out.println("Congo! You guessed the number.");
                    totalScore += score;
                    break;
                } else if (num < randomNumber) {
                    System.out.println("Try again with a higher number.");
                } else {
                    System.out.println("Try again with a lower number.");
                }

                attempts--;
                score--;

                if (attempts == 0) {
                    System.out.println("Sorry! Your attempts are exhausted...");

                    System.out.println("Do you want more moves? (y/n)");
                    ch = sc.next().charAt(0);
                    if (ch == 'y' || ch == 'Y') {
                        if (totalScore >= additionalAttemptsCost) {
                            totalScore -= additionalAttemptsCost;
                            attempts += additionalAttempts;
                            additionalAttemptsCost *= 2; // Increase cost for next time
                        } else {
                            System.out.println("Sorry! You don't have enough score for adding more attempts...");
                        }
                    }
                }
            }

            System.out.println("The correct number was: " + randomNumber);
            System.out.println("Your Total Score: " + totalScore);
            System.out.println("Do you want to continue? (y/n)");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
        
        sc.close();
    }
}
