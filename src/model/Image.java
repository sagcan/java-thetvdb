package model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkan on 01.07.17.
 */
/* TODO: ratingsInfo attribute ignored */
public class Image {
    private static final String IMAGE_BASE_URL = "https://thetvdb.com/banners/";

    @SerializedName("data")         private List<Image> images = new ArrayList<>();

    @SerializedName("id")           private int id;
    @SerializedName("languageId")   private int languageId;
    @SerializedName("url")          private String url;
    @SerializedName("keyType")      private String keyType;
    @SerializedName("resolution")   private String resolution;
    @SerializedName("subKey")       private String subKey;
    @SerializedName("thumbnail")    private String thumbnail;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getUrl() {
        return IMAGE_BASE_URL + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSubKey() {
        return subKey;
    }

    public void setSubKey(String subKey) {
        this.subKey = subKey;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
