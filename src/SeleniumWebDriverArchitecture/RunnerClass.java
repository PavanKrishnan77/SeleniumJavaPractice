package SeleniumWebDriverArchitecture;

public class RunnerClass 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("www.facebook.com");
		driver.findElement("By.className");
		driver.getWindowHandle("29djdkjkdjkfjd");
		driver.switchTo();
		driver.close();
		driver.quit();
	}
}
