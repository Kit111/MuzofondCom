package org.itstep;

import java.io.File;
import java.util.ArrayList;



public class ProgramRunner {
		public static void main(String[] args) {

        SongFinder songfinder = new SongFinder();
        ArrayList<Song> songs = songfinder.getSongsList();

        String filePath = "D:\\music\\songs.txt";
        File file = new File(filePath);
        FileManager filemanager = new FileManager();
        filemanager.writeInfoToFile(filePath, songs);
    
        Thread thread = new Thread();
		try {
				thread.sleep(5000);
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		String fileInfo = filemanager.readInfoFromFile(filePath);
		System.out.println(fileInfo);
		
		String mixedFileInfo = filemanager.readMixedInfoFromFile(filePath);
		System.out.println(mixedFileInfo);
	}
}