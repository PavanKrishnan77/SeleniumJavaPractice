package SeleniumWebDriverArchitecture;

public class ChromeDriver implements WebDriver
{
	@Override
	public void get(String url)
	{
		System.out.println("Enter the Url : " +url);
	}

	@Override
	public void getWindowHandle(String windowhandle)
	{
		System.out.println("Enter the Window Handle Address : " +windowhandle);
	}

	@Override
	public void findElement(String locator) 
	{
		System.out.println("Enter the Locator Value : " +locator);
	}

	@Override
	public void switchTo() 
	{
		System.out.println("Switched to Frame");
	}

	@Override
	public void close()
	{
		System.out.println("Browser Closed");
	}

	@Override
	public void quit()
	{
		System.out.println("Session Closed");
	}
}
