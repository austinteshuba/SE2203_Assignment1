package Question1;
// Question1.Rollable.java
// Austin Teshuba
// This is an interface for wheels

public interface Rollable<T> {
    /**
     * reset function
     * This must reset the counter to the minimum value
     */
    void reset();

    /**
     * increase function
     * This must increase the counter by one unit
     */
    void increase();

    /**
     * This function must indicate if the last increase caused a rollover
     * @return This will be true if the last increase caused a rollover
     */
    boolean lastRolledOver();

    /**
     * This function must return the current value of the counter
     * @return the current value of the object
     */
    T getValue();
}
