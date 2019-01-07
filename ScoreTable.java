
// Name: Akanksha Priya
// USC NetID: apriya
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ScoreTable {
	HashMap<Character, Integer> scoreMap = new HashMap<>();
	int[] scoreIndex = new int[26];

	public ScoreTable() {
		for (int i = 0; i < scoreIndex.length; i++) {
			scoreIndex['a' - 'a'] = 1;
			scoreIndex['b' - 'a'] = 3;
			scoreIndex['c' - 'a'] = 3;
			scoreIndex['d' - 'a'] = 2;
			scoreIndex['e' - 'a'] = 1;
			scoreIndex['f' - 'a'] = 4;
			scoreIndex['g' - 'a'] = 2;
			scoreIndex['h' - 'a'] = 4;
			scoreIndex['i' - 'a'] = 1;
			scoreIndex['j' - 'a'] = 8;
			scoreIndex['k' - 'a'] = 5;
			scoreIndex['l' - 'a'] = 1;
			scoreIndex['m' - 'a'] = 3;
			scoreIndex['n' - 'a'] = 1;
			scoreIndex['o' - 'a'] = 1;
			scoreIndex['p' - 'a'] = 3;
			scoreIndex['q' - 'a'] = 10;
			scoreIndex['r' - 'a'] = 1;
			scoreIndex['s' - 'a'] = 1;
			scoreIndex['t' - 'a'] = 1;
			scoreIndex['u' - 'a'] = 1;
			scoreIndex['v' - 'a'] = 4;
			scoreIndex['w' - 'a'] = 4;
			scoreIndex['x' - 'a'] = 8;
			scoreIndex['y' - 'a'] = 4;
			scoreIndex['z' - 'a'] = 10;
		}
	}

	public HashMap<String, Integer> getWordScoreList(ArrayList<String> listOfAllWords) {
		HashMap<String, Integer> anagramScoreMap = new HashMap<>();
		for (String word : listOfAllWords) {
			String wordL = word.toLowerCase();
			int score = 0;
			for (char ch : wordL.toCharArray()) {
				score += scoreIndex[ch - 'a'];
			}
			anagramScoreMap.put(word, score);
		}
		return anagramScoreMap;
	}

}
