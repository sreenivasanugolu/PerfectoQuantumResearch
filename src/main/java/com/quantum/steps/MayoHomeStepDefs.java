package com.quantum.steps;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.pages.MayoHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@QAFTestStepProvider
public class MayoHomeStepDefs {
    MayoHomePage mayoHomePage = new MayoHomePage();

    @Given("^The user is on mayo clinic home page$")
    public void user_is_on_mayo_clinic_home_page() throws Throwable {
        String baseURL = ConfigurationManager.getBundle().getPropertyValue("env.baseurl");
        System.out.println("Base URL " + baseURL);
        new WebDriverTestBase().getDriver().get(baseURL);

        String expectedTitle = "Mayo Clinic - Mayo Clinic";
        Assert.assertEquals(new WebDriverTestBase().getDriver().getTitle(),
                expectedTitle);
    }

    @Given("^The user verifies the title of home page$")
    public void user_verifies_title_of_home_page() throws Throwable {
        String expectedTitle = "Mayo Clinic - Mayo Clinic";
        Assert.assertEquals(new WebDriverTestBase().getDriver().getTitle(),
                expectedTitle);
    }

    @And("^user navigates to the page \"([^\"]*)\"$")
    public void user_navigates_to_page(String pageName) throws Throwable {
      mayoHomePage.goToPage(pageName);
    }


    @Then("^verifies the title \"([^\"]*)\"$")
    public void verifies_page_title(String pageTitle) {
        mayoHomePage.verifyPageTitle(pageTitle);
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClicksOnHeaderLogo(String link) {
        mayoHomePage.clickOnHeaderLogo(link);
    }
}
