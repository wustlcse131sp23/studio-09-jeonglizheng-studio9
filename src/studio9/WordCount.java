package studio9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {

		// FIXME
		Map<String, Integer> numOfWords = new HashMap<>();
		
		for (String word : words) {
			if (numOfWords.containsKey(word)) {
				numOfWords.put(word, numOfWords.get(word) + 1);
			}
			else {
				numOfWords.put(word, 1);
			}
		}
		
		return numOfWords;
		
//		Set<String> keySet = new HashSet<>();
//		
//		for (String word : words) {
//			keySet.add(word);
//		}
//		
//		int num = 0;
//		
//		for (String key : keySet) {
//			for (String word : words) {
//				if (key.equals(word)) {
//					num +=1;
//				}
//			}
//			numOfWords.put(key, num);
//			num = 0;
//		}

	}
}
