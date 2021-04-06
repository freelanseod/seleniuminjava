package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPage;
import pages.components.WebComponent;
import pages.components.impl.SearchResultItemComponent;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends WebPage {
    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector(".repo-list-item");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItemsText() {
        return searchResultItems().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchPhrase) {
        return searchResultItems().stream()
                .filter(item -> item.containsSearchPhrase(searchPhrase))
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultItems() {
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }

}
