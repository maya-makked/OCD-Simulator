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
     * Runs the OCD cycle
     */
    protected void obsessionAndCompulsions() {
        // Get obsession
        int thoughtNum = chooseThoughtNumber();
        String intrusiveThought = generateThought(thoughtNum);

        // Compulsions- avoidance, rationalize, reassurance, acceptance
        // Have to get the proper ones associated with the thought
        // Get avoidance
        String avoidance = getAvoidance(thoughtNum);
        // Get rationalize
        String rationalization = getRationalize(thoughtNum);
        // Get reassurance
        String reassurance = getReassurance(thoughtNum);

        // Loop the options display until user chooses acceptance
        // Allow quit option so that user can quit
        boolean cycleBroken = false;
        while (!cycleBroken) {
            // Display obsession
            System.out.println(intrusiveThought + "\n");

            // Display compulsion menu
            System.out.println("Choose:");
            System.out.println("1. Avoidance- " + avoidance);
            System.out.println("2. Rationalization- " + rationalization);
            System.out.println("3. Reassurance- " + reassurance);
            System.out.println("4. Acceptance- " + ACCEPTANCE);
            System.out.println("5. Quit- " + QUIT);

            // Now get user option
            int option = validateCompulsionInput();

            // Cycle keeps going if options 1-3 picked
            // Cycle breaks if acceptance chosen
            if (option == 4) {
                System.out.println(
                    "\nThe intrusive thought has peacefully passed by without "
                        + "bothering you...");
                cycleBroken = true;
            }
            // Quit simulation if quit chosen
            else if (option == 5) {
                System.exit(0);
            }

            System.out.println();

        }

        System.out.println();

    }


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
