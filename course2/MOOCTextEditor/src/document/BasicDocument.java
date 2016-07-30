package document;

import java.util.List;

/**
 * A naive implementation of the Document abstract class.
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document {
	/**
	 * Create a new BasicDocument object
	 * 
	 * @param text
	 *            The full text of the Document.
	 */
	public BasicDocument(String text) {
		super(text);
	}

	/**
	 * Get the number of words in the document. "Words" are defined as
	 * contiguous strings of alphabetic characters i.e. any upper or lower case
	 * characters a-z or A-Z
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords() {
		// TODO: Implement this method. See the Module 1 support videos
		// if you need help.
		List<String> tokens = getTokens("[a-zA-Z]+");
		return tokens.size();
	}

	/**
	 * Get the number of sentences in the document. Sentences are defined as
	 * contiguous strings of characters ending in an end of sentence punctuation
	 * (. ! or ?) or the last contiguous set of characters in the document, even
	 * if they don't end with a punctuation mark.
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences() {
		// TODO: Implement this method. See the Module 1 support videos
		// if you need help.
		List<String> tokens = getTokens("[^!?.]+");

		return tokens.size();
	}

	/**
	 * Get the number of syllables in the document. Words are defined as above.
	 * Syllables are defined as: a contiguous sequence of vowels, except for a
	 * lone "e" at the end of a word if the word has another set of contiguous
	 * vowels, makes up one syllable. y is considered a vowel.
	 * 
	 * @return The number of syllables in the document.
	 */
	@Override

	public int getNumSyllables() {
		// TODO: Implement this method. See the Module 1 support videos
		// if you need help.
		// List<String> tokens = getTokens("[aeiouyAEIOUY]+");
		// List<String> loneEs = getTokens("[^aeiouyAEIOUY]+[eE]\\b");
		// List<String> singleEs = getTokens("\\b[^aeiouyAEIOUY]*[eE]\\b");
		//
		// return tokens.size() - (loneEs.size() - singleEs.size());
		List<String> tokens = getTokens("[a-zA-Z]+");
		int totalNumberOfSyllables = 0;

		for (String word : tokens) {

			totalNumberOfSyllables += countSyllables(word);
		}
		return totalNumberOfSyllables;
	}

	/*
	 * The main method for testing this class. You are encouraged to add your
	 * own tests.
	 */
	public static void main(String[] args) {
//		 testCase(new BasicDocument("This is a test. How many??? "
//		 + "Senteeeeeeeeeences are here... there should be 5! Right?"),
//		 16, 13, 5);
//		 testCase(new BasicDocument(""), 0, 0, 0);
//		 testCase(new BasicDocument("sentence, with, lots, of, commas.! "
//		 + "(And some poaren)). The output is: 7.5."), 15, 11, 4);
//		 testCase(new BasicDocument("a"), 1, 1, 1);
//		 testCase(new BasicDocument("many??? Senteeeeeeeeeences are"), 6, 3,
//		 2);
//		 testCase(new BasicDocument("Here is a series of test sentences. Your program should "
//		 + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
//		 + "the correct amount of syllables (example, for example), "
//		 + "but most of them will."), 49, 33, 3);
//		 testCase(new BasicDocument("Segue"), 2, 1, 1);
//		 testCase(new BasicDocument("Sentence"), 2, 1, 1);
//		 testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
//		testCase(
//				new BasicDocument(
//						"Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
//				32, 15, 1);
//		 testCase(new BasicDocument("e"), 1, 1, 1);
//		 testCase(new BasicDocument("ue"), 1, 1, 1);
//		 testCase(new BasicDocument("Senatence"), 3, 1, 1);
//		 testCase(new BasicDocument("the"), 1, 1, 1);
//		 testCase(new BasicDocument("thee"), 1, 1, 1);
//		 testCase(new BasicDocument("thate"), 1, 1, 1);
//		 testCase(new BasicDocument("thatee"), 2, 1, 1);
//		 testCase(new BasicDocument("ee"), 1, 1, 1);
//		 testCase(new BasicDocument("ue"), 1, 1, 1);
//		 testCase(new BasicDocument("Senatence"), 3, 1, 1);
//		 testCase(new BasicDocument("the"), 1, 1, 1);
//		 testCase(new BasicDocument("thee"), 1, 1, 1);
//		 testCase(new BasicDocument("thate"), 1, 1, 1);
//		 testCase(new BasicDocument("thaataetaaaaaaaaaaaaaaaaaaaaaaaaaaaxaa"),
//		 4, 1, 1);
		String text;
		// text = "Here is a series of test sentences. Your program should "
		// + "find 3 sentences, 33 words, and 49 syllables. Not every word will
		// have "
		// + "the correct amount of syllables (example, for example), "
		// + "but most of them will.";
		text = "Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad.";
//		// text = "the";
//		System.out.println(text);
		BasicDocument bs = new BasicDocument(text);
		System.out.println(bs.getFleschScore());
	}

}
