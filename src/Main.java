
import java.util.*;
public class Main
{

    public static void main(String[] args)
    {
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        String learn;
        String selection;
        String fragment;
        AutoCompleteProvider auto = new AutoCompleteProvider();

        //Menu
        do
        {
            System.out.println("Press 1 to train, 2 to test autocomplete, or 3 to quit: ");
            selection = sc.nextLine();

            switch(selection)
            {

                case "1":
                    System.out.println("Train: ");
                    learn = sc.nextLine();
                    auto.train(learn);
                    break;

                case "2":
                    System.out.println("Input: ");
                    fragment = sc.nextLine();
                    List<Candidate> potentials = auto.getWords(fragment);
                    for (int i = 0; i < potentials.size(); i++)
                    {
                        System.out.println(potentials.get(i).getWord() + " (" + potentials.get(i).getConfidence() + ") ");
                    }

                    break;

                case "3":
                    System.out.println("Thank you! ");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid selection: Please try again: ");
            }

        } while (run);




        sc.close();
    }
}