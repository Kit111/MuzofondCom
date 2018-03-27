package org.itstep;++++

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class SongFinderTest {

	@Test
	public void testGetSongsListForSize() {
			SongFinder songFinder = new SongFinder();
			ArrayList<Song> songs = songFinder.getSongsList();
			boolean sizeCorrect = songs.size()>=15 && songs.size()<=20;
			assertTrue(sizeCorrect);
	}

	@Test
	public void testGetSongsListForCorrectElement() {
			SongFinder songFinder = new SongFinder();
			ArrayList<Song> songs = songFinder.getSongsList();
			boolean elementIsPresent = false;
			for(Song song: songs){
					if(song.filePath.contains("Shape Of You.mp3")){
							elementIsPresent = true;
					}
			}
			assertTrue(elementIsPresent);
	}
	
}