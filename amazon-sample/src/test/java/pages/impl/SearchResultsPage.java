package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPage;
import pages.components.impl.SearchResultComponent;
import pages.entities.SearchResultItem;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {
    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector("[data-component-type='s-search-results']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchResultItem> searchResultsItems() {
        return searchResultItems().stream()
                .map(SearchResultComponent::convertToSearchResultItem)
                .collect(Collectors.toList());
    }

    public List<SearchResultItem> searchResultsItemsWithText(String searchPhrase) {
        return searchResultsItems().stream()
                .filter(element -> element.getTitle().contains(searchPhrase) || element.getHrefValue().contains(searchPhrase))
                .collect(Collectors.toList());
    }

    private List<SearchResultComponent> searchResultItems() {
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultComponent::new)
                .collect(Collectors.toList());
    }

}
