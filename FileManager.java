package org.itstep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public void writeInfoToFile(String filePath, ArrayList<Song> songs) {
		String infotext = "";
		for (Song song : songs) {
			infotext += song.name + " ----- " + song.filePath + "\n";
		}
		Thread thread = new Thread();
		try {
						thread.sleep(3000);
				} catch (InterruptedException e1) {
						e1.printStackTrace();
				}
		try {	
			FileWriter filewriter = new FileWriter(filePath);
			filewriter.write(infotext);
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readInfoFromFile(String filePath) {
		String infotext = "";
		String outText = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((outText = reader.readLine()) != null) {
				infotext += outText + "\n";
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infotext;
	}

	public String readMixedInfoFromFile(String filePath) {
		ArrayList<String> songs = new ArrayList<>();
		String outText = "";
		String infotext = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((outText = reader.readLine()) != null) {
				songs.add(outText);
			}
			while (!songs.isEmpty()){
				int index = (int)(Math.random()*songs.size());
				infotext += songs.get(index) + "\n";
				songs.remove(index);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infotext;
	}
	
}