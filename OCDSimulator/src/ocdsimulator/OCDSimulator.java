package ocdsimulator;

import java.util.Scanner;

public class OCDSimulator {

    public static void main(String[] args) {

        // Display introduction message
        System.out.println(
            "Welcome to the OCD Simulator. The purpose of this simulator is to simulate the mind of someone with");
        System.out.println(
            "OCD. The point is not to win by choosing the correct answer, but rather to give you an indepth view");
        System.out.println(
            "of an OCD mind. Please note that obsessions and compulsions are not limited to the ones in this");
        System.out.println("simulator, as there are infinite.\n");

        // Generic intrusive thoughts
        GenericIntrusiveThought generic = new GenericIntrusiveThought();
        // Intrusive thoughts pertaining to important people
        ImportantPersonIntrusiveThought importantPeople =
            new ImportantPersonIntrusiveThought();

        // Run the OCD cycle
        while (true) {
            // Generate a random number to choose a class of intrusive thoughts
            int thoughtClass = (int)(Math.random() * 2);

            switch (thoughtClass) {
                case 0:
                    // Generic instrusive thoughts
                    generic.obsessionAndCompulsions();
                    break;
                case 1:
                    // Important people intrusive thoughts
                    importantPeople.obsessionAndCompulsions();
                    break;
            }

        }

    }

}
