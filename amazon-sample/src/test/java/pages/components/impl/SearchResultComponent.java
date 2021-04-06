package pages.components.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.components.WebComponent;
import pages.entities.SearchResultItem;

public class SearchResultComponent extends WebComponent {
    private static final By TITLE_SELECTOR = By.cssSelector("h2 .a-link-normal");

    public SearchResultComponent(WebElement element) {
        super(element);
    }

    public SearchResultItem convertToSearchResultItem() {
        return new SearchResultItem(
                retrieveTitle(),
                retrieveHref()
        );
    }

    private String retrieveHref() {
        return findElement(TITLE_SELECTOR).getText().toLowerCase();
    }

    private String retrieveTitle() {
        return findElement(TITLE_SELECTOR).getAttribute("href");
    }

    public boolean containsSearchPhrase(String searchPhrase) {
        return containsText(findElement(TITLE_SELECTOR).getText(), searchPhrase)
                || containsText(findElement(TITLE_SELECTOR).getAttribute("href"), searchPhrase);
    }

    private boolean containsText(String text, String searchPhrase) {
        return text.toLowerCase().contains(searchPhrase);
    }

}
