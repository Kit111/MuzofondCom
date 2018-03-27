package org.itstep;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ProgramRunnerTest {

	@Test
	public void testRunSongsListForSize() {
		SongFinder songfinder = new SongFinder();
		ArrayList<Song> songs = songfinder.getSongsList();
		String filePath = "D:\\music\\songs.txt";
		 
	}
}