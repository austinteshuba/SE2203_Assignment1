package Question3;
// Austin Teshuba
// FeelingsWheel.java
// This file implements the Rollable interface to create
// a feelings wheel. This wheel will iterate through a list of emotions
import Question1.Rollable;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FeelingsWheel implements Rollable<String> {
    // Private variables for indicating if the last increment required a rollover,
    // the string value, the current index in the array of feelings,
    // the file for imports, as well as the array of feelings.
    private boolean rollOver;
    private String value;
    private int currentIndex;
    private File file;
    private String[] feelings;
    private int[] rollovers;

    /**
     * Constructor
     * @param filename this is the file where all of the emotions can be found and loaded
     */
    public FeelingsWheel(String filename) {
        rollOver = false; // rollover starts as false

        // src/Question3/ is added to the filename as this is the file hierarchy in the project
        // where the files can be found
        file = new File("src/Question3/" + filename);
        int fileSize = getWheelSize(); // gets number of lines in the file
        feelings = new String[fileSize]; // create the feelings array with size = number of lines in the file
        rollovers = new int[getWheelSize()]; // creates the rollovers array with size = number of lines in the file
        getFeelingNames(); // load the feelings names


        currentIndex = -1;// start the index at -1 (will be increased to 0 on the first increment)

        increase(); // increment by one and load the first feeling


    }

    /**
     * This will get the size of the wheel by returning the number of lines in the wheel's file
     * @return number of lines in the file, or 0 if there is a load error.
     */
    private int getWheelSize() {
        try {
            return (int) Files.lines(Paths.get(file.getPath())).count(); // This uses Java utilities to get the file's path and return the number of lines in it
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Loads all of the feelings into the array.
     * Loads the rollover values into a related array. This will be used to tell the wheel if it must rollover the
     * previous wheel or not
     */
    private void getFeelingNames(){
        try {
            Scanner scan = new Scanner(file); // make scanner from file and start at index -

            int i = 0;
            while (scan.hasNextLine()) {
                // Parse the next line into the feeling then the rollover. Load both values into the appropriate array
                String s = scan.nextLine();
                String[] lineSplit = s.split(" ");
                feelings[i] = lineSplit[0];
                rollovers[i] = Integer.parseInt(lineSplit[1]);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This will reset the wheel to its first value
     */
    public void reset() {
        currentIndex = 0;
        value = feelings[currentIndex];
        rollOver = rollovers[currentIndex] !=0;
    }

    /**
     * This will increment the wheel to the next emotion
     */
    public void increase() {
        currentIndex = (currentIndex+1)%getWheelSize(); // This will reset the index to zero if it goes beyond the size of array

        value = feelings[currentIndex];
        rollOver = rollovers[currentIndex] != 0;

    }

    /**
     * This will indicate if the wheel rolled over on last iteration
     * @return value of rollOver flag
     */
    public boolean lastRolledOver() {
        return rollOver;
    }

    /**
     * This returns the current value of the wheel
     * @return the current value
     */
    public String getValue() {
        return value;
    }

    /**
     * THis returns the string representation of the wheel's value
     * @return getValue
     */
    public String toString(){
        return getValue();
    }
}
