package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPage;
import pages.components.WebComponent;
import pages.components.impl.SearchResultComponent;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {
    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector("[data-component-type='s-search-results']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItems() {
        return searchResultComponents().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchPhrase) {
        return searchResultComponents().stream()
                .filter(element -> element.containsSearchPhrase(searchPhrase))
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultComponent> searchResultComponents() {
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultComponent::new)
                .collect(Collectors.toList());
    }

}
