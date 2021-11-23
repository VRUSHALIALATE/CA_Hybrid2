package com.mindtree.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponent.WebDriverHelper;

public class TakeSS {

	static WebDriver driver=null;
	public static String getScreenShot(String filename) {
		
	     driver =	WebDriverHelper.getDriver();
		
	     System.out.println(driver);
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = f.format(new Date());
		String path = ".//screenShots//" + filename+" "+date+ ".png";
		File des = new File(path);

		try {
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	 }
}
