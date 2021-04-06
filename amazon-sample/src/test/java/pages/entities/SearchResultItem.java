package pages.entities;

import java.util.Objects;

public class SearchResultItem {
    private final String title;
    private final String href;

    public SearchResultItem(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public String getHrefValue() {
        return href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResultItem that = (SearchResultItem) o;
        return Objects.equals(title, that.title) && Objects.equals(href, that.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, href);
    }

    @Override
    public String toString() { //not to see unreadable Object if test fail
        return "SearchResultItem{" +
                "title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }

}
