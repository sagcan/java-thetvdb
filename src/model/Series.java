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

    @SerializedName("id")               private int id;
    @SerializedName("lastUpdated")      private int lastUpdated; /* TODO */
    @SerializedName("seriesId")         private int seriesId;
    @SerializedName("siteRating")       private double siteRating;
    @SerializedName("siteRatingCount")  private int siteRatingCount;
    @SerializedName("added")            private String added;
    @SerializedName("airsDayOfWeek")    private String airsDayOfWeek;
    @SerializedName("airsTime")         private String airsTime;
    @SerializedName("banner")           private String banner;
    @SerializedName("firstAired")       private String firstAired;
    @SerializedName("imdbId")           private String imdbId;
    @SerializedName("network")          private String network;
    @SerializedName("networkId")        private String networkId;
    @SerializedName("overview")         private String overview;
    @SerializedName("rating")           private String rating;
    @SerializedName("runtime")          private String runtime;
    @SerializedName("seriesName")       private String seriesName;
    @SerializedName("status")           private String status;
    @SerializedName("zap2itId")         private String zap2itId;
    @SerializedName("aliases")          private List<String> aliases;
    @SerializedName("genre")            private List<String> genre;

    public String toString() {
        return  getId()                 + "\n" +
                getLastUpdated()        + "\n" +
                getSeriesId()           + "\n" +
                getSiteRating()         + "\n" +
                getSiteRatingCount()    + "\n" +
                getAdded()              + "\n" +
                getAirsDayOfWeek()      + "\n" +
                getAirsTime()           + "\n" +
                getBanner()             + "\n" +
                getFirstAired()         + "\n" +
                getImdbId()             + "\n" +
                getNetwork()            + "\n" +
                getNetworkId()          + "\n" +
                getOverview()           + "\n" +
                getRating()             + "\n" +
                getRuntime()            + "\n" +
                getSeriesName()         + "\n" +
                getStatus()             + "\n" +
                getZap2itId()           + "\n" +
                getAliases()            + "\n" +
                getGenre()              + "\n";
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public double getSiteRating() {
        return siteRating;
    }

    public void setSiteRating(double siteRating) {
        this.siteRating = siteRating;
    }

    public int getSiteRatingCount() {
        return siteRatingCount;
    }

    public void setSiteRatingCount(int siteRatingCount) {
        this.siteRatingCount = siteRatingCount;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getAirsDayOfWeek() {
        return airsDayOfWeek;
    }

    public void setAirsDayOfWeek(String airsDayOfWeek) {
        this.airsDayOfWeek = airsDayOfWeek;
    }

    public String getAirsTime() {
        return airsTime;
    }

    public void setAirsTime(String airsTime) {
        this.airsTime = airsTime;
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

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZap2itId() {
        return zap2itId;
    }

    public void setZap2itId(String zap2itId) {
        this.zap2itId = zap2itId;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
