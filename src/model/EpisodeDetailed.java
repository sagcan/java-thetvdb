package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * This class will be used for a GSON de-serialization (a.k.a POJO class).
 *
 * @see <a href="https://api.thetvdb.com/swagger#!/Episodes/get_episodes_id">For a better description</a>
 */
public class EpisodeDetailed {
    @SerializedName("data")                 private EpisodeDetailed episodeDetailed;

    @SerializedName("id")                   private int episodeId;
    @SerializedName("seriesId")             private String seriesId;
    @SerializedName("imdbId")               private String imdbId;
    @SerializedName("airedEpisodeNumber")   private int episodeNumber;
    @SerializedName("absoluteNumber")       private int absoluteEpisodeNumber;
    @SerializedName("airedSeason")          private int seasonNumber;
    @SerializedName("lastUpdated")          private int episodeLastUpdated;     /* TODO: FORMAT? */
    @SerializedName("episodeName")          private String episodeName;
    @SerializedName("overview")             private String episodeDescription;
    @SerializedName("firstAired")           private String episodeFirstAired;
    @SerializedName("siteRating")           private double siteRating;
    @SerializedName("siteRatingCount")      private int siteRatingVotes;

    @SerializedName("directors")            private List<String> directors;
    @SerializedName("guestStars")           private List<String> guestStars;
    @SerializedName("writers")              private List<String> writers;

    @SerializedName("dvdEpisodeNumber")     private int dvdEpisodeNumber;
    @SerializedName("dvdSeason")            private int dvdSeasonNumber;

    /*
    Seems like unnecessary information, therefore those attributes are ignored in order to keep everything
    a bit minimal.
    ------------------------------------------------------------------------------------------------------
    @SerializedName("airsAfterSeason")      private int airsAfterSeason;
    @SerializedName("airsBeforeEpisode")    private int airsBeforeEpisode;
    @SerializedName("airsBeforeSeason")     private int airsBeforeSeason;
    @SerializedName("dvdChapter")           private int dvdChapter;
    @SerializedName("thumbAuthor")          private int thumbAuthor;
    @SerializedName("dvdDiscid")            private String dvdDiscid;
    @SerializedName("lastUpdatedBy")        private String lastUpdatedBy;
    @SerializedName("thumbAdded")           private String thumbAdded;
    @SerializedName("thumbHeight")          private String thumbHeight;
    @SerializedName("thumbWidth")           private String thumbWidth;
    @SerializedName("productionCode")       private String productionCode;
    @SerializedName("showUrl")              private String showUrl;
    @SerializedName("fileName")             private String filename;
    @SerializedName("director")             private String director;
    */

    @Override
    public String toString() {
        return "EpisodeDetailed{"           +
                "episodeId="              + getEpisodeId()                +
                ", episodeNumber="          + getEpisodeNumber()            +
                ", absoluteEpisodeNumber="  + getAbsoluteEpisodeNumber()    +
                ", seasonNumber="           + getSeasonNumber()             +
                ", episodeLastUpdated="     + getEpisodeLastUpdated()       +
                ", episodeName='"           + getEpisodeName()              + '\'' +
                ", episodeDescription='"    + getEpisodeDescription()       + '\'' +
                ", episodeFirstAired='"     + getEpisodeFirstAired()        + '\'' +
                ", dvdEpisodeNumber="       + getDvdEpisodeNumber()         +
                ", dvdSeasonNumber="        + getDvdSeasonNumber()          +
                ", siteRatingVotes="        + getSiteRatingVotes()          +
                ", siteRating="             + getSiteRating()               +
                ", imdbId='"                + getImdbId()                   + '\'' +
                ", seriesId='"              + getSeriesId()                 + '\'' +
                ", directors="              + getDirectors()                +
                ", guestStars="             + getGuestStars()               +
                ", writers="                + getWriters()                  +
                '}';
    }

    public EpisodeDetailed getEpisodeDetailed() {
        return episodeDetailed;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    /**
     * Ignores re-indexing by seasons. For example Season 2 Episode 3 would return the number 13 as compared with
     * {@link #getEpisodeNumber()} which would return 3 (Season 1 has 10 episodes, therefore 10 + 3).
     */
    public int getAbsoluteEpisodeNumber() {
        return absoluteEpisodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeLastUpdated() {
        return episodeLastUpdated;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public String getEpisodeDescription() {
        return episodeDescription;
    }

    public String getEpisodeFirstAired() {
        return episodeFirstAired;
    }

    public double getSiteRating() {
        return siteRating;
    }

    public int getSiteRatingVotes() {
        return siteRatingVotes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getGuestStars() {
        return guestStars;
    }

    public List<String> getWriters() {
        return writers;
    }

    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    public int getDvdSeasonNumber() {
        return dvdSeasonNumber;
    }
}

