package Question1;
// Question1.ConsoleDisplayInterface.java
// Austin Teshuba
// This is an interface for a general wheel counter

public interface ConsoleDisplayInterface<T> {
    /**
     * reset function
     * This must reset the counter to the minimum value
     */
    public void reset();
    /**
     * increase function
     * This must increase the counter by one unit
     */
    public void increase();

    /**
     *
     * @param theWheel
     * @return
     */
    public T getWheelValue(int theWheel);
    public int getWheelsInUse();

}
