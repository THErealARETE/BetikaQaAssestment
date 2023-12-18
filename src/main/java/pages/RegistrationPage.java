package pages;

import controller.Controller;
import util.PhoneNumberManager;

import java.io.IOException;


public class RegistrationPage extends Controller {

    PhoneNumberManager phoneNumberManager = new PhoneNumberManager();

        private void clickNavigateRegisterButton() {
            waitForVisibilityOfElementByLinkText(util.LocatorReader.getLocator("navigateToRegister")).click();
        }

        private void setPhoneNumber(String phoneNumber) {
            waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("phoneNumberField")).sendKeys(phoneNumber);
        }

        private void setPassword(String password) {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("registerPassword")).sendKeys(password);
        }

        private void setConfirmPassword(String password) {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("registerConfirmPassword")).sendKeys(password);
        }

        private void clickCheckBox() {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("checkBox")).click();
        }

        private void clickRegisterButton() {
            waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("registerButton")).click();
        }

        public void registration( String password) throws IOException {
            long newPhoneNumber = phoneNumberManager.incrementAndUpdate();
            String phoneNumberString = String.valueOf(newPhoneNumber);
            openPage();
            clickNavigateRegisterButton();
            setPhoneNumber(phoneNumberString);
            setPassword(password);
            setConfirmPassword(password);
            clickCheckBox();
            clickRegisterButton();
        }
}


