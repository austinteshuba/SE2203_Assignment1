package Question2;

import Question1.Rollable;
import Question2.Counter;

// Austin Teshuba
// Wheel.java
// This class extends the Counter class and is a rollable object
// That will keep a count of a number, but will rollover when required
// i.e. a wheel will count the hours on a clock as 1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,...
public class Wheel extends Counter implements Rollable<Integer> {

    // Create private fields that contain a minimum, maximum, and a flag
    // to indicate whether the last increase/decrease required a rollover
    private int minimum;
    private int maximum;
    private boolean rolledOver;

    /**
     * Constructor which will create a wheel
     * @param min The starting value of the wheel. This is the lowest value the wheel can have
     * @param max The highest value a wheel can have before rolling over
     */
    public Wheel(int min, int max) {
        this.minimum = min;
        this.maximum = max;
        this.counter = min;
    }

    /**
     * This will reset the wheel's value to the minimum value
     */
    public void reset() {
        counter = minimum;
    }

    /**
     * This will increment the wheel. If a rollover is required,
     * it will go back to the minimum and then indicate the roll over in the flag
     */
    public void increase() {
         if (counter + 1 > maximum) {
             counter = minimum;
             rolledOver = true;
         } else {
             super.increase();
             rolledOver = false;
         }
    }

    /**
     * This will decrease the value of the wheel
     * If a rollover is required, it will reset the counter to the maximum value
     * then indicate the roll over in the flag
     */
    public void decrease() {
        if (counter - 1 < minimum) {
            counter = maximum;
            rolledOver = true;
        } else {
            super.decrease();
            rolledOver = false;
        }
    }

    /**
     * This is a utility for letting the user know if the wheel was rolled over last iteration
     * @return true if rolled over on last increase/decrease, false if not
     */
    public boolean lastRolledOver() {
        return rolledOver;
    }

    /**
     * This returns the value of the wheel
     * @return value of the counter
     */
    public Integer getValue() {
        return counter;
    }

    /**
     * This gets string representation of the wheel
     * @return The string of the current count of the wheel
     */
    public String toString() {
        return String.valueOf(getCount());
    }


}
