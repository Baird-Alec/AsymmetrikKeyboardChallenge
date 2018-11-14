
import java.util.*;

public class AutoCompleteProvider
{
    //member variables
    List<Candidate> dictionary = new ArrayList<Candidate>();

    //returns the list of matches to the string parameter
    List<Candidate> getWords(String fragment)
    {
        //TODO: binary search to find word that begins with fragment
        //then search forward and backward until all Candidates are found
        //(if you hit a word that doesn't start with fragment, stop that search)
        List<Candidate> matches = new ArrayList<Candidate>();

        for (int i = 0; i < dictionary.size(); i++)
        {
            boolean matchedCondition = dictionary.get(i).getWord().startsWith(fragment);
            if (matchedCondition)
            {
                Candidate match = new Candidate(dictionary.get(i).getWord(), dictionary.get(i).getConfidence());
                matches.add(match);
            }
        }

        //sort list with highest confidence first
        Collections.sort(matches, Candidate.numerical);
        return matches;
    }

    void train(String passage) {

        //split string into words
        String[] temp = passage.split("\\s+");

        //convert array to list for comparisons later
        List<String> words = Arrays.asList(temp);


        for (int i = 0; i < words.size(); i++) {

            //Check if word is already in dictionary
            boolean isThere = false;
            int index = 0;

            //TODO: make binary search later
            for (int k = 0; k < dictionary.size(); k++) {
                //if words are equal, set bool to true
                if (words.get(i).equals(dictionary.get(k).getWord())) {
                    isThere = true;
                    index = k;
                }
            }

            //If bool was true, increment confidence at word location by one
            if (isThere) {
                dictionary.get(index).setConfidence(dictionary.get(index).getConfidence() + 1);
            }

            //create new Candidate, store in dictionary
            else {
                Candidate newWord = new Candidate(words.get(i).toLowerCase(), 1);
                dictionary.add(newWord);
            }
        }

        //sort list for binary searching later
        Collections.sort(dictionary, Candidate.alphabetical);
    }
}