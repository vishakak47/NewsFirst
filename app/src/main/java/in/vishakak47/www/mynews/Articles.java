package in.vishakak47.www.mynews;

public class Articles {
    String title,imageUrl,link;

    public Articles(String title, String imageUrl,String link) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.link=link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Articles() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
