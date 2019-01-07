
// Name: Akanksha Priya
// USC NetID: apriya
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFinder {

	/**
	 * Get all words of the given string.
	 * 
	 * @param args Contains the filename to dictionary to be used for finding words
	 * @exception FileNotFoundException
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Type . to quit.");

		String dictionaryName = "";
		if (args.length == 0) {
			dictionaryName = "sowpods.txt";
		} else {
			dictionaryName = args[0];
		}
		String str;
		try {
		AnagramDictionary ad = new AnagramDictionary(dictionaryName);
		
			while (in.hasNextLine() && (!(str = in.nextLine()).equals("."))) { // reads from input file
				String input = str;
				Rack rack = new Rack(input); // Initializes rack
				ArrayList<String> allSubsetCombos = rack.fetchAllSubsets();

				ArrayList<String> listOfAllWords;
				listOfAllWords = fetchAnagramsOfSubset(allSubsetCombos, ad);

				ScoreTable scoreTable = new ScoreTable();
				HashMap<String, Integer> anagramScoreMap = scoreTable.getWordScoreList(listOfAllWords);

				displayScoreList(anagramScoreMap, listOfAllWords.size(), input);
			}
			System.out.print("Rack? ");

		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + dictionaryName);
		}
	}

	/**
	 * Method to sort words list in decreasing order of their score.
	 * 
	 * @return sorted list in decreasing order of their score
	 */
	private static void displayScoreList(HashMap<String, Integer> anagramScoreMap, int sizeoOfList,
			String inputString) {
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : anagramScoreMap.entrySet()) {
			list.add(entry);
		}
		Collections.sort(list, new ScoreComparator());
		System.out.println("Rack? We can make " + sizeoOfList + " words from " + "\"" + inputString + "\"");

		if (sizeoOfList > 0) {
			System.out.println("All of the words with their scores (sorted by score):");
			for (Map.Entry<String, Integer> entry : list) {
				System.out.println(entry.getValue() + ": " + entry.getKey());
			}
		}

	}

	/**
	 * Method to fetch anagrams of subset
	 * 
	 * @param allSubsetCombos list of all subset of given string
	 * @param fileName        name of dictionary to look for words
	 * @return sorted list in decreasing order of their score
	 */
	private static ArrayList<String> fetchAnagramsOfSubset(ArrayList<String> allSubsetCombos, AnagramDictionary ad)
			throws FileNotFoundException {
		ArrayList<String> listOfAllWords = new ArrayList<>();
		for (String s : allSubsetCombos) {
			ArrayList<String> arr = ad.getAnagramsOf(s, new MultiSet(s));
			listOfAllWords.addAll(arr);
		}
		return listOfAllWords;
	}

}
