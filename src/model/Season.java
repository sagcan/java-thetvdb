package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkan on 30.06.17.
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
