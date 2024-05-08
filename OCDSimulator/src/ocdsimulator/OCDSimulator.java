package ocdsimulator;

/**
 * This class runs the OCD simulator, demonstrating the obsessive-compulsive mental pattern
 * of those with OCD.
 */
public class OCDSimulator {

    /**
     * Runs the OCD simulator
     * @param args Args
     */
    public static void main(String[] args) {

        // Display introduction message
        System.out.println("DESCRIPTION AND BACKGROUND");
        System.out.println("This simulator simulates the mind of someone with OCD, an incredibly misunderstood disorder. "
            + "\nThe simulator's goal is give someone an inside view on how an OCD mind behaves. The point\nis not to win "
            + "the simulation, but rather to explore.\r\n"
            + "\r\n"
            + "A person with OCD has obsessions in the form of intrusive thoughts. The thoughts are not\nthe person's real "
            + "thoughts, leading to great distress. Obsessive intrusive thoughts\noften attack what a sufferer finds important, "
            + "such as their morals and the people they care about. \nTo relieve the obsessions, a sufferer performs hard-to-resist "
            + "compulsions for temporary relief. \nCompulsions take on many different forms such as action, reassurance, "
            + "rationalization, avoidance, and more. \nUnfortunately, compulsions feed obsessions and perpetuate an exhausting OCD "
            + "cycle. \nThe true way to break an OCD cycle is to accept the intrusive thought as just a passing thought with\nno "
            + "substance and reality. Mindfulness is key.\r\n"
            + "\r\n"
            + "Disclaimer: It is important to note that the obsessions and compulsions used in this simulation are a tiny\n"
            + "fraction of the ones that sufferers may possibly have. In fact, obsessions and compulsions have\ninfinite "
            + "possibilites. Every OCD sufferer has their own obsessions and compulsions that may differ\nin content from "
            + "other sufferers. What is universal among all sufferers is the obsessive-compulsive mind pattern,\nwhich this "
            + "simulation is meant to demonstrate.\n");
        System.out.println("START OF SIMULATION");

        // Generic intrusive thoughts
        GenericIntrusiveThought generic = new GenericIntrusiveThought();
        // Intrusive thoughts pertaining to important people
        ImportantPersonIntrusiveThought importantPeople =
            new ImportantPersonIntrusiveThought();
        // Intrusive thoughts pertaining to deep fears
        DeepFearIntrusiveThought deepFears = new DeepFearIntrusiveThought();

        // Run the OCD cycle
        while (true) {
            // Generate a random number to choose a class of intrusive thoughts
            int thoughtClass = (int)(Math.random() * 9);
            
            //4/9 chance of generic
            if (thoughtClass >= 0 && thoughtClass < 4) {
                generic.obsessionAndCompulsions();
            }
            //4/9 chance of important people
            else if (thoughtClass >= 4 && thoughtClass < 8) {
                importantPeople.obsessionAndCompulsions();
            }
            //1/9 chance for deep fears, as there are only 2 thoughts in this class so there will be more variety
            else {
                deepFears.obsessionAndCompulsions();
            }
        }

    }

}
