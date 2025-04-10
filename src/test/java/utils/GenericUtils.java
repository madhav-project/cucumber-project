package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void switchWindowToChild() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
	}

}
