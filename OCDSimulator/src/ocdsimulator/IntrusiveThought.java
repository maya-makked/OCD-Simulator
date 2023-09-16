package ocdsimulator;

import java.util.Scanner;

public abstract class IntrusiveThought {

    // Thought subjects
    protected String[] thoughtSubjects;
    protected int thoughtSubjectsLength;
    protected final String ACCEPTANCE =
        "I wholly accept you as a passing thought with no substance.";
    protected final String QUIT = "QUIT OCD SIMULATOR";

    // Methods
    // Choose thought number
    protected int chooseThoughtNumber() {
        int randThoughtNum = (int)(Math.random() * thoughtSubjectsLength);
        return randThoughtNum;
    }


    // Generate thought
    protected abstract String generateThought(int thoughtNum);


    // Produce OCD cycle
    public abstract void obsessionAndCompulsions();


    // Get avoidance
    protected abstract String getAvoidance(int thoughtNum);


    // Get rationalization
    protected abstract String getRationalize(int thoughtNum);


    // Get reassurance
    protected abstract String getReassurance(int thoughtNum);


    // Validates input for compulsion choice
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
