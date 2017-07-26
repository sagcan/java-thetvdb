package test;

import model.SearchResult;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the SearchResult class.
 */
public class SearchResultTest extends BaseTestClass {

    public SearchResultTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testSearchResult() throws IOException, AuthenticationException {
        SearchResult searchResult = theTVDBAPI.searchSeries("Game of Thrones").get(0);

        assertThat(searchResult.getSeriesId()).isPositive();

        assertThat(searchResult.getSeriesAliases()).isEmpty();

        assertThat(searchResult.getSeriesName()).isNotEmpty();
        assertThat(searchResult.getSeriesBannerUrl()).isNotEmpty();
        assertThat(searchResult.getSeriesFirstAired()).isNotEmpty();
        assertThat(searchResult.getSeriesNetwork()).isNotEmpty();
        assertThat(searchResult.getSeriesStatus()).isNotEmpty();
        assertThat(searchResult.getSeriesDescription()).isNotEmpty();
    }
}
