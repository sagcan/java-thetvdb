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
 * @see <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_episodes">For a better description</a>
 */
public class Episode {
    @SerializedName("data")                 private List<Episode> episodes = new ArrayList<>();

    @SerializedName("id")                   private int episodeId;
    @SerializedName("airedEpisodeNumber")   private int episodeNumber;
    @SerializedName("absoluteNumber")       private int absoluteEpisodeNumber;
    @SerializedName("airedSeason")          private int seasonNumber;
    @SerializedName("lastUpdated")          private int episodeLastUpdated;     /* TODO: FORMAT? */
    @SerializedName("episodeName")          private String episodeName;
    @SerializedName("overview")             private String episodeDescription;
    @SerializedName("firstAired")           private String episodeFirstAired;

    @SerializedName("dvdEpisodeNumber")     private int dvdEpisodeNumber;
    @SerializedName("dvdSeason")            private int dvdSeasonNumber;

    @Override
    public String toString() {
        return "Episode{"                   +
                "episodeId="              + getEpisodeId()             +
                ", episodeNumber="          + getEpisodeNumber()         +
                ", absoluteEpisodeNumber="  + getAbsoluteEpisodeNumber() +
                ", seasonNumber="           + getSeasonNumber()          +
                ", episodeLastUpdated="     + getEpisodeLastUpdated()    +
                ", episodeName='"           + getEpisodeName()           + '\'' +
                ", episodeDescription='"    + getEpisodeDescription()    + '\'' +
                ", episodeFirstAired='"     + getEpisodeFirstAired()     + '\'' +
                ", dvdEpisodeNumber="       + getDvdEpisodeNumber()      +
                ", dvdSeasonNumber="        + getDvdSeasonNumber()       +
                '}';
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public int getEpisodeId() {
        return episodeId;
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

    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    public int getDvdSeasonNumber() {
        return dvdSeasonNumber;
    }
}
