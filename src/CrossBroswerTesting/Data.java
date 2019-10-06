/*package CrossBroswerTesting;

public class Data 
{
	Difference Between ImplicitWait and ExplicitWait in Selenium:

	Implicit wait is a global wait and is dynamic in nature. 
	WebDriverWait is nothing but explicit wait because we don’t have any method to define wait time in explicit wait as like in implicit wait. 

	Implicit wait cannot be customised since we define time after launching the browser and it will be applied to all defined webelements. 
	Explicit wait can be customised. 

	Implicit wait can be applied only and only for findElement(s) where as ExplicitWait can be applied for findElement(s) as well as for other actions. 

	In implicit wait, If element is not found within given time then we get no such element expection 
		In explicit wait, if element is not found within given time then we get TimeOut execution. 
		Explicit wait uses polling period where in it checks whether element is present in HTML DOM or no for every 500 milli seconds.

		Implicit wait runs in browser side and explicit wait runs in local side that’s in selenium code side..!!

		Page Object Model and PageFactory:

			Page Object Model is a Design Pattern in Selenium, we can see it as repository where we store all WebElements. 

			Page Object Model became very famous in industry these days as it is very easy to maintain, code reusability and also it reduces code duplication. 

			In Selenium, we use POM Design Pattern with the help of PageFactory API of Selenium WebDriver..!!

			POM Design Pattern can be used only and only for UI Web Applications..!!

			Advantage:
			If UI changes in future then we can update the WebElements accordingly at Page Classes in POM or Object Repository..!!


			PageFactory:
			PageFactory is an inbuilt concept or API in Selenium WebDriver. 

			Here we again follow the same concept of keeping object repository or page classes separate from test classes. 
			Here, we use @FindBy to find elements and we use initElements method to initialise WebElements. 

			@FindBy works with all locators available in selenium to find elements..!!
			
			Difference between @FindBy and FindElement(s) in Selenium:

				@FindBy is an annotation that is provided by Selenium not by TestNG while findElement/s are methods. 

				@FindBy is used to support POM design pattern through Page Factory While findElement/s are normal way locating WebElements in HTML DOM. 

				@FindBy helps to handle StaleElementReference Exception where as findElement/s not. 

				If we don’t initialise defined WebElements Using PageFactory then @FindBy will throw NullPointer Exception which is not the case with findElement/s methods.

				Sharing a thought on @FindBy and PageFactory which we generally use in designing framework in Selenium with the help of Page Object Model Design Pattern. 

				@FindBy:
				When we design any framework with the help of TestNG, we sometimes assume that @FindBy is getting imported from TestNG which is absolutely NOT. 
				@FindBy is an annotation that is available in Selenium. 
				When we import @FindBy we can notice on the top of Script that it’s coming from Selenium. 

				“import org.openqa.selenium.support.FindBy”


				PageFactory:
				Since we use PageFactory with POM Design Pattern, we think that PageFactory is a part of POM Design Pattern which is absolutely NOT. 
				PageFactory is an inbuilt Concept or API that’s available in Selenium WebDriver that’s is used to Support POM Design Pattern. 
				In PageFactory we use @FindBy to define WebElements and initElements() to initialise WebElements that are defined using @FindBy. 
				WebElements that are defined using @FindBy they must be initialised, if not @FindBy will throw NullPointerException. 

				“import org.openqa.selenium.support.PageFactory;”			
}
*/