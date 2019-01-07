
// Name: Akanksha Priya
// USC NetID: apriya
// CS 455 PA4
// Fall 2018

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Reprsents a Multi Set with unique elements but capturing the number of
 * occurrence in no particular order. unique - unique a string of unique letters
 * int array- stores the number of letters at ith position of unique
 */

public class MultiSet {
	private String unique;
	int[] mult;

	public MultiSet(String input) {
		String str = removeDuplicates(input);
		str = sortString(str);
		this.setUnique(str);
		this.mult = new int[str.length()];
		this.populateMultiSet(input);
	}

	public String getUnique() {
		return unique;
	}

	private void setUnique(String unique) {
		this.unique = unique;
	}

	public int[] getMult() {
		return mult;
	}

	/**
	 * Remove Duplicates from the given string PRE: The string is not null
	 * @param s the string from which the duplicate characters is to be removed
	 * @return string with unique letters
	 */

	private String removeDuplicates(String s) {
		Set<Character> uniqueSet = new HashSet<Character>();

		for (char c : s.toCharArray()) {
			uniqueSet.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (Character character : uniqueSet) {
			sb.append(character);
		}
		return sb.toString();
	}

	/**
	 * Sort the given string PRE: The string is not null
	 * 
	 * @param str the string to be sorted
	 * @return string in sorted order
	 */
	private String sortString(String str) {
		char[] chArr = str.toCharArray();
		Arrays.sort(chArr);
		return new String(chArr);

	}

	/**
	 * Populate the instance variable int[] mult with the occurence of each
	 * character in the given string str PRE: The string is not null
	 * 
	 * @param str the string to populate mult array
	 */

	public void populateMultiSet(String str) {
		TreeMap<Character, Integer> inputMap = new TreeMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Integer oldVal = inputMap.get(str.charAt(i));
			if (oldVal == null) {
				inputMap.put(str.charAt(i), 1);
			} else {
				inputMap.put(str.charAt(i), oldVal + 1);
			}
		}
		int index = 0;
		for (Integer value : inputMap.values()) {
			this.mult[index] = value;
			index++;
		}

	}

}
