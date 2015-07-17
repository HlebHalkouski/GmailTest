package webdriver.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import webdriver.Logger;

public class RobotForAttachFile {

	private static Robot robot;
	
	public static void attachFile(File attachFile) {
		try {
			StringSelection  pathToFile = new StringSelection(attachFile.getAbsolutePath());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pathToFile, null);
			robot = new Robot();
			Logger.getInstance().info("Uploading file: " + attachFile.getAbsolutePath());
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			Logger.getInstance().fatal(e.toString());
		}
	}

}
