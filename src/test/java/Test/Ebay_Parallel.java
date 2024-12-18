package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ebay_Parallel {
	WebDriver driver=null;
	@BeforeMethod
	@Parameters("browser")
	public void ebay(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
				{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\chromedriver.exe");

		 driver=new ChromeDriver();
				}else if(browser.equalsIgnoreCase("default"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Plabani\\eclipse-workspace\\OrangeHRM_2111\\src\\test\\resources\\chromedriver.exe");

					 driver=new ChromeDriver();
				}
	}
		@Test
		public void test()
		{
			driver.get("https://www.ebay.com/");

		}

/*WebElement bg=		driver.findElement(By.cssSelector("input#gh-btn"));

String str=bg.getCssValue("background-color");
System.out.println(str);
		
		
/*	bg	.click();
driver.findElement(By.cssSelector("div.vl-image.vl-image-js.js-only.vl-popular-destinations-evo__image.vl-image__fill"))
.click();*/

	}


