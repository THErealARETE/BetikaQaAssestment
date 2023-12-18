package pages;

import controller.Controller;

public class LogOutPage extends Controller {

    private void clickTopNavBar() {
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("topNavBar")).click();
    }

    private void clickLogOutButton() {
        waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("logOutButton")).click();
    }

    public void cleanLogOut()  {
        clickTopNavBar();
        clickLogOutButton();
    }
}