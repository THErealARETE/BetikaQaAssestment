package pages;

import controller.Controller;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class BetPlacementPage extends Controller {
    private void clickShareButton(){
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("shareButton")).click();
    }

    private void clickCopyLinkButton(){
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("copyLinkButton")).click();
    }

    private void clickCancelButton(){
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("cancelButton")).click();
    }

    private void clickPlaceBetButton(){
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("placeBetButton")).click();
    }

    public List<WebElement> getBetEvent() {
        return waitForVisibilityOfElementsByCssSelector(util.LocatorReader.getLocator("betEvent"));
    }

    public WebElement getCopiedLinkText() {
        return waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("copiedLink"));
    }
    private WebElement typeAmount(){
        return waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("amount"));
    }


    public void cleanBetPlacement() throws IOException, InterruptedException {
        selectBetLogic(getBetEvent());
        clickShareButton();
        clickCopyLinkButton();
        getCopiedLinkText().getText();
        clickCancelButton();
        typeAmount().clear();
        typeAmount().clear();
        typeAmount().sendKeys("5");
        clickPlaceBetButton();

    }
}
