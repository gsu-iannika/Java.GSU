package by.gsu.pms;

public class Item {
    private String title;
    private String link;
    private String description;
    private String category;
    private String domain;
    private String enclosure;
    private String url;
    private String guid;
    private String isPermaLink;
    private String pubDate;

    public Item() {
        this.title = title;
        this.link = link;
        this.description = description;
        this.category = category;
        this.domain = domain;
        this.enclosure = enclosure;
        this.url = url;
        this.guid = guid;
        this.isPermaLink = isPermaLink;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getIsPermaLink() {
        return isPermaLink;
    }

    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\n' +
                "link='" + link + '\n' +
                "description='" + description + '\n' +
                "category='" + category + '\n' +
                "domain='" + domain + '\n' +
                "enclosure='" + enclosure + '\n' +
                "url='" + url + '\n' +
                "guid='" + guid + '\n' +
                "isPermaLink='" + isPermaLink + '\n' +
                "pubDate='" + pubDate + '\n' +
                '}';
    }
}
