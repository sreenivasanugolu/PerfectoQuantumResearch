package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MayoHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {
    PropertyUtil props = ConfigurationManager.getBundle();

    @Override
    protected void openPage(PageLocator locator, Object... args) {

    }

    @FindBy(locator = "homepage.header.logo")
    private QAFExtendedWebElement headerLogo;
    @FindBy(locator = "homepage.learnMoreAboutMayoClinic.link")
    private QAFExtendedWebElement learnMoreAboutMayoClinic;
    @FindBy(locator = "homepage.moreExperience.link")
    private QAFExtendedWebElement moreExperience;

    public void verifyPageTitle(String pageTitle) {
        String expectedTitle = pageTitle;
        Assert.assertEquals(new WebDriverTestBase().getDriver().getTitle(),
                expectedTitle);
    }

    public void clickOnHeaderLogo(String link) {
        goToPage(link);
    }

    private enum PageName{
        LEARN_MORE_ABOUT("Learn_more_about_mayo_clinic" , "learnMoreAboutMayoClinic"),
        HEADER_LOGO("Header_Logo" , "headerLogo");
        private  final String featureFileValue;
        private  final String xPathValue;
        private static Map<String,PageName> temp = new HashMap<>();

        static {
            for(PageName p : values()){
                temp.put(p.getFeatureFileValue(),p);
            }
        }
        static PageName getPageNameOnFeatureFileValue(String name){
            return temp.get(name);
        }

        PageName(String featureFileValue, String xPathValue) {
            this.featureFileValue = featureFileValue;
            this.xPathValue = xPathValue;
        }

        public String getFeatureFileValue() {
            return featureFileValue;
        }

        public String getxPathValue() {
            return xPathValue;
        }
    }

    public void goToPage(String featureFileValue) {

        PageName page = PageName.getPageNameOnFeatureFileValue(featureFileValue);
        if (page != null){
            QAFExtendedWebElement pageLinkElement = null;
            switch (page){
                case LEARN_MORE_ABOUT:
                    pageLinkElement = learnMoreAboutMayoClinic;
                    break;
                case HEADER_LOGO:
                    pageLinkElement = headerLogo;
            }
            if (pageLinkElement != null)
                pageLinkElement.click();

        }

    }
}

