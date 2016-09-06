package words;

// Simpler representation of a word
public class SimpleWord {
	private Language language1;
	private Language language2;
	private String wordLang1;
	private String wordLang2;
	private String examplePhrase; // TODO implement it
	
	public SimpleWord(Language l1, Language l2, String w1, String w2) {
		language1 = l1;
		language2 = l2;
		wordLang1 = w1;
		wordLang2 = w2;
		examplePhrase = ""; // TODO
	}
	
	public Language getLanguage1() {
		return language1;
	}
	public void setLanguage1(Language language1) {
		this.language1 = language1;
	}
	public Language getLanguage2() {
		return language2;
	}
	public void setLanguage2(Language language2) {
		this.language2 = language2;
	}
	public String getWordLang1() {
		return wordLang1;
	}
	public void setWordLang1(String wordLang1) {
		this.wordLang1 = wordLang1;
	}
	public String getWordLang2() {
		return wordLang2;
	}
	public void setWordLang2(String wordLang2) {
		this.wordLang2 = wordLang2;
	}

	public String getExamplePhrase() {
		return examplePhrase;
	}

	public void setExamplePhrase(String examplePhrase) {
		this.examplePhrase = examplePhrase;
	}
}
