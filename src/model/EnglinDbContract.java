package model;

public class EnglinDbContract {
	// Each vocabulary must create a table of this type
	public static class VocabularyEntry {
		public static final String COLUMN_LANGUAGE_1 = "language_1";
		public static final String COLUMN_LANGUAGE_2 = "language_2";
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_EXAMPLE_PHRASE = "example_phrase";
	}
	
	// Table with metadata about all vocabularies tables created
	public static class MetaDataEntry {
		public static final String TABLE_NAME = "metadata";	// this will be the primary key of this table
		public static final String COLUMN_TABLES = "tables";
		public static final String COLUMN_HAS_EXAMPLE_PHRASE = "has_example_phrase";
		public static final String COLUMN_HAS_LETTERS_TIPS = "has_letters_tips";
	}
}



