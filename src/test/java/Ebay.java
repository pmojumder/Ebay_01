
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
/*WebElement bg=		driver.findElement(By.cssSelector("input#gh-btn"));

String str=bg.getCssValue("background-color");
System.out.println(str);
		
		
	bg	.click();*/
driver.findElement(By.cssSelector("div.vl-image.vl-image-js.js-only.vl-popular-destinations-evo__image.vl-image__fill"))
.click();

/*
 * String browser="chrome";
 * WebDriver driver=null;
 * switch(browser)
 * {
 * case "firefox":
 * 		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\chromedriver.exe");
         driver=new FirefoxDriver();
         
 * 
 * case "chrome":
 * 
 * System.setProperty("webdriver.chrome.driver", "C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\chromedriver.exe");

		driver=new ChromeDriver();
 * case "edge":
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 */
}

}
