// Name: Akanksha Priya
// USC NetID: apriya
// CS 455 PA4
// Fall 2018

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ScoreComparator implements Comparator<Map.Entry<String, Integer>>{

	@Override
	public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
		if(e1.getValue() > e2.getValue())return -1;
		else if (e1.getValue() < e2.getValue()) return 1;
		else {
			return e1.getKey().compareTo(e2.getKey()) ;
		}
	}

}
