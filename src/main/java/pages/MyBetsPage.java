package pages;

import controller.Controller;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyBetsPage extends Controller {
    private void clickMyBetsButton(){
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("myBetsButton")).click();
    }
    public List<WebElement> getBetCard() {
        return waitForVisibilityOfElementsByCssSelector(util.LocatorReader.getLocator("betCard"));
    }
    public void myBets(){
        clickMyBetsButton();
        selectBetCardLogic(getBetCard());
    }
}
