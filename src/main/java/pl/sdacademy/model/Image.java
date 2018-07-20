package pl.sdacademy.model;

public class Image {

    private String urlAddress;
    private String description;

    public Image(String urlAddress, String description) {
        this.urlAddress = urlAddress;
        this.description = description;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
