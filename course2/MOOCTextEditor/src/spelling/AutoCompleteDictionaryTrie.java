package spelling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An trie data structure that implements the Dictionary and the AutoComplete
 * ADT
 * 
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements Dictionary, AutoComplete {

	private TrieNode root;
	private int size;

	public AutoCompleteDictionaryTrie() {
		root = new TrieNode();
	}

	/**
	 * Insert a word into the trie. For the basic part of the assignment (part
	 * 2), you should ignore the word's case. That is, you should convert the
	 * string to all lower case as you insert it.
	 */
	public boolean addWord(String word) {
		// TODO: Implement this method.
		String wordLowerCase = word.toLowerCase();

		TrieNode node = root;

		for (int i = 0; i < wordLowerCase.length(); i++) {
			char c = wordLowerCase.charAt(i);

			if (node.getValidNextCharacters().contains(c)) {
				node = node.getChild(c);
			} else {
				node = node.insert(c);
			}
		}
		if (!node.endsWord()) {
			node.setEndsWord(true);
			size++;
			return true;
		}

		return false;
	}

	/**
	 * Return the number of words in the dictionary. This is NOT necessarily the
	 * same as the number of TrieNodes in the trie.
	 */
	public int size() {
		// TODO: Implement this method
		return size;
	}

	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) {
		// TODO: Implement this method
		s = s.toLowerCase();

		TrieNode node = root;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (node.getValidNextCharacters().contains(c)) {
				node = node.getChild(c);
			} else {
				return false;
			}
		}

		if (node.endsWord()) {
			return true;
		}
		return false;
	}

	/**
	 * * Returns up to the n "best" predictions, including the word itself, in
	 * terms of length If this string is not in the trie, it returns null.
	 * 
	 * @param text
	 *            The text to use at the word stem
	 * @param n
	 *            The maximum number of predictions desired.
	 * @return A list containing the up to n best predictions
	 */
	@Override
	public List<String> predictCompletions(String prefix, int numCompletions) {
		// TODO: Implement this method
		// This method should implement the following algorithm:
		// 1. Find the stem in the trie. If the stem does not appear in the
		// trie, return an
		// empty list
		// 2. Once the stem is found, perform a breadth first search to generate
		// completions
		// using the following algorithm:
		// Create a queue (LinkedList) and add the node that completes the stem
		// to the back
		// of the list.
		// Create a list of completions to return (initially empty)
		// While the queue is not empty and you don't have enough completions:
		// remove the first Node from the queue
		// If it is a word, add it to the completions list
		// Add all of its child nodes to the back of the queue
		// Return the list of completions

		List<String> predictList = new LinkedList<String>();
		TrieNode node = root;
		prefix = prefix.toLowerCase();

		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);

			if (node.getValidNextCharacters().contains(c)) {
//				System.out.println("c: " + c);
//				System.out.println("node.getValidNextCharacters(): " + node.getValidNextCharacters());
				node = node.getChild(c);
				
			} else {
				return predictList;
			}
		}

//		System.out.println("outside for - node.getValidNextCharacters(): " + node.getValidNextCharacters());
//		System.out.println("\npredictCompletions: " + node.getValidNextCharacters());
		// List<TrieNode> trieNodeQueue = new LinkedList<TrieNode>();
		Queue<TrieNode> trieNodeQueue = new LinkedList<TrieNode>();

		trieNodeQueue.add(node);

		TrieNode curr = null;

		
		
		while (trieNodeQueue.size() > 0) {
			curr = trieNodeQueue.remove();
//			System.out.println("curr.getText(): " + curr.getText());
			if (curr.endsWord()) {
//				System.out.println("\ncurr.getText() - endsWord if: " + curr.getText());
				if(predictList.size() < numCompletions) {
//					System.out.println("predictList.size() - : " + predictList.size());
					predictList.add(curr.getText());
				} else {
//					System.out.println("inside else");
					return predictList;
				}
			}
			for (Character c : curr.getValidNextCharacters()) {
//				 System.out.println("curr.getValidNextCharacters() - inside for loop: " + c);
				if (curr.getChild(c) != null) {
					trieNodeQueue.add(curr.getChild(c));
				}
			}
//			System.out.println("triNodeQueue.Size() - inside while: " + trieNodeQueue.size());
		}
		return predictList;
	}

	// For debugging
	public void printTree() {
		printNode(root);
	}

	/** Do a pre-order traversal from this node down */
	public void printNode(TrieNode curr) {
		if (curr == null)
			return;

		System.out.println(curr.getText());

		TrieNode next = null;
		for (Character c : curr.getValidNextCharacters()) {
			next = curr.getChild(c);
			printNode(next);
		}
	}

}