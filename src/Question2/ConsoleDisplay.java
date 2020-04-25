package Question2;

import Question1.ConsoleDisplayInterface;
import Question1.Rollable;



// ConsoleDisplay.java
// Austin Teshuba
// This is a display that will contain up to three wheels.
public class ConsoleDisplay<T> implements ConsoleDisplayInterface<T> {
    // This array will hold the wheels.
    // Ignore the Unchecked assignment warning as per TA instructions
    // Since we know the details of the Rollable objects and we are casting from a generic type, it won't cause an error
    // under any circumstance
    private Rollable<T>[] wheels;

    /**
     * Constructor for one wheel
     * The wheel can be any Rollable object
     * @param wheelOne The wheel in the display. Will be added to wheels collection
     */
    public ConsoleDisplay(Rollable<T> wheelOne) {
        wheels = new Rollable[1];
        wheels[0] = wheelOne;
    }


    /**
     * Constructor for two wheels
     * The wheels can be any Rollable object
     * @param wheelOne The right-most wheel - will be added to the list last
     * @param wheelTwo The left-most wheel - will be added to the list first.
     */
    public ConsoleDisplay(Rollable<T> wheelOne, Rollable<T> wheelTwo){
        wheels = new Rollable[2];
        wheels[0] = wheelTwo;
        wheels[1] = wheelOne;
    }

    /**
     * Constructor for three wheels
     * The wheels can be any Rollable object
     * @param wheelOne The right-most wheel - will be added to the list last
     * @param wheelTwo The middle wheel - will be added to the list second
     * @param wheelThree The left-most wheel - will be added to the list first
     */
    public ConsoleDisplay(Rollable<T> wheelOne, Rollable<T> wheelTwo, Rollable<T> wheelThree){
        wheels = new Rollable[3];
        wheels[0] = wheelThree;
        wheels[1] = wheelTwo;
        wheels[2] = wheelOne;
    }

    /**
     * This will return a String representation of all the wheels in the display
     * @return a string representation of all the wheels
     */
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for (Rollable<T> w:wheels) {
            out.append(" ").append(w.toString());
        }
        return out.toString();
    }

    /**
     * This will reset all of the wheels to their minimum values
     */
    @Override
    public void reset() {
        for (Rollable<T> w: wheels){
            w.reset();
        }
    }

    /**
     * This will increase the value displayed in the console by one
     * It will begin at the right-most wheel. If it required a rollover, it will increase the previous wheel too
     * Until a rollover is not required.
     */
    @Override
    public void increase() {
        for (Rollable<T> w: wheels) {
            w.increase();
            if (!w.lastRolledOver()){
                break;
            }
        }
    }

    /**
     * This returns the value of the specified wheel
     * @param theWheel this is the natural number wheel we want to retrieve. This is not an index (i.e. 1 is first, 2 is second)
     * @return The value of the specified wheel
     */
    @Override
    public T getWheelValue(int theWheel) {
        return wheels[theWheel-1].getValue();
    }

    /**
     * This returns the amount of wheels currently in use
     * @return The size of the wheels collection
     */
    @Override
    public int getWheelsInUse() {
        return wheels.length;
    }
}
