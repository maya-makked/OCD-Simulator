package ocdsimulator;

import java.util.Scanner;

public class GenericIntrusiveThought extends IntrusiveThought {

    // Constructor
    // Creates the array for the intrusive thoughts
    public GenericIntrusiveThought() {
        // Put the thoughts in the thought subject array
        String thought0 = "What if I have a disease that will kill me?";
        String thought1 = "What if crash my car tomorrow?";
        String thought2 = "What if I yell something inappropriate?";
        String thought3 =
            "What if I'm really a horrible person and I just don't know?";
        String thought4 =
            "What if my hands are contaminated with deadly germs?";
        String thought5 = "What if my friends secretly hate me?";
        String thought6 = "What if I forgot something important?";
        String thought7 = "What if everything goes terribly wrong because "
            + "everything is not arranged perfectly?";
        String thought8 = "What if my faith is all a big lie?";
        String thought9 = "What if I did not actually turn in my assignment?";
        String thought10 = "What if I did not actually turn off the stove?";
        String thought11 = "What if I don't actually have OCD and my horrible "
            + "thoughts are real?";

        thoughtSubjectsLength = 12;

        thoughtSubjects = new String[thoughtSubjectsLength];
        thoughtSubjects[0] = thought0;
        thoughtSubjects[1] = thought1;
        thoughtSubjects[2] = thought2;
        thoughtSubjects[3] = thought3;
        thoughtSubjects[4] = thought4;
        thoughtSubjects[5] = thought5;
        thoughtSubjects[6] = thought6;
        thoughtSubjects[7] = thought7;
        thoughtSubjects[8] = thought8;
        thoughtSubjects[9] = thought9;
        thoughtSubjects[10] = thought10;
        thoughtSubjects[11] = thought11;
    }


    @Override
    protected String generateThought(int thoughtNum) {
        // Generate thought based on number passed in
        String intrusiveThought = thoughtSubjects[thoughtNum];
        return intrusiveThought;
    }


    @Override
    public void obsessionAndCompulsions() {
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


    @Override
    protected String getAvoidance(int thoughtNum) {

        // Choose associated avoidance
        String avoidance;

        switch (thoughtNum) {
            case 0:
                avoidance = "Avoid germs by cleaning everything and not "
                    + "touching anything.";
                break;
            case 1:
                avoidance =
                    "Don't drive the car tomorrow because you will die if "
                        + "you do.";
                break;
            case 2:
                avoidance = "Don't speak, keep quiet!";
                break;
            case 3:
                avoidance = "I am just not going to think about myself.";
                break;
            case 4:
                avoidance = "Avoid germs and dirtiness.";
                break;
            case 5:
                avoidance = "I should stop talking to my friends as much so I "
                    + "don't bother them.";
                break;
            case 6:
                avoidance = "Stop worrying you didn't forget anything! "
                    + "Avoid thinking about it.";
                break;
            case 7:
                avoidance = "Just stop interacting with the arrangment "
                    + "altogether, it is too stressful and disorganized "
                    + "to deal with.";
                break;
            case 8:
                avoidance = "Stop indulging in your faith, it is fake! It has "
                    + "all been a lie!";
                break;
            case 9:
                avoidance = "Avoid worrying about if you turned it in, you did "
                    + "it.";
                break;
            case 10:
                avoidance = "Stop using the stove to cook so you don't burn "
                    + "the house down.";
                break;
            default:
                avoidance = "Stop the horrible thoughts!!! You are awful for "
                    + "having them!!!";
                break;
        }

        return avoidance;
    }


    @Override
    protected String getRationalize(int thoughtNum) {

        // Choose associated rationalization
        String rationalize;

        switch (thoughtNum) {
            case 0:
                rationalize = "I don't have a disease. I would "
                    + "feel true symptoms if I did. My doctor would alert "
                    + "me of something as well.";
                break;
            case 1:
                rationalize = "There is nothing special about tomorrow that "
                    + "would make me crash. I know how to drive.";
                break;
            case 2:
                rationalize = "There is no reason to yell an obscenity.";
                break;
            case 3:
                rationalize = "I have done nothing to make me a horrible "
                    + "person. I am a good person. Think of all the good "
                    + "things I do.";
                break;
            case 4:
                rationalize = "I have not touched anything that would give "
                    + "me deadly germs. There is no need to wash my hands so "
                    + "many times because it is unproductive.";
                break;
            case 5:
                rationalize = "I am a great friend. My friends love me. "
                    + "Plus, if they did hate me, they are not worthy of me.";
                break;
            case 6:
                rationalize = "I have done everything I need. Relax.";
                break;
            case 7:
                rationalize = "If I don't put this one thing into place it "
                    + "will be fine.";
                break;
            case 8:
                rationalize = "My faith suddenly wouldn't become false. "
                    + "It has gotten me this far, it will continue to.";
                break;
            case 9:
                rationalize = "I turned it in. I went through the motions of "
                    + "doing so, from choosing the file to hitting submit.";
                break;
            case 10:
                rationalize = "I did turn off the stove. I remember doing it. "
                    + "There's no need to keep checking.";
                break;
            default:
                rationalize = "I have OCD. My thoughts are not real. "
                    + "I go through obsessive-compulsive cycles just as one "
                    + "with OCD would.";
                break;
        }

        return rationalize;
    }


    @Override
    protected String getReassurance(int thoughtNum) {

        // Choose associated reassurance
        String reassurance;

        switch (thoughtNum) {
            case 0:
                reassurance = "Check your symptoms and feel around your "
                    + "organs. Review what places you have been.";
                break;
            case 1:
                reassurance = "Check your car to make sure there is nothing "
                    + "wrong with it. Also practicing your driving skills.";
                break;
            case 2:
                reassurance = "I am not one to yell randomly. I have self "
                    + "control, right?";
                break;
            case 3:
                reassurance = "You need to examine all your past words and "
                    + "actions to really figure it out.";
                break;
            case 4:
                reassurance = "Wash your hands again just in case!";
                break;
            case 5:
                reassurance = "Ask your friends if they still like you.";
                break;
            case 6:
                reassurance = "Go over everything to make sure you have it "
                    + "all.";
                break;
            case 7:
                reassurance = "Arrange it until it is perfect!";
                break;
            case 8:
                reassurance = "You have to go through every belief and analyze "
                    + "it to make sure you still believe. You can't not "
                    + "believe, otherwise God will hate you.";
                break;
            case 9:
                reassurance = "Check again to make sure you turned it in.";
                break;
            case 10:
                reassurance = "Go check the stove! The house may burn down!!";
                break;
            default:
                reassurance = "You need to make sure you actually have OCD";
                break;
        }

        return reassurance;
    }

}
