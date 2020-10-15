package surya.learning.Jenkins.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import surya.learning.Jenkins.properties.Environment;

public class HomePage extends AbstractPage<HomePage> {

    @FindBy(className = "h000-mktg")
    private WebElement slogan;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the Github homepage")
    @Override
    protected void load() {
        driver.get(Environment.getProperties().url());
    }

    @Override
    protected void isLoaded() throws Error {
        assertThat(driver.getTitle()).isEqualTo("GitHub: Where the world builds software · GitHub");
    }

    @SuppressWarnings("deprecation")
	@Step("Get slogan text")
    public String getSloganText() {
    	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(slogan));
        return slogan.getText();
    }


}
