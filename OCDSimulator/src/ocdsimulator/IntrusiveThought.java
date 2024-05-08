package ocdsimulator;

import java.util.Scanner;

/**
 * Abstract class to represent an intrusive thought.
 */
public abstract class IntrusiveThought {

    /**
     * Array of thoughts
     */
    protected String[] thoughtSubjects;
    /**
     * Length of thoughts array
     */
    protected int thoughtSubjectsLength;
    /**
     * Mindful way of breaking OCD cycle
     */
    protected final String ACCEPTANCE =
            "I wholly accept you as a passing thought with no substance.";
    /**
     * Quit message
     */
    protected final String QUIT = "QUIT OCD SIMULATOR";

    /**
     * Generates random number to choose a thought
     * @return Random number
     */
    protected int chooseThoughtNumber() {
        int randThoughtNum = (int)(Math.random() * thoughtSubjectsLength);
        return randThoughtNum;
    }

    /**
     * Generates the thought corresponding to thought number
     * @param thoughtNum Index
     * @return The thought
     */
    protected abstract String generateThought(int thoughtNum);


    /**
     * Runs the OCD cycle
     */
    public abstract void obsessionAndCompulsions();


    /**
     * Gets the associated avoidance compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Avoidance compulsion
     */
    protected abstract String getAvoidance(int thoughtNum);


    /**
     * Gets the associated rationalization compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Rationalization compulsion
     */
    protected abstract String getRationalize(int thoughtNum);


    /**
     * Gets the associated reassurance compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Reassurance compulsion
     */
    protected abstract String getReassurance(int thoughtNum);


    /**
     * Gets and validates integer input for compulsion selection
     * @return Compulsion selection
     */
    protected int validateCompulsionInput() {
        // Input should be between 1-5 inclusive
        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
            option = scan.nextInt();
            if (option >= 1 && option <= 5) {
                valid = true;
            }
            else {
                System.out.println("Invalid option! Please pick again.");
            }
        }

        return option;
    }

}
