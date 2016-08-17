package RememberIt;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import words.Language;
import words.Word;

public class RememberIt implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Word> words;
	private Random random;
	private Language langFrom, langTo;
	
	public RememberIt(List<Word> words, Language langFrom, Language langTo) {
		this.words = words;
		this.random = new Random();
		this.langFrom = langFrom;
		this.langTo = langTo;
	}
	
	// get a random word from the list of words and remove it if chosen so
	public String[] getNextWord(boolean removeWords) {
		if(words.size() < 1) 
			return null;
		
		int id = random.nextInt(words.size());
		
		String[] result = new String[]
				{
					words.get(id).getWordsFromLanguage(langFrom),
					words.get(id).getWordsFromLanguage(langTo)
				};
		
		if(removeWords)
			words.remove(id);
		
		return result;
	}
}
