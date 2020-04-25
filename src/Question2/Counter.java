package Question2;

// Question2.Counter.java
// Austin Teshuba
// This file is a basic counter that will increase and decrease a number and store the count
public class Counter {
    protected int counter; // This has to be protected if it is to be inherited by the Wheel class

    /**
     * This will increase the counter by 1 unit
     */
    public void increase() {
        counter++;
    }

    /**
     * This will decrease the counter by 1 unit
     */
    public void decrease() {
        counter--;
    }

    /**
     * Returns the current count
     * @return the current count
     */
    public int getCount() {
        return counter;
    }

    /**
     * Returns string representation of current value
     * @return string representation of current value
     */
    public String toString() {
        return String.valueOf(counter);
    }
}
