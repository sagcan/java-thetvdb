package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkan on 30.06.17.
 */

public class Episode {
    @SerializedName("data")                 private List<Episode> episodes = new ArrayList<>();

    @SerializedName("absoluteNumber")       private int absoluteNumber;
    @SerializedName("airedEpisodeNumber")   private int airedEpisodeNumber;
    @SerializedName("airedSeason")          private int airedSeason;
    @SerializedName("dvdEpisodeNumber")     private int dvdEpisodeNumber;
    @SerializedName("dvdSeason")            private int dvdSeason;
    @SerializedName("id")                   private int id;
    @SerializedName("lastUpdated")          private int lastUpdated;
    @SerializedName("episodeName")          private String episodeName;
    @SerializedName("firstAired")           private String firstAired;
    @SerializedName("overview")             private String overview;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
