import java.util.ArrayList;
/*
 * Using timer:
 *  long startTime = System.nanoTime();
 *  [...code...]
 *  long endTime = System.nanoTime();
 *  long duration = (endTime-startTime)/1000000000;
 */

/*
 * Used to construct timers.
 * Timers round down to the closest second
 */
public class Timer {

    // Attributes:
    private long startTime;  // when timer starts
    private long endTime;    // when timer stops
    ArrayList<Long> times;   // all of the times stored in the timer

    // Basic constructor for timer
    public Timer() {
        this.times = new ArrayList<>();
    }

    // Getters:
    public long getStartTime() {return this.startTime;}
    public long getEndTime() {return this.endTime;}
    public ArrayList<Long> getAllTimes() {return this.times;}

    // Starts timer
    public void startTimer() {
        this.startTime = System.nanoTime();
    }

    // Ends timer, then calculates the time it took
    // and adds it to the array
    public void endTimer() {
        this.endTime = System.nanoTime();
        long duration = (this.endTime-this.startTime)/1000000000;
        this.times.add(duration);
    }

    // Gets last time calculated.
    // If the list is empty, return -1
    public long getLastTime() {
        if (times.size() == 0) {
            return -1;
        }
        return this.times.getLast();
    }

    // Gets a time at a select index.
    // If the index does not exist, return -1
    public long getTime(int index) {
        if (index > times.size()-1) {
            return -1;
        }
        return this.times.get(index);
    }

    // Gets the length of the times array
    public int getTimesSize() {return times.size();}

    // Adds a time to the array
    public void addTime(long time) {
        this.times.add(time);
    }

}
