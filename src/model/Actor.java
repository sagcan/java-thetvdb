package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")          private List<Actor> actors = new ArrayList<>();

    @SerializedName("id")            private int id;
    @SerializedName("imageAuthor") private int imageAuthorId;
    @SerializedName("seriesId")      private int seriesId;
    @SerializedName("sortOrder")     private int sortOrder;
    @SerializedName("image")         private String imageUrl;
    @SerializedName("imageAdded")    private String imageAdded;
    @SerializedName("lastUpdated")   private String lastUpdated;
    @SerializedName("name")          private String name;
    @SerializedName("role")          private String role;

    public String toString() {
        return  getId()             + "\n" +
                getImageAuthorId()  + "\n" +
                getSeriesId()       + "\n" +
                getSortOrder()      + "\n" +
                getImageUrl()       + "\n" +
                getImageAdded()     + "\n" +
                getLastUpdated()    + "\n" +
                getName()           + "\n" +
                getRole()           + "\n";
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageAuthorId() {
        return imageAuthorId;
    }

    public void setImageAuthorId(int imageAuthorId) {
        this.imageAuthorId = imageAuthorId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getImageUrl() {
        return IMAGE_BASE_URL + imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAdded() {
        return imageAdded;
    }

    public void setImageAdded(String imageAdded) {
        this.imageAdded = imageAdded;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
