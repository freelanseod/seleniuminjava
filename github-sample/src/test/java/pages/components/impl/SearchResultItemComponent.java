package pages.components.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.components.WebComponent;
import pages.entities.SearchResultItem;

public class SearchResultItemComponent extends WebComponent {
    private static final By TITLE_SELECTOR = By.cssSelector(".v-align-middle");
    private static final By DESCRIPTION_SELECTOR = By.cssSelector(".mb-1");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public SearchResultItem convertToSearchResultItem() {
        return new SearchResultItem(
                retrieveTitle(),
                retrieveDescription()
        );
    }

    private String retrieveTitle() {
        return findElement(TITLE_SELECTOR).getText().toLowerCase();
    }

    private String retrieveDescription() {
        return findElement(DESCRIPTION_SELECTOR).getText().toLowerCase();
    }

}
