package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * This class will be used for a GSON de-serialization (a.k.a POJO class).
 *
 * @see <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id">For a better description</a>
 */
public class Series {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")             private Series series;

    @SerializedName("id")               private int seriesId;
    @SerializedName("lastUpdated")      private int seriesLastUpdated;

    @SerializedName("added")            private String seriesAdded;
    @SerializedName("airsDayOfWeek")    private String seriesAirsDayOfWeek;
    @SerializedName("airsTime")         private String seriesAirsTime;
    @SerializedName("banner")           private String seriesBannerUrl;
    @SerializedName("firstAired")       private String seriesFirstAired;
    @SerializedName("network")          private String seriesNetwork;
    @SerializedName("networkId")        private String seriesNetworkId;
    @SerializedName("overview")         private String seriesDescription;
    @SerializedName("rating")           private String seriesRating;
    @SerializedName("runtime")          private String seriesRuntime;
    @SerializedName("seriesName")       private String seriesName;
    @SerializedName("status")           private String seriesStatus;

    @SerializedName("aliases")          private List<String> seriesAliases;
    @SerializedName("genre")            private List<String> seriesGenre;

    @SerializedName("siteRating")       private double siteRating;
    @SerializedName("siteRatingCount")  private int siteRatingCount;

    @SerializedName("imdbId")           private String imdbId;
    @SerializedName("zap2itId")         private String zap2itId;
    /* @SerializedName("seriesId")         private int seriesId; --> is wrong? */

    @Override
    public String toString() {
        return "Series{" +
                "seriesId="                 + getSeriesId()              +
                ", seriesLastUpdated="      + getSeriesLastUpdated()     +          /* TODO: FORMAT? */
                ", seriesAdded='"           + getSeriesAdded()           + '\'' +
                ", seriesAirsDayOfWeek='"   + getSeriesAirsDayOfWeek()   + '\'' +
                ", seriesAirsTime='"        + getSeriesAirsTime()        + '\'' +
                ", seriesBannerUrl='"       + getSeriesBannerUrl()       + '\'' +
                ", seriesFirstAired='"      + getSeriesFirstAired()      + '\'' +
                ", seriesNetwork='"         + getSeriesNetwork()         + '\'' +
                ", seriesNetworkId='"       + getSeriesNetworkId()       + '\'' +
                ", seriesDescription='"     + getSeriesDescription()     + '\'' +
                ", seriesRating='"          + getSeriesRating()          + '\'' +
                ", seriesRuntime='"         + getSeriesRuntime()         + '\'' +
                ", seriesName='"            + getSeriesName()            + '\'' +
                ", seriesStatus='"          + getSeriesStatus()          + '\'' +
                ", seriesAliases="          + getSeriesAliases()         +
                ", seriesGenre="            + getSeriesGenre()           +
                ", siteRating="             + getSiteRating()            +
                ", siteRatingCount="        + getSiteRatingCount()       +
                ", imdbId='"                + getImdbId()                + '\'' +
                ", zap2itId='"              + getZap2itId()              + '\'' +
                '}';
    }

    public Series getSeries() {
        return series;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public int getSeriesLastUpdated() {
        return seriesLastUpdated;
    }

    public String getSeriesAdded() {
        return seriesAdded;
    }

    public String getSeriesAirsDayOfWeek() {
        return seriesAirsDayOfWeek;
    }

    public String getSeriesAirsTime() {
        return seriesAirsTime;
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

    public String getSeriesNetworkId() {
        return seriesNetworkId;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public String getSeriesRating() {
        return seriesRating;
    }

    public String getSeriesRuntime() {
        return seriesRuntime;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesStatus() {
        return seriesStatus;
    }

    public List<String> getSeriesAliases() {
        return seriesAliases;
    }

    public List<String> getSeriesGenre() {
        return seriesGenre;
    }

    public double getSiteRating() {
        return siteRating;
    }

    public int getSiteRatingCount() {
        return siteRatingCount;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getZap2itId() {
        return zap2itId;
    }
}
