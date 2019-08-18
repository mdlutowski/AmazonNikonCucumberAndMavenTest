package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonPage extends BasePage {
	
	public void launchBrowser(String browser, String pathToBrowser) throws Exception {
		if(browser.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pathToBrowser + "\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pathToBrowser + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception(String.format("Browser %s not supported.", browser));
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	public void goToAmazonPage(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public void searchProduct(String product) {
		WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
		searchText.sendKeys(product);
		searchText.sendKeys(Keys.ENTER);
	}
	
	public void sortByFilter(String filter) {
		Select sortBy = new Select(driver.findElement(By.id("s-result-sort-select")));
        sortBy.selectByVisibleText(filter);
	}
	
	public void chooseModelPosition(int elementNo) {
		int indexNo = elementNo - 1;
		WebElement product = driver.findElement(By.cssSelector("[data-image-index='" + indexNo + "']"));
		product.click();
	}
	
	public String getProductTopic() {
		WebElement titleText = driver.findElement(By.id("productTitle"));
		return    titleText.getText();
	}
	
	public boolean verifyIfTopicContainsModel(String model) {
		if (getProductTopic().contains(model)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void closeDriver() {
		driver.quit();
	}
}