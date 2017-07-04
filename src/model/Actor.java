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
 * @see <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_actors">For a better description</a>
 */
public class Actor {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")         private List<Actor> actors = new ArrayList<>();

    @SerializedName("seriesId")     private int seriesId;
    @SerializedName("id")           private int actorId;
    @SerializedName("imageAuthor")  private int imageAuthorId;
    @SerializedName("image")        private String imageUrl;
    @SerializedName("imageAdded")   private String imageAdded;
    @SerializedName("lastUpdated")  private String imageLastUpdated;
    @SerializedName("name")         private String actorName;
    @SerializedName("role")         private String actorRole;

    @Override
    public String toString() {
        return "Actor{" +
                "seriesId="             + getSeriesId()          +
                ", actorId="            + getActorId()           +
                ", imageAuthorId="      + getImageAuthorId()     +
                ", imageUrl='"          + getImageUrl()          + '\'' +
                ", imageAdded='"        + getImageAdded()        + '\'' +
                ", imageLastUpdated='"  + getImageLastUpdated()  + '\'' +
                ", actorName='"         + getActorName()         + '\'' +
                ", actorRole='"         + getActorRole()         + '\'' +
                '}';
    }

    public List<Actor> getActors() {
        return actors;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public int getActorId() {
        return actorId;
    }

    public int getImageAuthorId() {
        return imageAuthorId;
    }

    public String getImageUrl() {
        return IMAGE_BASE_URL + imageUrl;
    }

    public String getImageAdded() {
        return imageAdded;
    }

    public String getImageLastUpdated() {
        return imageLastUpdated;
    }

    public String getActorName() {
        return actorName;
    }

    public String getActorRole() {
        return actorRole;
    }
}
