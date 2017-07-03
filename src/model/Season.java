package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * This class will be used to bundle episode objects into their respective seasons
 */
public class Season {
    private List<Episode> episodes = new ArrayList<>();

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
