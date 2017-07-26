package test;

import model.Series;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the Series class.
 */
public class SeriesTest extends BaseTestClass {

    public SeriesTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testSeries() throws IOException, AuthenticationException {
        Series series = theTVDBAPI.getSeries(121361);

        assertThat(series.getSeriesId()).isPositive();
        assertThat(series.getSeriesLastUpdated()).isPositive();
        assertThat(series.getSiteRating()).isPositive();
        assertThat(series.getSiteRatingCount()).isPositive();
        assertThat(series.getSeriesRuntime()).isPositive();

        assertThat(series.getSeriesAdded()).isNotEmpty();
        assertThat(series.getSeriesAirsDayOfWeek()).isNotEmpty();
        assertThat(series.getSeriesAirsTime()).isNotEmpty();
        assertThat(series.getSeriesBannerUrl()).isNotEmpty();
        assertThat(series.getSeriesFirstAired()).isNotEmpty();
        assertThat(series.getSeriesNetwork()).isNotEmpty();
        assertThat(series.getSeriesNetworkId()).isEmpty();
        assertThat(series.getSeriesDescription()).isNotEmpty();
        assertThat(series.getSeriesRating()).isNotEmpty();
        assertThat(series.getSeriesName()).isNotEmpty();
        assertThat(series.getSeriesStatus()).isNotEmpty();
        assertThat(series.getImdbId()).isNotEmpty();
        assertThat(series.getZap2itId()).isEmpty();

        assertThat(series.getSeriesAliases()).isEmpty();
        assertThat(series.getSeriesGenre()).isNotEmpty();
    }
}
