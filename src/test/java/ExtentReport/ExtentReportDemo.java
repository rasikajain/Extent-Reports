package ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Extent Reports is an open-source HTML reporting library useful for test automation.

//The ExtentReports report client for starting reporters and building reports. 
//For most applications, you should have one ExtentReports instance for the entire JVM.
//ExtentReports itself does not build any reports, but allows reporters to access information, 
//which in turn build the said reports.
public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		//ExtentReports, ExtentSparkReporter
		//The ExtentSparkReporter creates a rich standalone spark file.
		//It allows several configuration options via the config() method.

		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rasika Jain");
	}

	@Test
	public void initialDemo() {
		
//ExtentTest Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
//Tests started with the createTest method are parent-level, always level 0
//Tests started with the createNode method are children, always level 1 and greater
		
		ExtentTest test = extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rasik\\Downloads\\BroswerDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
		System.out.println("Page Title = " + driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		extent.flush();
		//It is mandatory to call the flush method to ensure information is written to the started reporters.

		
	}

}
