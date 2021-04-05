package pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends WebPage {

    @FindBy(css = ".repo-list-item")
    private List<WebElement> searchResultsItems;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItems() {
        return searchResultsItems.stream()
                .map((element) -> element.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchPhrase) {
        return searchResultsItems().stream()
                .filter(item -> item.contains(searchPhrase))
                .collect(Collectors.toList());
    }

}
