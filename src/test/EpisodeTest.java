package test;

import model.Episode;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the Episode class.
 */
public class EpisodeTest extends BaseTestClass {

    public EpisodeTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testEpisode() throws IOException, AuthenticationException {
        Episode episode = theTVDBAPI.getSeasons(121361).get(1).getEpisodes().get(0);

        assertThat(episode.getEpisodeId()).isPositive();
        assertThat(episode.getEpisodeNumber()).isPositive();
        assertThat(episode.getAbsoluteEpisodeNumber()).isPositive();
        assertThat(episode.getSeasonNumber()).isPositive();
        assertThat(episode.getEpisodeLastUpdated()).isPositive();

        assertThat(episode.getDvdSeasonNumber()).isPositive();
        assertThat(episode.getDvdEpisodeNumber()).isPositive();

        assertThat(episode.getEpisodeName()).isNotEmpty();
        assertThat(episode.getEpisodeDescription()).isNotEmpty();
        assertThat(episode.getEpisodeFirstAired()).isNotEmpty();
    }
}
