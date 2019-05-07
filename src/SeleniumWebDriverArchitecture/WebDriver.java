package SeleniumWebDriverArchitecture;

public interface WebDriver 
{
	public void get(String url);
	public void getWindowHandle(String windowhandle);
	public void findElement(String locator);
	public void switchTo();
	public void close();
	public void quit();
}
