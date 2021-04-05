package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage {

    @FindBy(css = ".repo-list-item")
    private List<WebElement> searchResultsItems;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
