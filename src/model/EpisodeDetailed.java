package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by volkan on 01.07.17.
 */
public class EpisodeDetailed {
    @SerializedName("data")
    private EpisodeDetailed episodeDetailed;

    @SerializedName("id")                   private int id;
    @SerializedName("absoluteNumber")       private int absoluteNumber;
    @SerializedName("airedEpisodeNumber")   private int airedEpisodeNumber;
    @SerializedName("airedSeason")          private int airedSeason;
    @SerializedName("airsAfterSeason")      private int airsAfterSeason;
    @SerializedName("airsBeforeEpisode")    private int airsBeforeEpisode;
    @SerializedName("airsBeforeSeason")     private int airsBeforeSeason;
    @SerializedName("dvdChapter")           private int dvdChapter;
    @SerializedName("dvdEpisodeNumber")     private int dvdEpisodeNumber;
    @SerializedName("dvdSeason")            private int dvdSeason;
    @SerializedName("lastUpdated")          private int lastUpdated;
    @SerializedName("thumbAuthor")          private int thumbAuthor;
    @SerializedName("siteRatingCount")      private int siteRatingCount;
    @SerializedName("siteRating")           private double siteRating;
    @SerializedName("director")             private String director;
    @SerializedName("dvdDiscid")            private String dvdDiscid;
    @SerializedName("episodeName")          private String episodeName;
    @SerializedName("fileName")             private String filename;
    @SerializedName("firstAired")           private String firstAired;
    @SerializedName("imdbId")               private String imdbId;
    @SerializedName("lastUpdatedBy")        private String lastUpdatedBy;
    @SerializedName("overview")             private String overview;
    @SerializedName("productionCode")       private String productionCode;
    @SerializedName("seriesId")             private String seriesId;
    @SerializedName("showUrl")              private String showUrl;
    @SerializedName("thumbAdded")           private String thumbAdded;
    @SerializedName("thumbHeight")          private String thumbHeight;
    @SerializedName("thumbWidth")           private String thumbWidth;
    @SerializedName("directors")            private List<String> directors;
    @SerializedName("guestStars")           private List<String> guestStars;
    @SerializedName("writers")              private List<String> writers;

    public EpisodeDetailed getEpisodeDetailed() {
        return episodeDetailed;
    }

    public void setEpisodeDetailed(EpisodeDetailed episodeDetailed) {
        this.episodeDetailed = episodeDetailed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    public void setAbsoluteNumber(int absoluteNumber) {
        this.absoluteNumber = absoluteNumber;
    }

    public int getAiredEpisodeNumber() {
        return airedEpisodeNumber;
    }

    public void setAiredEpisodeNumber(int airedEpisodeNumber) {
        this.airedEpisodeNumber = airedEpisodeNumber;
    }

    public int getAiredSeason() {
        return airedSeason;
    }

    public void setAiredSeason(int airedSeason) {
        this.airedSeason = airedSeason;
    }

    public int getAirsAfterSeason() {
        return airsAfterSeason;
    }

    public void setAirsAfterSeason(int airsAfterSeason) {
        this.airsAfterSeason = airsAfterSeason;
    }

    public int getAirsBeforeEpisode() {
        return airsBeforeEpisode;
    }

    public void setAirsBeforeEpisode(int airsBeforeEpisode) {
        this.airsBeforeEpisode = airsBeforeEpisode;
    }

    public int getAirsBeforeSeason() {
        return airsBeforeSeason;
    }

    public void setAirsBeforeSeason(int airsBeforeSeason) {
        this.airsBeforeSeason = airsBeforeSeason;
    }

    public int getDvdChapter() {
        return dvdChapter;
    }

    public void setDvdChapter(int dvdChapter) {
        this.dvdChapter = dvdChapter;
    }

    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    public void setDvdEpisodeNumber(int dvdEpisodeNumber) {
        this.dvdEpisodeNumber = dvdEpisodeNumber;
    }

    public int getDvdSeason() {
        return dvdSeason;
    }

    public void setDvdSeason(int dvdSeason) {
        this.dvdSeason = dvdSeason;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getThumbAuthor() {
        return thumbAuthor;
    }

    public void setThumbAuthor(int thumbAuthor) {
        this.thumbAuthor = thumbAuthor;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDvdDiscid() {
        return dvdDiscid;
    }

    public void setDvdDiscid(String dvdDiscid) {
        this.dvdDiscid = dvdDiscid;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getThumbAdded() {
        return thumbAdded;
    }

    public void setThumbAdded(String thumbAdded) {
        this.thumbAdded = thumbAdded;
    }

    public String getThumbHeight() {
        return thumbHeight;
    }

    public void setThumbHeight(String thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    public String getThumbWidth() {
        return thumbWidth;
    }

    public void setThumbWidth(String thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(List<String> guestStars) {
        this.guestStars = guestStars;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }
}

