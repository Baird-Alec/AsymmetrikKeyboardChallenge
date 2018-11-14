//Each Candidate will hold one word and the amount of times that it has been trained.

import java.util.Comparator;

public class Candidate
{
    //member variables
    String word;
    int confidence;

    //constructor
    Candidate(String word, int confidence)
    {
        setWord(word);
        setConfidence(confidence);
    }

    //setters
    void setConfidence(int setter)
    {
        confidence = setter;
    }

    void setWord(String setter)
    {
        word = setter;
    }

    //getters
    String getWord()
    {
        return word;
    }

    int getConfidence()
    {
        return confidence;
    }

    //comparators
    public static Comparator<Candidate> alphabetical = new Comparator<Candidate>() {
        @Override
        public int compare(Candidate o1, Candidate o2) {
            String firstWord = o1.getWord();
            String secondWord = o2.getWord();
            return secondWord.compareTo(firstWord);
        }
    };

    public static Comparator<Candidate> numerical = new Comparator<Candidate>() {
        @Override
        public int compare(Candidate o1, Candidate o2) {
            int firstNum = o1.getConfidence();
            int secondNum = o2.getConfidence();
            return secondNum - firstNum;
        }
    };
}