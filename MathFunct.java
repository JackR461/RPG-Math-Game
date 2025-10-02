import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/* Using Random:
 *   Random random = new Random();
 *   int randInt = random.nextInt(2);   //generates random number of 1 or 0
 */

public class MathFunct {

    // Holds previous answers to math problems
    private static ArrayList<Integer> previousAnswers = new ArrayList<>();
    
    // Returns a random positive integer between two values (inclusive).
    // step: The counting amount (ex. step=2 means 0,2,4,6,...)
    public static int randomInt(int min, int max, int step) {
        int finalMin = min;
        int finalMax = max;
        // If min or max is less than zero, make it zero
        if (min < 0) {finalMin = 0;}
        if (max < 0) {finalMax = 0;}
        // If min > max, return 0
        if (min > max) {return 0;}
        // If step=0, return min
        if (step == 0) {return finalMin;}
        // Array of the potential numbers that can be selected
        ArrayList<Integer> nums = new ArrayList<>();
        // currentNum keeps track of the current number
        int currentNum = finalMin;
        // while currentNum has not passed the max possible number,
        // add it then increase it by the step amount.
        while (currentNum <= finalMax) {
            nums.add(currentNum);
            currentNum += step;
        }
        // if nums has a possible number to return,
        if (nums.size() > 0) {
            // select a random number to be returned from nums
            Random random = new Random();
            int selection = nums.get(random.nextInt(nums.size()));
            return selection;
        } else {
            // if there is no valid number to return, return 0
            return 0;
        }
    }
    // If no step is entered, assume step=1
    public static int randomInt(int min, int max) {
        return randomInt(min, max, 1);
    }

    // Runs a math problem given:
    //  -Fighter (parameters needed for #s)
    //  -Timer
    //  -AccuracyTracker
    public static void runProblem (Fighter fighter, Timer timer, AccuracyTracker accuracy) {
        // Used to read user's answers for math problems
        Scanner scanner = new Scanner(System.in);
        // Used to hold user's given answer
        int userAnswer;
        // Used to store numbers that will be added
        int[] nums = new int[fighter.getAddendNum()];
        // Used to hold the correct answer to the math problem
        int correctAnswer = 0;
        // Used to hold printed equation
        String mathEqn = "[";
        // Fills nums with the numbers to be added
        // and sums to correctAnswer and constructs mathEqn
        for (int i = 0; i < nums.length; i++) {
            nums[i] = randomInt(fighter.getMinAttackNum(), fighter.getMaxAttackNum(), fighter.getStepAttackNum());
            correctAnswer+=nums[i];
            mathEqn = mathEqn + nums[i];
            if (i < nums.length - 1) {
                mathEqn += "+";
            } else {
                mathEqn += "]=";
            }
        }
        // Add correct answer to list
        previousAnswers.add(correctAnswer);
        // Makes user solve the equation, and logs how long it took
        System.out.print(mathEqn);
        timer.startTimer();
        try {
            userAnswer = scanner.nextInt();
            timer.endTimer();
            if (userAnswer == correctAnswer) {
                // If answer is correct, add a true to accuracy
                System.out.println("Correct!");
                accuracy.addAccuracy(true);
            } else {
                // If answer is incorrect, add a false to accuracy
                System.out.println("Incorrect! (Correct answer: " + correctAnswer+")");
                accuracy.addAccuracy(false);
            }
        } catch (InputMismatchException e) {
            // If it is not an integer, it is treated as a wrong answer
            timer.endTimer();
            System.out.println("Integer not entered!");
            accuracy.addAccuracy(false);
        }
    }

    // Retrieve previous correct answer
    public static int getLastAnswer() {return previousAnswers.getLast();}
    // Retrieve all previous correct answers
    public static ArrayList<Integer> getPreviousAnswers() {return previousAnswers;}
    // Retrieve a correct answer at an index
    public static int getAnswer(int i) {return previousAnswers.get(i);}
    

}
