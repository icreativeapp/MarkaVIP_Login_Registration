package test;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.net.URL;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

/**
 *
 * @author Rami Saleem
 */
@Listeners({SauceOnDemandTestListener.class})
public class LoginFromCampaignPageUsingFacebook implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

    public SauceOnDemandAuthentication authentication;

    private WebDriver driver;

    /**
     * If the tests can rely on the username/key to be supplied by environment variables or the existence
     * of a ~/.sauce-ondemand file, then we don't need to specify them as parameters, just create a new instance
     * of {@link SauceOnDemandAuthentication} using the no-arg constructor.
     * @param username
     * @param key
     * @param os
     * @param browser
     * @param browserVersion
     * @param method
     * @throws Exception
     */

@Parameters({"username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("icreativeapp") String username,
                      @Optional("8e40a4f9-07bd-4bdb-88f2-806eb88c63ab") String key,
                      @Optional("XP") String os,
                      @Optional("opera") String browser,
                      @Optional("11") String browserVersion,
                      Method method) throws Exception {

        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(key)) {
           authentication = new SauceOnDemandAuthentication(username, key);
        } else {
           authentication = new SauceOnDemandAuthentication();
        }

 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
        desiredCapabilities.setVersion(System.getenv("SELENIUM_VERSION"));
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        this.driver = new RemoteWebDriver(
                new URL("http://icreativeapp:8e40a4f9-07bd-4bdb-88f2-806eb88c63ab@ondemand.saucelabs.com:80/wd/hub"),
                desiredCapabilities);
    }



    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getSessionId() {
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        return (sessionId == null) ? null : sessionId.toString();
    }

    @Test
    public void Login_From_Campaign_Page_Using_Facebook() throws Exception {



	
	WebDriverWait wait=new WebDriverWait(driver, 101);
	
driver.get("https://www.facebook.com/login.php?api_key=246052772130187&skip_api_login=1&display=popup&cancel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D18%23cb%3Df7a8e1e8%26origin%3Dhttp%253A%252F%252Fmarkavip.com%252Ffbd68c72c%26domain%3Dmarkavip.com%26relation%3Dopener%26frame%3Df3187a109c%26error_reason%3Duser_denied%26error%3Daccess_denied%26error_description%3DThe%2Buser%2Bdenied%2Byour%2Brequest.&fbconnect=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fpermissions.request%3F_path%3Dpermissions.request%26app_id%3D246052772130187%26client_id%3D246052772130187%26redirect_uri%3Dhttp%253A%252F%252Fstatic.ak.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D18%2523cb%253Df7a8e1e8%2526origin%253Dhttp%25253A%25252F%25252Fmarkavip.com%25252Ffbd68c72c%2526domain%253Dmarkavip.com%2526relation%253Dopener%2526frame%253Df3187a109c%26sdk%3Djoey%26display%3Dpopup%26response_type%3Dtoken%252Csigned_request%26domain%3Dmarkavip.com%26perms%3Demail%26fbconnect%3D1%26from_login%3D1&rcount=1");
	
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("ramisaleem17@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Rami2017");
		driver.findElement(By.id("persist_box")).click();
		driver.findElement(By.id("u_0_1")).click();
		
	driver.get("http://markavip.com");
driver.findElement(By.cssSelector("a.do_modal")).click();
 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.clearfix.fb-login-link")));
	        driver.findElement(By.cssSelector("a.clearfix.fb-login-link")).click();


/*

		//Back to MarkaVIP page
		
		driver.switchTo().window(markavipwindow);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_link")));
                driver.findElement(By.id("username_link")).getText();
		String name2="Rami Saleem";
		Assert.assertEquals(driver.findElement(By.id("username_link")).getText(), name2);

*/
		


wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_link")));
                driver.findElement(By.id("username_link")).getText();
		String name2="Rami Saleem";
		Assert.assertEquals(driver.findElement(By.id("username_link")).getText(), name2);

}	


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }
}
