package words;

import java.io.Serializable;

public enum Language implements Serializable{
	pt("Portuguese"),
	en("English");
	
	
	private String nameAsString;
	
	private Language(String nameAsString) {
		this.nameAsString = nameAsString;
	}
	
	@Override
	public String toString() {
		return this.nameAsString;
	}
}
