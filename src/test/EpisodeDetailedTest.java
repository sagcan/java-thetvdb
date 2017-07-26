package test;

import model.EpisodeDetailed;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the EpisodeDetailed class.
 */
public class EpisodeDetailedTest extends BaseTestClass {

    public EpisodeDetailedTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testEpisodeDetailed() throws IOException, AuthenticationException {
        EpisodeDetailed episodeDetailed = theTVDBAPI.getSpecificEpisode(3254641);

        assertThat(episodeDetailed.getEpisodeId()).isPositive();
        assertThat(episodeDetailed.getSeriesId()).isPositive();
        assertThat(episodeDetailed.getEpisodeNumber()).isPositive();
        assertThat(episodeDetailed.getAbsoluteEpisodeNumber()).isPositive();
        assertThat(episodeDetailed.getSeasonNumber()).isPositive();
        assertThat(episodeDetailed.getEpisodeLastUpdated()).isPositive();
        assertThat(episodeDetailed.getSiteRating()).isPositive();
        assertThat(episodeDetailed.getSiteRatingVotes()).isPositive();
        assertThat(episodeDetailed.getDvdEpisodeNumber()).isPositive();
        assertThat(episodeDetailed.getDvdSeasonNumber()).isPositive();

        assertThat(episodeDetailed.getDirectors()).isNotEmpty();
        assertThat(episodeDetailed.getGuestStars()).isNotEmpty();
        assertThat(episodeDetailed.getWriters()).isNotEmpty();

        assertThat(episodeDetailed.getImdbId()).isNotEmpty();
        assertThat(episodeDetailed.getEpisodeName()).isNotEmpty();
        assertThat(episodeDetailed.getEpisodeDescription()).isNotEmpty();
        assertThat(episodeDetailed.getEpisodeFirstAired()).isNotEmpty();
    }
}
