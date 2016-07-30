package spelling;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		// AutoCompleteDictionaryTrie acdt = new AutoCompleteDictionaryTrie();
//		// String word = "eats";
//		// acdt.addWord(word);
//		AutoCompleteDictionaryTrie smallDict = new AutoCompleteDictionaryTrie();
////		Set<Character> keySet = new HashSet<Character>();
//		
//		smallDict.addWord("Hello");
//		smallDict.addWord("HElLo");
//		smallDict.addWord("hello");
//		smallDict.addWord("help");
//		smallDict.addWord("he");
//		smallDict.addWord("hem");
//		smallDict.addWord("hot");
//		smallDict.addWord("hey");
//		smallDict.addWord("a");
//		smallDict.addWord("subsequent");
//		
////		completions = smallDict.predictCompletions("hel", 10);
////		assertEquals(2, completions.size());
////		smallDict.printTree();
////		System.out.println(smallDict.isWord("Hello"));
//		List<String> predictList = new LinkedList<String>();
//		
//		predictList = smallDict.predictCompletions("x", 5);
//		
//		for(String predict : predictList) {
//			System.out.println("predict: " + predict);
//		}
////		System.out.println(smallDict.isWord("hello"));
		
		Dictionary d = new DictionaryHashSet();
		DictionaryLoader.loadDictionary(d, "data/dict.txt");
		List<String> retList = new ArrayList<String>();
		
		NearbyWords w = new NearbyWords(d);
		String s = "apple";
		int numSuggestions = 1;
//		retList = w.distanceOne(s, true);
		System.out.println("Orginal String: " + s);
		retList = w.suggestions(s, numSuggestions);
		
		System.out.println("retList.size() " + retList.size());
		for(int i = 0; i < retList.size(); i++) {
			System.out.print(retList.get(i) + ", ");
		}
		
	}

}
