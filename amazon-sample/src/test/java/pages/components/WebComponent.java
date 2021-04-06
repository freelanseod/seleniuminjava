package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebComponent { //It is a wrapper for selenium webElement item for encapsulation logic
    private WebElement element;

    protected WebComponent(WebElement element) {
        this.element = element;
    }

    protected WebElement findElement(By bySelector) {
        return element.findElement(bySelector);
    }

    protected void sendKeys(CharSequence... keyboard) {
        element.sendKeys(keyboard);
    }

    public String getText() {
        return element.getText();
    }

}
