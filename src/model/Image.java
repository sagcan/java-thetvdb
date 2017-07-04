package model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * This class will be used for a GSON de-serialization (a.k.a. POJO class).
 *
 * @see <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_images">For a better description</a>
 */
/* TODO: ratingsInfo attribute ignored */
public class Image {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")         private List<Image> images = new ArrayList<>();

    @SerializedName("id")           private int imageId;
    @SerializedName("url")          private String url;
    @SerializedName("keyType")      private String keyType;
    @SerializedName("resolution")   private String resolution;
    @SerializedName("thumbnail")    private String thumbnail;

    /*
    Seems like unnecessary information, therefore those attributes are ignored in order to keep everything
    a bit minimal.
    ------------------------------------------------------------------------------------------------------
    @SerializedName("languageId")   private int languageId;
    @SerializedName("subKey")       private String subKey;
     */

    @Override
    public String toString() {
        return "Image{" +
                "imageId="          + getImageId()      +
                ", url='"           + getUrl()          + '\'' +
                ", keyType='"       + getKeyType()      + '\'' +
                ", resolution='"    + getResolution()   + '\'' +
                ", thumbnail='"     + getThumbnail()    + '\'' +
                '}';
    }

    public List<Image> getImages() {
        return images;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUrl() {
        return getThumbnail().replace("_cache/", "");
    }

    public String getKeyType() {
        return keyType;
    }

    public String getResolution() {
        return resolution;
    }

    public String getThumbnail() {
        return IMAGE_BASE_URL + thumbnail;
    }
}
