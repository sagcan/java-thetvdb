import com.google.gson.Gson;
import model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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

/* TODO: SINGLETON */
/* TODO: CHECK IF SESSIONTOKEN IS VALID */
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

    private TheTVDBAPI(String username, String userkey, String apikey) throws IOException {
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
            System.out.println(sessionToken);
        } else {
            /* Response was not successful */
            System.out.println("Unauthorized");
            /* TODO: THROW CUSTOM EXCEPTION WITH STATUS CODE */
            /* TODO: SUPPORT FOR MORE STATUS CODES */
        }

        /* Finally convert the JSON formatted session token to a String and initialize the httpGet object with it */
        /* Furthermore the httpGet object wont be re-initialized from now on, as it contains the session token */
        sessionToken = gson.fromJson(sessionToken, Session.class).getToken();
        httpGet = new HttpGet();
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + sessionToken);
    }

    public static TheTVDBAPI getInstance(String username, String userkey, String apikey) throws IOException {
        if (TheTVDBAPI.theTVDBAPI == null) {
            TheTVDBAPI.theTVDBAPI = new TheTVDBAPI(username, userkey, apikey);
        }

        return TheTVDBAPI.theTVDBAPI;
    }

    public static void main(String[] args) throws IOException {
        TheTVDBAPI theTVDBAPI = TheTVDBAPI.getInstance("volsa", "27C486A62FE8CDEF", "E25C7E48E6B80084");
        System.out.println(theTVDBAPI.getImages(277165, ImageType.POSTER).get(1).getUrl());
        System.out.println(theTVDBAPI.getImages(277165, ImageType.FANART).get(1).getUrl());
        System.out.println(theTVDBAPI.getImages(277165, ImageType.SEASON).get(1).getUrl());
        System.out.println(theTVDBAPI.getImages(277165, ImageType.SERIES).get(1).getUrl());
//        System.out.println(theTVDBAPI.searchSeries("Silicon Valley").get(0).toString());
//        System.out.println(theTVDBAPI.getSeries(277165).toString());
//        System.out.println(theTVDBAPI.getActors(277165).get(0).toString());
//        List<Season> seasons = theTVDBAPI.getSeasons(277165);
//        for (int j = 0; j < seasons.size(); j++) {
//            for (int i = 0; i < seasons.get(j).getEpisodes().size(); i++) {
//                System.out.println(
//                        "Season: " + j + "; " +
//                        "Episode: " + seasons.get(j).getEpisodes().get(i).getAiredEpisodeNumber() + "; " +
//                                seasons.get(j).getEpisodes().get(i).getEpisodeName()
//                );
//            }
//            System.out.println();
//        }
        System.out.println(theTVDBAPI.getSpecificEpisode(4765079).getOverview());

    }

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
            if (e.getAiredSeason() > totalSeasons)
                totalSeasons = e.getAiredSeason();
        }

        /* Wrap all the give episode objects into a list of season objects and return it */
        List<Season> seasons = new ArrayList<>();

        for (int i = 0; i <= totalSeasons; i++) {
            Season tempSeasonObject = new Season();
            List<Episode> tempEpisodes = tempEpisodes = new ArrayList<>();
            for (int j = 0; j < episodes.size(); j++) {
                if (episodes.get(j).getAiredSeason() == i)
                    tempEpisodes.add(episodes.get(j));
            }
            tempSeasonObject.setEpisodes(tempEpisodes);
            seasons.add(tempSeasonObject);
        }

        return seasons;
    }

    public List<Image> getImages(int seriesId, ImageType type) throws IOException {
        /* Prepare the URL */
        String url = BASE_URL + PATH_SERIES + PATH_IMAGES;
        System.out.println(type.name());
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

}
