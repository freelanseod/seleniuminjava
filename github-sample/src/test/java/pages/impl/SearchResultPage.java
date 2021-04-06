package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPage;
import pages.components.impl.SearchResultItemComponent;
import pages.entities.SearchResultItem;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends WebPage {
    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector(".repo-list-item");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchResultItem> searchResultsItems() {
        return searchResultItems().stream()
                .map(SearchResultItemComponent::convertToSearchResultItem)
                .collect(Collectors.toList());
    }

    public List<SearchResultItem> searchResultsItemsWithText(String searchPhrase) {
        return searchResultsItems().stream()
                .filter(item -> item.getTitle().contains(searchPhrase) || item.getDescription().contains(searchPhrase))
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultItems() {
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }

}
