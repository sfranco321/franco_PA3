
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;


public class franco_p1 {
    private static int num1;
    private static int num2;
    private static double userNum;
    private static final int NUM_QUESTIONS = 10;
    private static final double THRESHOLD = .0001;
    public static int numCorrect = 0; // number of questions answered correctly

    private static int userMsg;


    // Method to generate numbers
    private static void genNumbers(int userLevel) {
        SecureRandom rand = new SecureRandom();

        switch (userLevel) {
            case 1:
                num1 = rand.nextInt(9) + 1;
                num2 = rand.nextInt(9) + 1;
                break;

            case 2:
                num1 = rand.nextInt(99) + 1;
                num2 = rand.nextInt(99) + 1;
                break;

            case 3:
                num1 = rand.nextInt(999) + 1;
                num2 = rand.nextInt(999) + 1;
                break;

            case 4:
                num1 = rand.nextInt(9999) + 1;
                num2 = rand.nextInt(9999) + 1;
                break;

            default:
                System.out.println("Invalid entry");
        }

    }

    private static void genQuestion(int typeOfProblems) {
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);
        int caseFive; // to figure which type of problem in random mix

        switch (typeOfProblems) {

            case 1:
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                userNum = scnr.nextDouble();
                if (Math.abs(userNum - (num1 + num2)) < THRESHOLD) {
                    numCorrect++;
                    isRight();
                } else {
                    isWrong();
                }
                break;

            case 2:
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                userNum = scnr.nextDouble();
                if (Math.abs(userNum - (num1 * num2)) < THRESHOLD) {
                    numCorrect++;
                    isRight();
                } else {
                    isWrong();
                }
                break;

            case 3:
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                userNum = scnr.nextDouble();
                if (Math.abs(userNum - (num1 - num2)) < THRESHOLD) {
                    numCorrect++;
                    isRight();
                } else {
                    isWrong();
                }
                break;

            case 4:
                System.out.println("How much is " + num1 + " divided by " + num2 + "?\n Give answer to 4 decimal places");
                userNum = scnr.nextDouble();

                if (Math.abs(userNum - ((double)num1 / (double)num2)) < THRESHOLD) {
                    numCorrect++;
                    isRight();
                } else {
                    isWrong();
                }
                break;

            case 5:
                caseFive = rand.nextInt(4) + 1;
                randomQuestions(caseFive);
                break;

            default:
                break;
        }

    }
   private static void randomQuestions(int caseNum) {
       Scanner scnr = new Scanner(System.in);
       switch (caseNum) {

           case 1:
               System.out.println("How much is " + num1 + " plus " + num2 + "?");
               userNum = scnr.nextDouble();
               if (Math.abs(userNum - (num1 + num2)) < THRESHOLD) {
                   numCorrect++;
                   isRight();
               } else {
                   isWrong();
               }
               break;

           case 2:
               System.out.println("How much is " + num1 + " times " + num2 + "?");
               userNum = scnr.nextDouble();
               if (Math.abs(userNum - (num1 * num2)) < THRESHOLD) {
                   numCorrect++;
                   isRight();
               } else {
                   isWrong();
               }
               break;

           case 3:
               System.out.println("How much is " + num1 + " minus " + num2 + "?");
               userNum = scnr.nextDouble();
               if (Math.abs(userNum - (num1 - num2)) < THRESHOLD) {
                   numCorrect++;
                   isRight();
               } else {
                   isWrong();
               }
               break;

           case 4:
               System.out.println("How much is " + num1 + " divided by " + num2 + "?\n Give answer to 4 decimal places");
               userNum = scnr.nextDouble();

               if (Math.abs(userNum - ((double) num1 / (double) num2)) < THRESHOLD) {
                   numCorrect++;
                   isRight();
               } else {
                   isWrong();
               }
               break;

       }
   }
    private static void isRight() {
        Random rand = new Random();
        userMsg = rand.nextInt(4) + 1;
        switch (userMsg) {
            // case statements
            case 1:
                System.out.println("Very good!");
                break; // break is optional

            case 2:
                System.out.println("Excellent!");
                break; // break is optional

            case 3:
                System.out.println("Nice work!");
                break;

            case 4:
                System.out.println("Keep up the good work!");
                break;

            default:
                System.out.println("Yay! You got it!");
        }
    }

    private static void isWrong() {
        Random rand = new Random();
        userMsg = rand.nextInt(4) + 1;
        switch (userMsg) {
            case 1:
                System.out.println("No. Please try again.");
                break;

            case 2:
                System.out.println("Wrong. Try once more.");
                break;

            case 3:
                System.out.println("Don't give up!");
                break;

            case 4:
                System.out.println("No. Keep trying.");
                break;

            default:
                System.out.println("One more time.");
        }
    }

    private static void percentCorrect(int numCorrect) {
        double userScore;
        System.out.println("Correct: " + numCorrect);
        System.out.println("Incorrect: " + (NUM_QUESTIONS - numCorrect));
        userScore = numCorrect / 10.0;

        if (userScore < .75) {
            System.out.println("Please ask your teacher for extra help.");
        } else if (userScore > .75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }

    }


    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        char goAgain = 'Y';

        int typeOfProblems;
        int userLevel;

        while (goAgain == 'Y') {
            System.out.println("Enter difficulty level (1 to 4):");
            userLevel = scnr.nextInt();

            System.out.println("Enter type of problem:\n 1: Addition \n 2: Multiplication \n 3: Subtraction");
            System.out.println(" 4: Division \n 5: Random Mix of All Types");
            typeOfProblems = scnr.nextInt();


            for (int i = 0; i < NUM_QUESTIONS; ++i) {

                genNumbers(userLevel);
                genQuestion(typeOfProblems);
            }

            percentCorrect(numCorrect);
            System.out.println("Go again? Y or N");
            goAgain = scnr.next().charAt(0);
            // Check for correct case
            if (goAgain == 'y') {
                goAgain = 'Y';
            } else if (goAgain == 'n') {
                goAgain = 'N';
            }
        numCorrect = 0; // reset score
        }

    }
}

