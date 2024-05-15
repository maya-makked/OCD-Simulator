package ocdsimulator;

import java.util.Scanner;

/**
 * Intrusive thought class focused on deep fears.
 */
public class DeepFearIntrusiveThought extends IntrusiveThought {

    /**
     * Array of user's fears
     */
    private String[] fears;

    /**
     * Puts deep fear intrusive thoughts in array
     * Sets fears
     */
    public DeepFearIntrusiveThought() {
        // Set array of deep fears, get user input
        int fearsLength = 2;
        fears = new String[fearsLength];
        setDeepFears();

        // Fears will go after "what if"

        // Create thought
        String thought0 = "What if ";

        thoughtSubjectsLength = 1;

        thoughtSubjects = new String[1];
        thoughtSubjects[0] = thought0;
    }


    /**
     * User sets deep fears
     */
    protected void setDeepFears() {
        Scanner scanFears = new Scanner(System.in);
        // Asks user for deep fears, this is meant to personalize the thoughts
        // Fear 1
        System.out.println("What is a deep fear you have? Please fill in the underline: What if _______?\n"
            + "Ex. What if A SPIDER IS IN MY HAIR?");
        String fear1 = scanFears.nextLine();

        // Fear 2
        System.out.println("What is another deep fear you have? Please fill in the underline: What if _______?\n"
            + "Ex. What if A SPIDER IS IN MY HAIR?");
        String fear2 = scanFears.nextLine();

        // Put fears in the array
        fears[0] = fear1;
        fears[1] = fear2;

        System.out.println();
    }


    /**
     * Generate thought of one of the user's deep fears
     * @param thoughtNum Index
     * @return The thought
     */
    @Override
    protected String generateThought(int thoughtNum) {
        // Generate thought based on number passed in
        // Get the thought and fear targeted
        String thoughtPart = thoughtSubjects[thoughtNum];
        String targetedFear = getFear();

        // Concatenate thought and fear and question mark
        String intrusiveThought = thoughtPart + targetedFear + "?";

        return intrusiveThought;
    }


    /**
     * Gets a random fear from the fear array
     * @return Random fear
     */
    protected String getFear() {
        // Get a random fear
        int fearNum = (int)(Math.random() * fears.length);
        String fear = fears[fearNum];
        return fear;
    }
    

    /**
     * Gets the avoidance compulsion for the fears
     * @param thoughtNum Thought's position in array
     * @return Avoidance compulsion
     */
    @Override
    protected String getAvoidance(int thoughtNum) {
        // Choose associated avoidance
        String avoidance = "I am actively going to not think about it.";

        return avoidance;
    }


    /**
     * Gets the rationalization compulsion for the fears
     * @param thoughtNum Thought's position in array
     * @return Rationalization compulsion
     */
    @Override
    protected String getRationalize(int thoughtNum) {
        // Choose associated rationalization
        String rationalize = "This is an unreasonable fear for me to have. I will list reasons why.";

        return rationalize;
    }


    /**
     * Gets the reassurance compulsion for the fears
     * @param thoughtNum Thought's position in array
     * @return Reassurance compulsion
     */
    @Override
    protected String getReassurance(int thoughtNum) {
        // Choose associated reassurance
        String reassurance = "This is not happening right now.";

        return reassurance;
    }

}
