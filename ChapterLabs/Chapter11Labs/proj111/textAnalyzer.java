package proj111;

import java.util.Scanner;

public class textAnalyzer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Text Analyzer v0.01");
        System.out.println("Begin Typing");
        String phrase = input.nextLine();

        if (phrase.equals(""))//Check condition of no input
            System.exit(-1);

        int wordCount = 0;
        int sentenceLength = 0; //Variable definitions
        int beginPosition = 0;
        int endPosition = phrase.indexOf(' '); //Variable definitions

        while (endPosition != -1) {//covers case where sentence actually has multiple words denoted by space delimiter
            if (endPosition > beginPosition) {
                wordCount++;
                String word = phrase.substring(beginPosition, endPosition);
                sentenceLength += word.length();
            }
            beginPosition = endPosition + 1;
            endPosition = phrase.indexOf(' ', beginPosition);
        }

        if (beginPosition < phrase.length()) {//covers case where phrase just consists of one word.
            wordCount++;//wordcount becomes 1, showing that only one word exists.
            String word = phrase.substring(beginPosition, phrase.length());
            sentenceLength += word.length();
        }

        if (wordCount > 0) {//prints results of calculations.
            System.out.println("Word Count: " + wordCount + "\nAverage Word Length: " + ((double) (sentenceLength) / wordCount) + "\nSentence Length: " + sentenceLength);
        }
    }
}

/*
    /Trial code/
	String x
	String y
	for (int i = 0; i<x.length();i++){
				if(strIn.charAt(i) == ' ')
					break;
				y+=charAt(i);

	//Used to search and build words within a sentence.
*/