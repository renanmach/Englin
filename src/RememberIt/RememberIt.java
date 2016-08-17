package RememberIt;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import words.Language;
import words.Word;

public class RememberIt {
	private List<Word> words;
	
	public RememberIt(List<Word> words) {
		this.words = words;
	}
	
	public void start(Language langFrom, Language langTo, boolean removeWords, Scanner scanner) {
		Random random = new Random();

		int id;
		System.out.println("Starting RememberIt from " + langFrom + " to " + langTo);
		System.out.println("    Total: " + words.size() + " words\n");
		
		String in;
		
		int i = 0;
		while(words.size() > 0) {
			id = random.nextInt(words.size());
			
			System.out.println(++i + " " + words.get(id).getWordsFromLanguage(langFrom));
			System.out.print("Press enter...");
			
			scanner.nextLine();
			
			System.out.println(words.get(id).getWordsFromLanguage(langTo));
			System.out.println();
			
			System.out.print("Press enter or 99 to exit...\n");
			in = scanner.nextLine();
			
			if(in.equals("99")) {
				System.out.println("Leaving RememberIt!\n");
				break;
			}
			
			if(removeWords)
				words.remove(id);
		}
	}
}
