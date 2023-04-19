package balbucio.integradati.search;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import balbucio.sqliteapi.SQLiteInstance;
import balbucio.sqliteapi.SqliteConfig;

public class SearchEngine {

	private static SearchEngine instance;
	private SQLiteInstance sqlite;

	public SearchEngine() {
		SqliteConfig config = new SqliteConfig(new File("database.db"));
		config.createFile();
		sqlite = new SQLiteInstance(config);
		sqlite.createTable("acontecimentos", "seculo INT, description VARCHAR(MAX), name VARCHAR(255)");

	}

	/**
	* Adiciona um novo acontecimento
	**/
	public void addAcontecimento(String name, int seculo, String description) {
		sqlite.insert("seculo, description, name", "'"+seculo+"', '"+description+"', '"+name+"'", "acontecimentos");
	}

	/**
	* Pega todos os acontecimentos
	**/
	public List<Object[]> getAcontecimentos(){
		return sqlite.getAllValuesFromColumns("acontecimentos", "seculo, description, name");
	}
}
