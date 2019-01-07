
// Name: Akanksha Priya
// USC NetID: apriya
// CS 455 PA4
// Fall 2018

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */

public class AnagramDictionary {
	private Scanner scan;
	private String fileName;
	HashMap<String, MultiSet> dictionaryMap = new HashMap<>();

	/**
	 * Create an anagram dictionary from the list of words given in the file
	 * indicated by fileName. PRE: The strings in the file are unique.
	 * 
	 * @param fileName the name of the file to read from
	 * @throws FileNotFoundException if the file is not found
	 */
	public AnagramDictionary(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		File file = new File(this.fileName);
		this.scan = new Scanner(file);
		while (scan.hasNext()) {
			String str = scan.next();
			dictionaryMap.put(str, new MultiSet(str));
		}

	}

	/**
	 * Get all anagrams of the given string. This method is case-sensitive. E.g.
	 * "CARE" and "race" would not be recognized as anagrams.
	 * 
	 * @param s string to process
	 * @return a list of the anagrams of s
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> getAnagramsOf(String s, MultiSet ms) {
		ArrayList<String> legitAnagrams = new ArrayList<>();
		int[] mult2 = ms.getMult();
		String s2 = ms.getUnique();
		if (s.length() == 0 || s.length() == 1) {
			return legitAnagrams;
		} else {
			for (Entry<String, MultiSet> entry : dictionaryMap.entrySet()) {

				String s1 = entry.getValue().getUnique();
				int[] mult1 = entry.getValue().getMult();

				if (s1.length() == s2.length()) {
					boolean isValidAnagram = true;
					for (int i = 0; i < s1.length(); i++) {
						if (s1.charAt(i) != s2.charAt(i) || mult1[i] != mult2[i]) {
							isValidAnagram = false;
						}
					}
					if (isValidAnagram) {
						legitAnagrams.add(entry.getKey());
					}

				}
			}
			return legitAnagrams;
		}

	}

}
