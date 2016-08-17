package words;

public enum Language {
	PORTUGUESE("Portuguese"),
	ENGLISH("English");
	
	
	private String nameAsString;
	
	private Language(String nameAsString) {
		this.nameAsString = nameAsString;
	}
	
	@Override
	public String toString() {
		return this.nameAsString;
	}
}
