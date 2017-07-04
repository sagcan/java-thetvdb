package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * This class will be used for a GSON de-serialization (a.k.a POJO class).
 *
 * @see <a href="https://api.thetvdb.com/swagger#!/Search/get_search_series">For a better description</a>
 */
public class SearchResult {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")         private List<SearchResult> searchResults = new ArrayList<>();

    @SerializedName("id")           private int seriesId;
    @SerializedName("aliases")      private List<String> seriesAliases;
    @SerializedName("seriesName")   private String seriesName;
    @SerializedName("banner")       private String seriesBannerUrl;
    @SerializedName("firstAired")   private String seriesFirstAired;
    @SerializedName("network")      private String seriesNetwork;
    @SerializedName("status")       private String seriesStatus;
    @SerializedName("overview")     private String seriesDescription;

    @Override
    public String toString() {
        return "\nSearchResult{"          +
                "seriesId="             + seriesId          +
                ", seriesAliases="      + seriesAliases     +
                ", seriesName='"        + seriesName        + '\'' +
                ", seriesBannerUrl='"   + seriesBannerUrl   + '\'' +
                ", seriesFirstAired='"  + seriesFirstAired  + '\'' +
                ", seriesNetwork='"     + seriesNetwork     + '\'' +
                ", seriesStatus='"      + seriesStatus      + '\'' +
                ", seriesDescription='" + seriesDescription + '\'' +
                '}';
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public List<String> getSeriesAliases() {
        return seriesAliases;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesBannerUrl() {
        return IMAGE_BASE_URL + seriesBannerUrl;
    }

    public String getSeriesFirstAired() {
        return seriesFirstAired;
    }

    public String getSeriesNetwork() {
        return seriesNetwork;
    }

    public String getSeriesStatus() {
        return seriesStatus;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }
}
