package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Config {

	public static final String CONFIG_FILE_PATH = "config.json";
	public static Config instance = null;
	
	private Config() {
		hashtags = new HashMap<String, List<String>>();
	}
	
	public static Config getInstance() {
		if(instance==null) {
			try {
				instance = loadInstance(CONFIG_FILE_PATH);
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				instance = new Config();
			}
		}
		return instance;
	}
	
	private static Config loadInstance(String path) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Config config = gson.fromJson(br, Config.class);
		return config;
	}

	private HashMap<String, List<String>> hashtags = null;

	public HashMap<String, List<String>> getHashtags() {
		return hashtags;
	}
	
	public void save() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(CONFIG_FILE_PATH);
		pw.write(toString());
		pw.close();
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public void clear() {
		hashtags = new HashMap<String, List<String>>();
		
	}
	
	
}
