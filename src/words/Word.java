package words;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.Constants;

// Class representing a word
public class Word implements Serializable{
	private static final long serialVersionUID = 4079382235045708574L;
	
	// This maps the languages of the word and a List with the word and 
	// possibly its synonyms
	private Map<Language, List<String>> wordMap;
	
	public Word(Map<Language, List<String>> wordMap) {
		this.wordMap = wordMap;
	}
	
	public Word() {
		this.wordMap = new HashMap<>();
	}

	public Map<Language, List<String>> getWordMap() {
		return wordMap;
	}

	public void setWordMap(Map<Language, List<String>> wordMap) {
		this.wordMap = wordMap;
	}
	
	// add a new translation to the word map
	public void addTranslation(String translation, Language language) {
		List<String> l = wordMap.get(language);
		
		if(l == null) {
			List<String> l2 = new ArrayList<>();
			l2.add(translation);
			wordMap.put(language, l2);
		}
		
		else {
			l.add(translation);
		}
	}
	
	public void removeLanguage(Language language) {
		wordMap.remove(language);
	}
	
	public boolean removeTranslation(Language language, String translation) {
		List<String> l = wordMap.get(language);
		translation = translation.trim();
		if(l != null) {
			for(String t : l) {
				if(t.equals(translation)) {
					l.remove(t);
					return true;
				}
			}
		}
		return false;
	}
	
	public String getWordsFromLanguage(Language language) {
		StringBuilder sb = new StringBuilder();
		
		List<String> l = wordMap.get(language);
		
		if(l == null)
			return null;
		
		if(l.size() > 0) {
			sb.append(l.get(0));
		}
		
		for(int i = 1 ; i < l.size(); i++) {
			sb.append(Constants.OPTIONS_DELIMITER + " " + l.get(i));
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if(wordMap == null)
			return null;
		
		for(Language language : wordMap.keySet()) {
			sb.append(language.toString() + ":\n");
			List<String> translations = wordMap.get(language);
			sb.append("    " + translations+"\n");
		}
		
		return sb.toString();
	}
}
