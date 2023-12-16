package controller;

import base.BasePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Controller extends BasePage {

    public void openPage() throws IOException {
        driver.get(util.ConfigReader.getProperty("url"));
    }

    public void selectBetLogic(List<WebElement> elements) {
        int count = 0;
        for (WebElement element : elements) {
            if (count % 3 == 0) {
                System.out.println(element.getText());
                waitUntilElementClickable(element).click();
            }
            count++;

            // Break the loop after three clicks
            if (count / 3 == 3) {
                break;
            }
        }
    }

    public void selectBetCardLogic(List<WebElement> elements) {
        WebElement secondElement = elements.get(0);
        secondElement.click();
    }
}
