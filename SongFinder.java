package org.itstep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SongFinder {

	Thread thread = new Thread();
	
	public ArrayList<Song> getSongsList() {
		ArrayList<Song> songList = new ArrayList<Song>();
		System.setProperty("webdriver.chrome.driver", "C:\\java\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
				thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		driver.get("https://muzofond.com");
		try {
			thread.sleep(3000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		WebElement songsUlList = driver.findElement(By.className("module-layout"));
		List<WebElement> songsLiElements = songsUlList.findElements(By.className("item "));
		int sizeList = (int) (15 + (Math.random() * (20 - 15)));
		if (songsLiElements.size() < sizeList) {
				sizeList = songsLiElements.size();
		}
		for (int i = 0; i < sizeList; i++) {
				Song song = new Song();
				List <WebElement> divElements = songsLiElements.get(i).findElements(By.tagName("div"));
				WebElement description = divElements.get(2);
				song.name = description.getText();
				song.filePath = "D:\\music\\" + song.name + ".mp3";
				songList.add(song);
		}
		driver.quit();
		return songList;
	}
}