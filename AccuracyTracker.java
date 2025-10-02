import java.util.ArrayList;

/*
 * Used to log accuracy of problems completed
 *  True -> correct
 *  False -> incorrect
 */
public class AccuracyTracker {
    
    // Attributes:
    private ArrayList<Boolean> accuracy;    // list of all accuracies

    // Basic constructor for accuracy
    public AccuracyTracker() {
        this.accuracy = new ArrayList<>();
    }

    // Getters:
    public ArrayList<Boolean> getAccuracyList() {return this.accuracy;}
    // Get last accuracy:
    public boolean getLastAccuracy() {return this.accuracy.getLast();}
    // Get accuracy at given index
    public boolean getAccuracy(int i) {return this.accuracy.get(i);}

    // Adds an accuracy to the list
    public void addAccuracy(boolean a) {this.accuracy.add(a);}

    // Determines percent of correct answers.
    // Truncates percent (ex. 33.33% -> 33)
    // If the list is empty, return 0
    public int checkAccuracyScore() {
        // Used to track number of right answers
        double correctAnswers = 0;
        // Determines total number of questions answered
        double total = this.accuracy.size();
        // If no questions answered, return 0
        if (total == 0) {return 0;}
        // For each question, determine if correct
        // and increase corrent answer count
        for (boolean question : accuracy) {
            if (question == true) {
                correctAnswers ++;
            }
        }
        return (int)(100*(correctAnswers/total));
    }

    // Returns length of accuracy array
    public int getAccuracySize() {return accuracy.size();}

}
