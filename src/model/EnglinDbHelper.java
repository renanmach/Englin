package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import constants.Constants;
import model.EnglinDbContract.VocabularyEntry;
import util.FileUtil;
import words.SimpleWord;


// The database manager being used is the PostgreSQL

// Class with methods to create and delete tables and the database
public class EnglinDbHelper {
	// these constants are here because this is a learning purpose application
	// in its beginning stage of development
	private static final String DATABASE_NAME = "englin";
	private static final String USER = "postgres";
	private static final String PASSWD = "123";
	private static final String HOST = "localhost";
	private static final String PORT = "5432";
	
	private static final String CONNECTION_URL = "jdbc:postgresql://" 
			+ EnglinDbHelper.HOST 
			+ ":" + EnglinDbHelper.PORT
			+"/" + EnglinDbHelper.DATABASE_NAME;
	
	private static Connection getOpenConnection() {
		Connection conn = null;

		try {
			// loads JDBC
			Class.forName("org.postgresql.Driver");

			conn = DriverManager
					.getConnection(EnglinDbHelper.CONNECTION_URL,
							EnglinDbHelper.USER, 
							EnglinDbHelper.PASSWD);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
		
		return conn;
	}
	
	public static void createVocabularyTable() {
		// sql statement to create the vocabulary table
		final String CREATE_VOC_TABLE_STMT = 
				"CREATE TABLE " + VocabularyEntry.TABLE_NAME + "( "
				+ VocabularyEntry.COLUMN_ID + " SERIAL, "
				+ VocabularyEntry.COLUMN_VOCABULARY_NAME + " TEXT NOT NULL, "
				+ VocabularyEntry.COLUMN_WORD_LANGUAGE_1 + "  TEXT NOT NULL, "
				+ VocabularyEntry.COLUMN_WORD_LANGUAGE_2 + " TEXT NOT NULL, "
				+ VocabularyEntry.COLUMN_EXAMPLE_PHRASE + " TEXT "
				+ " );";
		
		Connection conn = getOpenConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(CREATE_VOC_TABLE_STMT);
			stmt.close();
		
			conn.close();
			
			System.out.println("Table " + VocabularyEntry.TABLE_NAME + " created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void dropVocabularyTable() {
		// sql statement to create the vocabulary table
		final String DROP_VOC_TABLE_STMT = 
				"DROP TABLE IF EXISTS " + VocabularyEntry.TABLE_NAME + ";";

		Connection conn = getOpenConnection();

		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(DROP_VOC_TABLE_STMT);
			stmt.close();

			conn.close();
			
			System.out.println("Table " + VocabularyEntry.TABLE_NAME + " dropped!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Insert a vocabulary file into the database
	public static void insertVocabularyFile(String vocabularyFilePath, String vocabularyName) {
		List<SimpleWord> words = FileUtil.readVocabularyFile2(vocabularyFilePath);
		// insert 100 words at time
		final int BATCH_SIZE = 100;
		
		Connection conn = getOpenConnection();

		try {
			PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO " + VocabularyEntry.TABLE_NAME 
					+ "( "
					+ VocabularyEntry.COLUMN_VOCABULARY_NAME + ","
					+ VocabularyEntry.COLUMN_WORD_LANGUAGE_1 + ","
					+ VocabularyEntry.COLUMN_WORD_LANGUAGE_2 + ","
					+ VocabularyEntry.COLUMN_EXAMPLE_PHRASE
					+ ")"
					+ " VALUES (?,?,?,?)");
			
			
			for(int i = 0 ; i < words.size(); i++) {
				insert.setString(1, vocabularyName);
				insert.setString(2, words.get(i).getWordLang1());
				insert.setString(3, words.get(i).getWordLang2());
				insert.setString(4, words.get(i).getExamplePhrase());
				insert.addBatch();
				
				if(i % BATCH_SIZE == 0) {
					insert.executeBatch();
				}
			}
			
			insert.executeBatch();
			
			insert.close();
			conn.close();
			
			System.out.println("Records Inserted to Table: " + VocabularyEntry.TABLE_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// TODO delete this
	public static void main(String[] args) { 
		//dropVocabularyTable();
		//createVocabularyTable();
		
		insertVocabularyFile(Constants.WORD_LIST, "main_voc");
	}
}
