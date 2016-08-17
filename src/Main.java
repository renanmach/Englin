import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import RememberIt.RememberIt;
import util.FileUtil;
import words.Language;
import words.Word;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<String, String> parsedArgs = parseArgs(args);
		String input = parsedArgs.get("-input");
		
		List<Word> words = FileUtil.readVocabularyFile(input);
		RememberIt rememberIt = new RememberIt(words);
		
		printCredits();

		Scanner scanner = new Scanner(System.in);
		String op="";
		while(true) {
			printMenu();
			op = scanner.nextLine();
			
			if(op.equals("0")) {
				System.out.println("Leaving...");
				break;	
			}
			
			switch(op) {
			case "1":
				rememberIt.start(Language.ENGLISH, Language.PORTUGUESE, true, scanner);
				break;
			case "2":
				rememberIt.start(Language.ENGLISH, Language.PORTUGUESE, false, scanner);
				break;
			case "3":
				rememberIt.start(Language.PORTUGUESE, Language.ENGLISH, true, scanner);
				break;
			case "4":
				rememberIt.start(Language.PORTUGUESE, Language.ENGLISH, false, scanner);
				break;
			default:
				System.out.println("Warning: Invalid option!\n");
				break;
			}
		}
		scanner.close();
	}

	private static Map<String, String> parseArgs(String[] args) {
		Map<String, String> parsedArgs = new HashMap<>();
		
		if(args.length < 2 || args[0].equals("help") || args[0].equals("--help")|| args[0].equals("-h")) {
			printUsage(0);
			System.exit(1);
		}
		
		if(args[0].equals("-input")) {
			parsedArgs.put(args[0], args[1]);
		}
		
		else {
			printUsage(0);
			System.exit(1);
		}
		
		return parsedArgs;
	}

	private static void printUsage(int i) {
		
		
	}
	
	private static void printCredits() {
		System.out.println("**** RememberIt Alpha Version 2016 ****");
		System.out.println("**** By Renan Gomes Pereira ****");
		System.out.println("**** renangomespereira at gmail dot com ****");
		System.out.println();
	}
	
	private static void printMenu() {
		System.out.println("Choose an option:");
		System.out.println("    0 - Exit");
		System.out.println("    1 - English to Portuguese");
		System.out.println("    2 - English to Portuguese (infinite loop)");
		System.out.println("    3 - Portuguese to English");
		System.out.println("    4 - Portuguese to English (infinite loop)");
	}
}
