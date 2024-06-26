package ocdsimulator;

import java.util.Scanner;

/**
 * Intrusive thought class focused on important people.
 */
public class ImportantPersonIntrusiveThought extends IntrusiveThought {

    /**
     * Array of user's important people (family member, friend, loved one)
     */
    private String[] importantPeople;

    /**
     * Puts important people intrusive thoughts in array
     * Sets important people
     */
    public ImportantPersonIntrusiveThought() {
        // Set array of important people, get user input
        int peopleLength = 3;
        importantPeople = new String[peopleLength];
        setImportantPeople();

        // Put thoughts, which will use the people to fill blanks, in the
        // thought subject array

        // Create thoughts
        String thought0 = "What if I don't really love ";
        String thought1 = "What if I harm ";
        String thought2 = "What if I am never talked to again by ";
        String thought3 = "What if I am not loved by ";
        String thought4 = "What if something kills ";

        thoughtSubjectsLength = 5;

        thoughtSubjects = new String[thoughtSubjectsLength];
        thoughtSubjects[0] = thought0;
        thoughtSubjects[1] = thought1;
        thoughtSubjects[2] = thought2;
        thoughtSubjects[3] = thought3;
        thoughtSubjects[4] = thought4;
    }

    /**
     * User sets the important family member, friend, and loved one 
     */
    protected void setImportantPeople() {
        Scanner scanPeople = new Scanner(System.in);
        // Asks user for people important to them, this is meant to personalize
        // the thoughts
        // Family member
        System.out.println("Who is a family member you hold close?");
        String familyMember = scanPeople.nextLine();

        // Friend
        System.out.println("Who is a friend you hold close?");
        String friend = scanPeople.nextLine();

        // Someone you love
        System.out.println(
            "Who is someone you love? (Romantically or otherwise)?");
        String lovedPerson = scanPeople.nextLine();

        // scanPeople.close();

        // Put people in the array
        importantPeople[0] = familyMember;
        importantPeople[1] = friend;
        importantPeople[2] = lovedPerson;

        System.out.println();
    }

    /**
     * Generates the thought corresponding to thought number
     * Randomly chooses a person to focus the thought on
     * @param thoughtNum Index
     * @return The thought
     */
    @Override
    protected String generateThought(int thoughtNum) {
        // Generate thought based on number passed in
        // Get the thought and person targeted
        String thoughtPart = thoughtSubjects[thoughtNum];
        String targetedPerson = getPerson();

        // Concatenate thought and person and question mark
        String intrusiveThought = thoughtPart + targetedPerson + "?";

        return intrusiveThought;
    }

    /**
     * Gets a random person from the person array
     * @return Random person
     */
    protected String getPerson() {
        // Get a random person
        int personNum = (int)(Math.random() * importantPeople.length);
        String person = importantPeople[personNum];
        return person;
    }

    /**
     * Gets the associated avoidance compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Avoidance compulsion
     */
    @Override
    protected String getAvoidance(int thoughtNum) {
        // Choose associated avoidance
        String avoidance;

        switch (thoughtNum) {
            case 0:
                avoidance = "I need to make this bad thought go away.";
                break;
            case 1:
                avoidance = "I am going to avoid them so I don't hurt them.";
                break;
            case 2:
                avoidance = "I have to stop doing things they might not like "
                    + "so they don't stop talking to me.";
                break;
            case 3:
                avoidance = "I need to stop them from not loving me.";
                break;
            default:
                avoidance = "I need to keep them near me so I can keep "
                    + "them safe. I don't want to lose them.";
                break;
        }

        return avoidance;
    }

    /**
     * Gets the associated rationalization compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Rationalization compulsion
     */
    @Override
    protected String getRationalize(int thoughtNum) {
        // Choose associated rationalization
        String rationalize;

        switch (thoughtNum) {
            case 0:
                rationalize =
                    "That is ridiculous. I love so many different traits about"
                        + " them, so there is no way I could not love them.";
                break;
            case 1:
                rationalize = "I could never harm someone I love. I am not an "
                    + "evil person.";
                break;
            case 2:
                rationalize = "I have not done anything that could warrant "
                    + "them not talking to me, so it is ridiculous.";
                break;
            case 3:
                rationalize = "I don't think they would just stop loving me "
                    + "for no reason, but maybe.";
                break;
            default:
                rationalize =
                    "My brain just made that up. There is no imminent "
                        + "danger coming for them, just like there wasn't "
                        + "before today.";
                break;
        }

        return rationalize;
    }

    /**
     * Gets the associated reassurance compulsion for corresponding obsessive thought
     * @param thoughtNum Thought's position in array
     * @return Reassurance compulsion
     */
    @Override
    protected String getReassurance(int thoughtNum) {
        // Choose associated reassurance
        String reassurance;

        switch (thoughtNum) {
            case 0:
                reassurance =
                    "I am going to call them to tell them I love them and review"
                        + " everything I've ever done to show them that I do.";
                break;
            case 1:
                reassurance =
                    "I wouldn't hurt them because I love them so much.";
                break;
            case 2:
                reassurance =
                    "I am going to ask them if they would ever stop talking to me.";
                break;
            case 3:
                reassurance = "I need to ask them if they love me still.";
                break;
            default:
                reassurance = "I need to check if they are alive.";
                break;
        }

        return reassurance;
    }

}
