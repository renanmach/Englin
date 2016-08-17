package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import constants.Constants;
import words.Language;
import words.Word;

public class FileUtil {
	public static List<Word> readVocabularyFile(String input) {
		List<Word> words = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line = br.readLine();
			String[] parts = line.split(Constants.LANGUAGES_DELIMITER);
			Language l1, l2;
			
			l1 = Language.valueOf(parts[0].toLowerCase());
			l2 = Language.valueOf(parts[1].toLowerCase());
			
			int i = 1;
			while(br.ready()) {
				line = br.readLine();				
				i++;
				
				if(line.isEmpty() || line.startsWith("#"))
					continue;
				
				parts = line.split(Constants.LANGUAGES_DELIMITER);
				
				if(parts.length != 2) {
					System.err.println("Warning line " + i + ": " + line);
					continue;
				}
				
				List<String> languageOneParts = Arrays.asList(parts[0].split(Constants.OPTIONS_DELIMITER));
				List<String> languageTwoParts = Arrays.asList(parts[1].split(Constants.OPTIONS_DELIMITER));
		
				Word word = new Word();
				
				for(String translation : languageOneParts) {
					word.addTranslation(translation.trim(), l1);
				}
				for(String translation : languageTwoParts) {
					word.addTranslation(translation.trim(), l2);
				}
				
				words.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return words;
	}
}
