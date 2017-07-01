package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkan on 29.06.17.
 */
public class SearchResult {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")         private List<SearchResult> searchResults = new ArrayList<>();

    @SerializedName("id")           private int id;
    @SerializedName("aliases")      private List<String> aliases;
    @SerializedName("seriesName")   private String seriesName;
    @SerializedName("banner")       private String banner;
    @SerializedName("firstAired")   private String firstAired;
    @SerializedName("network")      private String network;
    @SerializedName("status")       private String status;
    @SerializedName("overview")     private String description;


    public String toString() {
        return  getId()          + "\n" +
                getAliases()     + "\n" +
                getSeriesName()  + "\n" +
                getBanner()      + "\n" +
                getFirstAired()  + "\n" +
                getNetwork()     + "\n" +
                getStatus()      + "\n";
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getBanner() {
        return IMAGE_BASE_URL + banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
