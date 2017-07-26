package api;

import com.google.gson.Gson;
import model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* TODO: CHECK IF SESSIONTOKEN IS VALID */

/**
 * @author Volkan Sagcan
 * @version 1.0
 *          This class represents the unofficial Java wrapper for the "thetvdb JSON-API".
 *          Using the singleton design pattern, it first creates a session token (TODO, auto-detect valid token)
 *          upon creating an instance, which it later needs / uses for a successful communication with the JSON-API.
 *          Furthermore JSON parsing is done with the GSON library while HTTP communications are done with the Apache HttpClient
 *          library.
 *          <p>
 *          As of now the following API calls are supported:
 *          <ul>
 *          <li> search and receive a list of series with basic information such as the name, description, seriesId, etc...
 *          <li> receive detailed information of a <b>specific</b> series via its seriesId
 *          <li> receive detailed information of a <b>specific</b> episode of a series via its seriesId
 *          <li> receive a list of actors of a <b>specific</b> series via its seriesId
 *          <li> receive a list of seasons of a <b>specific</b> series via its seriesId
 *          <li> receive a list of images of a <b>specific</b> series via its seriesId
 *          </ul>
 */
public class TheTVDBAPI {
    private static final String BASE_URL                = "https://api.thetvdb.com";
    private static final String PATH_AUTHENTICATE       = "/login";
    private static final String PATH_ACTORS             = "/actors";
    private static final String PATH_EPISODES           = "/episodes";
    private static final String PATH_EPISODES_DETAILED  = "/episodes/$ID";
    private static final String PATH_SERIES             = "/series/$ID";
    private static final String PATH_IMAGES             = "/images/query?keyType=$KEYTYPE";
    private static final String PATH_SEARCH             = "/search/series?name=$NAME";

    private static TheTVDBAPI theTVDBAPI;

    private Gson gson;
    private User user;
    private String sessionToken;

    private HttpClient httpClient;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse httpResponse;
    private HttpEntity httpEntity;

    /**
     * The constructor of this class is used to obtain a session token with the help of a HttpClient, HttpPost, HttpResponse and GSON
     * object. At first a connection between both participants is created. After the connection a POST method is sent
     * which contains authentication data in its entity header. If the data is correct, a 2xx status code should have been received
     * alongside the actual session token (in JSON format). Finally the token will be extracted from the JSON-formatted response with
     * the help of the GSON library.
     *
     * @param username of a TheTVDB.com account
     * @param userkey of the TheTVDB.com user
     * @param apikey of the TheTVDB.com user
     * @throws IOException either because of unsupported encoding at the StringEntity object, an unsuccessful httpClient
     * execution or an unsuccessful conversion from an Entity to a String
     */
    private TheTVDBAPI(String username, String userkey, String apikey) throws AuthenticationException, IOException {
        /* Initialize needed objects for API */
        httpClient = HttpClientBuilder.create().build();
        httpGet = new HttpGet();
        user = new User(username, userkey, apikey);
        gson = new Gson();

        /* Format username, userkey and apikey to JSON */
        StringEntity authenticationJSON = new StringEntity(gson.toJson(user));

        /* Prepare HTTP POST method and add said JSON to (HTTP)Entity-Header */
        httpPost = new HttpPost(BASE_URL + PATH_AUTHENTICATE);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        httpPost.setEntity(authenticationJSON);

        /* Execute HTTP POST method, receive entity from response and extract the session token (=JSON) from said entity */
        /* For more information see: https://stackoverflow.com/questions/9197745/what-exactly-is-an-http-entity */
        httpResponse = httpClient.execute(httpPost);
        int httpStatuscode = httpResponse.getStatusLine().getStatusCode();

        if (httpStatuscode >= 200 && httpStatuscode <= 226) {
            /* Response was successful, therefore we can extract the sessionToken */
            httpEntity = httpResponse.getEntity();
            sessionToken = EntityUtils.toString(httpEntity, "UTF-8");
        } else if (httpStatuscode >= 400 && httpStatuscode < 499) {
            /* Response was not successful (status code between 400 and 499) */
            throw new AuthenticationException("An authentication with the given credentials was most likely unsuccessful (HTTP status code: " + httpStatuscode + ")");
        } else {
            /* TODO: SUPPORT MORE HTTP STATUS CODES */
        }

        /* Finally convert the JSON formatted session token to a String and initialize the httpGet object with it */
        /* Furthermore the httpGet object wont be re-initialized from now on, as it contains the session token */
        sessionToken = gson.fromJson(sessionToken, Session.class).getToken();
        httpGet = new HttpGet();
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + sessionToken);
        /* System.out.println(sessionToken); */
    }

    /**
     * Returns one, and only one, object of the wrapper.TheTVDBAPI class (singleton pattern) by checking the status of a
     * static wrapper.TheTVDBAPI object (if initialized return the object, else initialize one and return it).
     *
     * @param username  of a TheTVDB.com account (see <a href="http://thetvdb.com/?tab=userinfo">TheTVDB account page</a>
     * @param userkey   of a TheTVDB.com account (see <a href="http://thetvdb.com/?tab=userinfo">TheTVDB account page</a>)
     * @param apikey    of a TheTVDB.com account (must be manually created at the <a href="http://thetvdb.com/?tab=userinfo">TheTVDB account page</a>)
     * @return          one, and only one, intialized wrapper.TheTVDBAPI object
     * @throws IOException either if the httpClient execution was unsuccessful or the StringEntity object detects unsupported encoding
     */
    public static TheTVDBAPI getInstance(String username, String userkey, String apikey) throws IOException, AuthenticationException {
        if (TheTVDBAPI.theTVDBAPI == null) {
            /* A static wrapper.TheTVDBAPI does not exist therefore initialize one */
            TheTVDBAPI.theTVDBAPI = new TheTVDBAPI(username, userkey, apikey);
        }

        return TheTVDBAPI.theTVDBAPI;
    }

    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id">API call</a> which
     * returns a Series object, that contains detailed information about a series.
     *
     * @param seriesId id of a series obtained via the {@link #searchSeries(String)} method
     * @return a Series object
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public Series getSeries(int seriesId) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SERIES;
        url = url.replace("$ID", String.valueOf(seriesId));

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Finally translate the JSON response to object(s) and return it */
        return gson.fromJson(body, Series.class).getSeries();
    }

    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Episodes/get_episodes_id">API call</a> which
     * returns a EpisodeDetailed object that contains detailed information of a specific episode.
     *
     * @param episodeId id of a episode obtained via the {@link #getSeasons(int)} method
     * @return a EpisodeDetailed object
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public EpisodeDetailed getSpecificEpisode(int episodeId) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_EPISODES_DETAILED;
        url = url.replace("$ID", String.valueOf(episodeId));

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Finally translate the JSON response to object(s) and return it */
        return gson.fromJson(body, EpisodeDetailed.class).getEpisodeDetailed();
    }


    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Search/get_search_series">API call</a> which
     * returns a list of SearchResult objects. More importantly this method returns a seriesId for each
     * object which is needed for most API calls.
     *
     * @param seriesName name of series
     * @return a list of SearchResult objects
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public List<SearchResult> searchSeries(String seriesName) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SEARCH;
        seriesName = seriesName.replaceAll(" ", "%20");
        url = url.replace("$NAME", seriesName);

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Finally translate the JSON response to object(s) and return it */
        return gson.fromJson(body, SearchResult.class).getSearchResults();
    }

    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_actors">API call</a> which
     * returns a list of Actor objects of a specific series.
     *
     * @param seriesId id of a series obtained via the {@link #searchSeries(String)} method
     * @return a list of Actor objects
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public List<Actor> getActors(int seriesId) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SERIES + PATH_ACTORS;
        url = url.replace("$ID", String.valueOf(seriesId));

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Finally translate the JSON response to object(s) and return it */
        return gson.fromJson(body, Actor.class).getActors();

    }

    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_episodes">API call</a> which
     * returns a list of Episode objects of a specific series. Furthermore this method - appart from converting the JSON
     * response to Episode objects - bundles the given Episode objects into a list of season objects for obvious reasons.
     * This means no more uncategorized/ chaotic episode objects.
     *
     * @param seriesId obtained via the {@link #searchSeries(String)} method
     * @return a list of Season objects
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public List<Season> getSeasons(int seriesId) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SERIES + PATH_EPISODES;
        url = url.replace("$ID", String.valueOf(seriesId));

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Translate the JSON response to object(s) */
        List<Episode> episodes = gson.fromJson(body, Episode.class).getEpisodes();

        /* Get the total number of seasons */
        int totalSeasons = 0;

        for (Episode e : episodes) {
            if (e.getSeasonNumber() > totalSeasons)
                totalSeasons = e.getSeasonNumber();
        }

        /* Wrap all the give episode objects into a list of season objects and return it */
        List<Season> seasons = new ArrayList<>();

        for (int i = 0; i <= totalSeasons; i++) {
            Season tempSeasonObject = new Season();
            List<Episode> tempEpisodes = new ArrayList<>();
            for (int j = 0; j < episodes.size(); j++) {
                if (episodes.get(j).getSeasonNumber() == i)
                    tempEpisodes.add(episodes.get(j));
            }
            tempSeasonObject.setEpisodes(tempEpisodes);
            seasons.add(tempSeasonObject);
        }

        return seasons;
    }

    /**
     * Represents this <a href="https://api.thetvdb.com/swagger#!/Series/get_series_id_images_query">API call</a> which
     * returns a list of Image objects of a specific series.
     *
     * @param seriesId obtained via the {@link #searchSeries(String)} method
     * @param type of image (enum with fanart, poster, series or season attributes)
     * @return a list of Image objects
     * @throws IOException either because of an unsuccessful HttpClient execution or an unsuccessful conversion from an entity to a String
     */
    public List<Image> getImages(int seriesId, ImageType type) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SERIES + PATH_IMAGES;
        url = url.replace("$ID", String.valueOf(seriesId));
        url = url.replace("$KEYTYPE", type.name().toLowerCase());

        /* Execute the GET Method, receive a JSON response from the server and convert it to a String */
        httpGet.setURI(URI.create(url));
        httpResponse = httpClient.execute(httpGet);
        httpEntity = httpResponse.getEntity();
        String body = EntityUtils.toString(httpEntity, "UTF-8");

        /* Finally translate the JSON response to object(s) and return it */
        return gson.fromJson(body, Image.class).getImages();
    }
}
